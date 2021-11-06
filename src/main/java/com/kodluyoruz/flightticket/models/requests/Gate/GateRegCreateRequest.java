package com.kodluyoruz.flightticket.models.requests.Gate;

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
public class GateRegCreateRequest {

    private Integer airportId;
    @NotEmpty
    private Integer gateId;
    @NotEmpty
    private Date startingDate;
    @NotEmpty
    private Date endDate;

}
