package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.exceptions.exceptionsType.FlightAndGateRegDateException;
import com.kodluyoruz.flightticket.exceptions.exceptionsType.NotFoundEntityException;
import com.kodluyoruz.flightticket.models.dto.FlightDto;
import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import com.kodluyoruz.flightticket.models.requests.flight.FlightSearchRequestWithId;
import com.kodluyoruz.flightticket.models.requests.flight.FlightSearchRequestWithName;
import com.kodluyoruz.flightticket.models.requests.flight.FlightUpdateRequest;
import com.kodluyoruz.flightticket.repositories.FlightRepository;
import com.kodluyoruz.flightticket.repositories.PlaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.kodluyoruz.flightticket.models.mappers.FlightMapper.MAPPER_FLIGHT;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final PlaneRepository planeRepository;
    private final AirportService airportService;
    private final GateService gateService;


    public FlightDto createFlight(FlightCreateRequest flightCreateRequest) {
        Flight flight = MAPPER_FLIGHT.createRequestToFlight(flightCreateRequest);
        flightCrateValidation(flight);
        Flight createdFlight = createFlightEntity(flight);

        return MAPPER_FLIGHT.flightToFlightDto(createdFlight);
    }

   @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected Flight createFlightEntity(Flight flight) {
        Flight createdFlight = flightRepository.save(flight);
        createdFlight.getGateReg().setFlightId(createdFlight.getId());
        createdFlight = flightRepository.save(createdFlight);

        return createdFlight;
    }

    private void flightCrateValidation(Flight flight){
        isPlaneExist(flight.getPlaneId());
        airportService.isAirportExist(flight.getToAirportId());
        airportService.isAirportExist(flight.getFromAirportId());
        areFlightAndGateRegDateValid(flight);
        gateService.isGateValidAndAvailable(flight.getFromAirportId(),flight.getGateReg());
    }

    protected void isPlaneExist(Integer planeId) {
        planeRepository.findById(planeId).orElseThrow(() -> new NotFoundEntityException("Plane Not Found") );
    }

    public List<FlightDto> getFlightsWithName(FlightSearchRequestWithName flightSearchRequestWithName) {
       List<Flight> flights = searchFlightInRepoWithName(flightSearchRequestWithName);
        flights = flights.stream()
                .filter(flight -> flight.getSeats().size() < flight.getPlane().getCapacity())
                .collect(Collectors.toList());

        return MAPPER_FLIGHT.flightsToFlightDtos(flights);
    }

    public List<FlightDto> getFlightsWithId(FlightSearchRequestWithId flightSearchRequestWithId) {
        List<Flight> flights = searchFlightInRepoWithId(flightSearchRequestWithId );
        return MAPPER_FLIGHT.flightsToFlightDtos(flights);
    }

    private List<Flight> searchFlightInRepoWithName(FlightSearchRequestWithName flightSearchRequestWithName) {
        return flightRepository.findFlightWithName(
                flightSearchRequestWithName.getToAirport(),
                flightSearchRequestWithName.getFromAirport(),
                flightSearchRequestWithName.getToDate(),
                flightSearchRequestWithName.getFromDate());
    }

    private List<Flight> searchFlightInRepoWithId(FlightSearchRequestWithId flightSearchRequestWithId) {
        return flightRepository.findByToAirportIdAndFromAirportIdAndFlightDateBetween(
                flightSearchRequestWithId.getToAirportId(),
                flightSearchRequestWithId.getFromAirportId(),
                flightSearchRequestWithId.getToDate(),
                flightSearchRequestWithId.getFromDate());
    }

    public FlightDto getFlightWithId(Integer id) {
        Flight flight = getFlightEntity(id);
        return MAPPER_FLIGHT.flightToFlightDto(flight);
    }

    public void deleteFlight(Integer id) {
        flightRepository.deleteById(id);
    }

    public FlightDto updateFlight(Integer id, FlightUpdateRequest flightUpdateRequest) {
        Flight flight = getFlightEntity(id);
        MAPPER_FLIGHT.flightUpdateRequest(flight,flightUpdateRequest);
        flightUpdateValidation(flight);
        return MAPPER_FLIGHT.flightToFlightDto(flightRepository.save(flight));
    }

    private void flightUpdateValidation(Flight flight){
        isPlaneExist(flight.getPlaneId());
        airportService.isAirportExist(flight.getToAirportId());
        airportService.isAirportExist(flight.getFromAirportId());
        areFlightAndGateRegDateValid(flight);
        gateService.isGateValidAndAvailable(flight.getFromAirportId(),flight.getGateReg());
    }

    private void areFlightAndGateRegDateValid(Flight flight) {
        if(flight.getGateReg().getStartingDate().before(flight.getGateReg().getEndDate())
        && flight.getGateReg().getStartingDate().before(flight.getFlightDate())
        && flight.getGateReg().getEndDate().after(flight.getFlightDate())
        ){}
        else {
            throw new FlightAndGateRegDateException(flight);
        }

    }


    private Flight getFlightEntity(Integer id) {
        Flight flight = flightRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException(id + " Flight Not Found")
        );
        return flight;
    }


    protected List<Flight> getFlightWithInPlaneId(Integer planeId){
        return flightRepository.getFlightByPlaneId(planeId);
    }

    protected List<Flight> getFlightWithInPlaneIdAfterNow(Integer planeId){
        Date now = new Date();
        return flightRepository.getFlightByPlaneIdAndFlightDateAfter(planeId,now);
    }
}
