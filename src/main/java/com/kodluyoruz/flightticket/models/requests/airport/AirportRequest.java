package com.kodluyoruz.flightticket.models.requests.airport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportRequest {

    private Integer id;
    private String name;
    private Integer gateCapacity;

}
