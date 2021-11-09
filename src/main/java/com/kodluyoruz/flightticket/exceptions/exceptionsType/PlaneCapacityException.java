package com.kodluyoruz.flightticket.exceptions.exceptionsType;

import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.entity.aboutPlane.Plane;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class PlaneCapacityException extends RuntimeException {

    @Data
    public class ExceptionFlightCapacity{
        private Integer flightId;
        private Integer planeId;
        private Integer currentSoldSeat;
        private Integer wantedCapacity;
    }
    private ExceptionFlightCapacity exceptionPlanesCapacity;

    public PlaneCapacityException(Plane newPlane, Flight flight,Integer soldSeatNumber) {
        exceptionPlanesCapacity = new ExceptionFlightCapacity();
        exceptionPlanesCapacity.flightId = flight.getId();
        exceptionPlanesCapacity.planeId = newPlane.getId();
        exceptionPlanesCapacity.currentSoldSeat = soldSeatNumber;
        exceptionPlanesCapacity.wantedCapacity = newPlane.getCapacity();


    }
}
