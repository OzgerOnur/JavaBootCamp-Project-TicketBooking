package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.exceptions.exceptionsType.NotFoundEntityException;
import com.kodluyoruz.flightticket.models.dto.FlightDto;
import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import com.kodluyoruz.flightticket.models.requests.flight.FlightSearchRequestWithId;
import com.kodluyoruz.flightticket.models.requests.flight.FlightSearchRequestWithName;
import com.kodluyoruz.flightticket.models.requests.flight.FlightUpdateRequest;
import com.kodluyoruz.flightticket.repositorys.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.kodluyoruz.flightticket.models.mappers.FlightMapper.MAPPER_FLIGHT;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final PlaneService planeService;
    private final AirportService airportService;
    private final GateService gateService;


    public FlightDto createFlight(FlightCreateRequest flightCreateRequest) {
        Flight flight = MAPPER_FLIGHT.createRequestToFlight(flightCreateRequest);
        flightCrateValidetion(flight);
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

    private void flightCrateValidetion(Flight flight){
        planeService.isPlaneExist(flight.getPlaneId());
        airportService.isAirportExist(flight.getToAirportId());
        airportService.isAirportExist(flight.getFromAirportId());
        gateService.isGateValidAndAvailable(flight.getFromAirportId(),flight.getGateReg());
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
        return MAPPER_FLIGHT.flightToFlightDto(flightRepository.save(flight));
    }

    private Flight getFlightEntity(Integer id) {
        Flight flight = flightRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException(id + " Flight Not Found")
        );
        return flight;
    }
}
