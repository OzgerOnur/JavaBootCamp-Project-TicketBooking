package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.models.dto.FlightDto;
import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import com.kodluyoruz.flightticket.repositorys.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
        //todo kayıt esnasında flight ID durumuna bak
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

}
