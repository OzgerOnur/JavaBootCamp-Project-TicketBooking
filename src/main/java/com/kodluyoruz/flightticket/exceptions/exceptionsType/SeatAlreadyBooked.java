package com.kodluyoruz.flightticket.exceptions.exceptionsType;

import com.kodluyoruz.flightticket.models.entity.Seat;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeatAlreadyBooked extends RuntimeException {
    public SeatAlreadyBooked(Seat s) {
        super(s.getSeatNumber() + "Number Seat Already Booked");
    }
}
