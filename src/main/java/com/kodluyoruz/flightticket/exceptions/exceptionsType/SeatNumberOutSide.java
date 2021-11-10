package com.kodluyoruz.flightticket.exceptions.exceptionsType;

import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SeatNumberOutSide extends RuntimeException{
    private Integer flightId;
    private Integer planeId;
    private Integer passengerId;
    private Integer wantedSeatNumber;




    public SeatNumberOutSide(Flight flight, Ticket ticket) {
        this.flightId = flight.getId();
        this.planeId = flight.getPlaneId();
        this.passengerId = ticket.getPassengerId();
        this.wantedSeatNumber = ticket.getSeat().getSeatNumber();
    }

}