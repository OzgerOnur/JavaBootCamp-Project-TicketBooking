package com.kodluyoruz.flightticket.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaneDto {
        private Integer id;
        private Integer capacity;
        private String name;
        private Integer serialNumber;
}
