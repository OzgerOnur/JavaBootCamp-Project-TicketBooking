package com.kodluyoruz.flightticket.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GateDto {

    private Integer id;
    private Integer gateNumber;
    private Integer airportId;

}
