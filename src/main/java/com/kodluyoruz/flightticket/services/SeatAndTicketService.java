package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.exceptions.exceptionsType.FlightFullExeception;
import com.kodluyoruz.flightticket.exceptions.exceptionsType.NotFoundEntityException;
import com.kodluyoruz.flightticket.exceptions.exceptionsType.PlaneCapacityException;
import com.kodluyoruz.flightticket.exceptions.exceptionsType.SeatNumberOutSide;
import com.kodluyoruz.flightticket.models.dto.TicketDto;
import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.entity.Seat;
import com.kodluyoruz.flightticket.models.entity.Ticket;
import com.kodluyoruz.flightticket.models.requests.ticket.TicketCreateRequest;
import com.kodluyoruz.flightticket.repositorys.SeatRepository;
import com.kodluyoruz.flightticket.repositorys.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;

import static com.kodluyoruz.flightticket.models.mappers.TicketMapper.MAPPER_TICKET;

@Service
@RequiredArgsConstructor
public class SeatAndTicketService {
    private final SeatRepository seatRepository;
    private final TicketRepository ticketRepository;



    protected Integer getSoldSeatOfFlightNumber(Integer flightId){
        return seatRepository.countSeatByFlightIdEquals(flightId);
    }

    public TicketDto createTicket(TicketCreateRequest ticketCreateRequest) {
        Ticket ticket = MAPPER_TICKET.creatTicketRequestToTicket(ticketCreateRequest);
        isTicketRequestValid(ticket);
        Ticket createdTicket = payment(ticket);

        return MAPPER_TICKET.ticketToTicketDto(createdTicket);
    }

    private void isTicketRequestValid(Ticket ticket) {
        // passenger valid
        ticketRepository.isPassengerExist(ticket.getPassengerId()).orElseThrow(
                () -> new NotFoundEntityException("Passenger Not Found")
        );
        // flight valid
        Flight flight = ticketRepository.isFlightExist(ticket.getSeat().getFlightId()).orElseThrow(
                () -> new NotFoundEntityException("Flight Not Found"));
        // seat Number valid
        if ((ticket.getSeat().getSeatNumber() > flight.getPlane().getCapacity())
                || (ticket.getSeat().getSeatNumber() <= 0) ){
            throw new SeatNumberOutSide(flight,ticket);
        } // todo flight capın altında bir numara sçemeli


    }

    private void addAndUpdateTicketControl(Ticket ticket){
        // flight valid
        Flight flight = ticketRepository.isFlightExist(ticket.getSeat().getFlightId()).orElseThrow(
                () -> new NotFoundEntityException("Flight Not Found"));

        // seatnumber valid to sale
        seatRepository.findBySeatNumberEqualsAndFlightIdEquals(ticket.getSeat().getSeatNumber(),flight.getId())
                .ifPresent(seat -> {throw new SeatAlreadyBooked(seat);});

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected Ticket payment(@NotEmpty Ticket ticket) {
        addAndUpdateTicketControl(ticket);
        paying(ticket.getPaymentInformation());
        Ticket createdTicket = ticketRepository.save(ticket);
        createdTicket.getSeat().setTicketId(createdTicket.getId());// todo eğer yapamzsam ticket idsi boşta kalacak mı
        createdTicket = ticketRepository.save(createdTicket);
        return createdTicket;

    }

    private void paying(String paymentInformation) {
        // orElse new Throm

    }

    public TicketDto getTicketWithId(Integer id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException(id + " Ticket Not FOund")
        );
        return MAPPER_TICKET.ticketToTicketDto(ticket);
    }
}
