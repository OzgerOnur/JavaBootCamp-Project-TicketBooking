package com.kodluyoruz.flightticket.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GateRegDto {

    private Integer id;
    private Integer flightId;
    private Integer gateId;
    private Date startingDate;
    private Date endDate;


}
