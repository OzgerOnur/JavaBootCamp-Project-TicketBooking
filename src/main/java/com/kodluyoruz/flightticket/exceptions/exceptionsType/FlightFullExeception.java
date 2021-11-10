package com.kodluyoruz.flightticket.exceptions.exceptionsType;

import com.kodluyoruz.flightticket.models.dto.FlightDto;
import com.kodluyoruz.flightticket.models.entity.Flight;

public class FlightFullExeception extends RuntimeException {

    public FlightFullExeception(Flight flight) {
        super(flight.getId() + " Flight's Seats Are Full");
    }
}
