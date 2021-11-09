package com.kodluyoruz.flightticket.models.requests.Gate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GateRegInFlightUpdateRequest {


    private Integer gateId;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXX")
    private Date startingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXX")
    private Date endDate;

}
