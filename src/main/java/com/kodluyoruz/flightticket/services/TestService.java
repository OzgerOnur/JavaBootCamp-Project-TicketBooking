package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.exceptions.exceptionsType.NotFoundEntityException;
import com.kodluyoruz.flightticket.models.dto.GateRegDto;
import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.entity.GateReg;
import com.kodluyoruz.flightticket.models.entity.aboutAirport.Gate;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import com.kodluyoruz.flightticket.repositorys.GateRegRepository;
import com.kodluyoruz.flightticket.repositorys.GateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import static com.kodluyoruz.flightticket.models.mappers.FlightMapper.MAPPER_FLIGHT;

@Service
@RequiredArgsConstructor
public class TestService {
    private final GateRepository gateRepository;
    private final GateRegRepository gateRegRepository;


    public ResponseEntity<String> test(FlightCreateRequest flightCreateRequest) {
//        Flight flight = MAPPER_FLIGHT.createRequestToFlight(flightCreateRequest);
//        isGateValidAndAvailable(
//                flight.getFromAirportId()
//                , flight.getGateReg());

        return ResponseEntity.status(HttpStatus.OK).body("");
    }

//    public void isGateValidAndAvailable(Integer fromAirportId, GateReg gateReg) {
//        // gateid ile airport eşleşiyor mu
//        Gate gate = gateRepository.findByIdAndAirportId(gateReg.getGateId(), fromAirportId).orElseThrow(
//                () -> new NotFoundEntityException(fromAirportId + " And " + gateReg.getGateId() + "arent matched")
//        );
//
//        Boolean gaate = gateRegRepository.existsGateRegByGateIdAndStartingDateBetweenOrEndDateBetween(
//                        gate.getId(), gateReg.getStartingDate(), gateReg.getEndDate());
//                       // , gateReg.getStartingDate(), gateReg.getEndDate());
////                .orElseThrow(()->  new NotFoundEntityException("Gate of " + gate.getId() + " is Booked earlier ")
////                );
//    }

}
