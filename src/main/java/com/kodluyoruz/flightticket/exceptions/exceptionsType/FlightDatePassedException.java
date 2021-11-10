package com.kodluyoruz.flightticket.exceptions.exceptionsType;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class FlightDatePassedException extends RuntimeException {
    public FlightDatePassedException(String message) {
        super(message);
    }
}
