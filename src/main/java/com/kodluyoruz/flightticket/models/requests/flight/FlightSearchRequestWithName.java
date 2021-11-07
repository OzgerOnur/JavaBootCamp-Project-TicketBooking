package com.kodluyoruz.flightticket.models.requests.flight;

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
public class FlightSearchRequestWithName {

    private String toAirport;
    private String fromAirport;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mmXX")
    private Date ToDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mmXX")
    private Date fromDate;

}
