package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.models.entity.Seat;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import com.kodluyoruz.flightticket.repositories.GateRegRepository;
import com.kodluyoruz.flightticket.repositories.GateRepository;
import com.kodluyoruz.flightticket.repositories.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final GateRepository gateRepository;
    private final GateRegRepository gateRegRepository;
    private final SeatRepository seatRepository;


    public ResponseEntity<String> test(Integer flightId,Integer seatNumbber) {

//       Integer sayi =  seatRepository.countSeatByFlightIdEquals(flightId);
//       Boolean var = seatRepository.existsByFlightIdAndSeatNumber(flightId,seatNumbber);
//       Seat seat = seatRepository.findBySeatNumberEqualsAndFlightIdEquals(seatNumbber,flightId).orElse(null);
//       Integer sayi1Query = seatRepository.say1(flightId);
//        Integer sayi2Query = seatRepository.say2(flightId);
//        Integer sayi3Query = seatRepository.say3(flightId);


        return ResponseEntity.status(HttpStatus.OK).body("test");


//        Flight flight = MAPPER_FLIGHT.createRequestToFlight(flightCreateRequest);
//        isGateValidAndAvailable(
//                flight.getFromAirportId()
//                , flight.getGateReg());

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
