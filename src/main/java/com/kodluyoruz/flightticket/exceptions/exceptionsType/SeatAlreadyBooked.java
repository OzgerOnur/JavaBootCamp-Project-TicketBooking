package com.kodluyoruz.flightticket.exceptions.exceptionsType;

import com.kodluyoruz.flightticket.models.entity.Seat;
import com.kodluyoruz.flightticket.models.requests.Seat.SeatUpdateRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeatAlreadyBooked extends RuntimeException {
    public SeatAlreadyBooked(Seat s) {
        super(s.getSeatNumber() + " Number Seat Already Booked");
    }

    public SeatAlreadyBooked(SeatUpdateRequest seat) {
        super(seat.getSeatNumber() + " Number Seat Already Booked");

    }
}
