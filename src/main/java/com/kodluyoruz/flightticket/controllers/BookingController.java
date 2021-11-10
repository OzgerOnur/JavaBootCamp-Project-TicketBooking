package com.kodluyoruz.flightticket.controllers;

import com.kodluyoruz.flightticket.models.dto.TicketDto;
import com.kodluyoruz.flightticket.models.requests.ticket.TicketCreateRequest;
import com.kodluyoruz.flightticket.models.requests.ticket.UpdateTicketRequest;
import com.kodluyoruz.flightticket.services.SeatAndTicketService;
import lombok.RequiredArgsConstructor;
import org.hibernate.usertype.UserVersionType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("tickets")
@RequiredArgsConstructor
public class BookingController {
    private final SeatAndTicketService seatAndTicketService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TicketDto createTicket(@Valid @RequestBody TicketCreateRequest ticketCreateRequest){
        return seatAndTicketService.createTicket(ticketCreateRequest);
    }

    @GetMapping("{id}")
    public TicketDto getTicket(@PathVariable Integer id){
        return seatAndTicketService.getTicketWithId(id);
    }

    @PatchMapping("{id}")
    public TicketDto updateTicket(@PathVariable Integer id,@RequestBody UpdateTicketRequest updateTicketRequest){
        return seatAndTicketService.updateTicket(id,updateTicketRequest);
    }

}
