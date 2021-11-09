package com.kodluyoruz.flightticket.models.requests.flight;

import com.kodluyoruz.flightticket.models.requests.Gate.GateRegInFlightUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightUpdateRequest {

    private Integer planeId;
    private Integer toAirportId;
    private Integer fromAirportId;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXX")
    private Date flightDate;
    private GateRegInFlightUpdateRequest gateReg;

}
