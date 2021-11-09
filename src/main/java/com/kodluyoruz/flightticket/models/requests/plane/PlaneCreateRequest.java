package com.kodluyoruz.flightticket.models.requests.plane;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaneCreateRequest {

    private Integer capacity;
    private String name;
    private Integer serialNumber;
}
