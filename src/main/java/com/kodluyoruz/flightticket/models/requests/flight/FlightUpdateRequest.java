package com.kodluyoruz.flightticket.models.requests.flight;

import com.kodluyoruz.flightticket.models.entity.GateReg;
import com.kodluyoruz.flightticket.models.entity.Seat;
import com.kodluyoruz.flightticket.models.entity.aboutAirport.Airport;
import com.kodluyoruz.flightticket.models.entity.aboutPlane.Plane;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightUpdateRequest {

    private Integer planeId;
    private Integer toAirportId;
    private Integer fromAirportId;
    private Date flightDate;

}
