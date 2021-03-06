package com.kodluyoruz.flightticket.models.requests.Seat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatUpdateRequest {

    @NotNull(message = "seat number must be exist")
    private Integer seatNumber;

}
