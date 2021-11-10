package com.kodluyoruz.flightticket.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportDto {
    private Integer id;
    private String name;
    private Integer gateCapacity;
    private List<GateDto> gates;
    private List<FlightDto> takingFlights;
    private List<FlightDto> goingFlights;

}
