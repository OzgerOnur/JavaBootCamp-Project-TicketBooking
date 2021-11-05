package com.kodluyoruz.flightticket.models.dto;

import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.entity.Ticket;

import javax.persistence.*;

public class SeatDto {

    private Integer id;
    private Integer seatNumber;
    private Integer flightId;
    private Ticket ticketId;

}
