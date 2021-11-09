package com.kodluyoruz.flightticket.exceptions.exceptionsType;

import com.kodluyoruz.flightticket.models.entity.Flight;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class FlightAndGateRegDateException extends RuntimeException {

    @Data
    public class ExceptionDates{
       private Date regDateStarting;
       private Date regDateEnding;
       private Date flightDate;
    }
    private ExceptionDates exceptionDates;

    public FlightAndGateRegDateException(@NotNull Flight flight) {
        exceptionDates = new ExceptionDates();
        exceptionDates.flightDate = flight.getFlightDate();
        exceptionDates.regDateStarting = flight.getGateReg().getStartingDate();
        exceptionDates.regDateEnding = flight.getGateReg().getEndDate();
    }

}
