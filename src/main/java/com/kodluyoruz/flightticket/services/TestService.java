package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.models.dto.TicketDto;
import com.kodluyoruz.flightticket.models.entity.Passenger;
import com.kodluyoruz.flightticket.models.entity.Seat;
import com.kodluyoruz.flightticket.models.entity.Ticket;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import com.kodluyoruz.flightticket.models.requests.ticket.TicketCreateRequest;
import com.kodluyoruz.flightticket.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;

import static com.kodluyoruz.flightticket.models.mappers.TicketMapper.MAPPER_TICKET;

@Service
@RequiredArgsConstructor
public class TestService {
    private final GateRepository gateRepository;
    private final GateRegRepository gateRegRepository;
    private final SeatRepository seatRepository;
    private final PassengerRepository passengerRepository;
    private final TicketRepository ticketRepository;



    public TicketDto createTicket(TicketCreateRequest ticketCreateRequest) {
        Ticket ticket = MAPPER_TICKET.creatTicketRequestToTicket(ticketCreateRequest);

        Ticket createdTicket = payment(ticket);

        return MAPPER_TICKET.ticketToTicketDto(createdTicket);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected Ticket payment(@NotEmpty Ticket ticket) {

        Ticket createdTicket = ticketRepository.save(ticket);
        createdTicket.getSeat().setTicketId(createdTicket.getId());

        Passenger passenger = passengerRepository.findById(createdTicket.getPassengerId()).get();
        passenger.getTickets();


        return createdTicket;

    }


    public ResponseEntity<String> test(TicketCreateRequest ticketCreateRequest) {
        createTicket(ticketCreateRequest);


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
