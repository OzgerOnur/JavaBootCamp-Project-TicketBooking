package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.models.entity.Seat;

public class SeatAlreadyBooked extends RuntimeException {
    public SeatAlreadyBooked(Seat s) {
        super(s.getSeatNumber() + "Number Seat Already Booked");
    }
}
