package com.kodluyoruz.flightticket.models.requests.flight;

import com.kodluyoruz.flightticket.models.requests.Gate.GateRegCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightCreateRequest {

    @NotEmpty
    private Integer planeId;
    @NotEmpty
    private Integer toAirportId;
    @NotEmpty
    private Integer fromAirportId;
    @NotEmpty
    private Date flightDate;
    @NotEmpty
    private GateRegCreateRequest gateRegCreateRequest;



}
