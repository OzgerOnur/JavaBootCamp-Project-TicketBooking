package com.kodluyoruz.flightticket.models.requests.plane;

import com.kodluyoruz.flightticket.models.entity.Flight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaneUpdateRequest {

    private String name;
    private Integer serialNumber;
    private Integer capacity;


}
