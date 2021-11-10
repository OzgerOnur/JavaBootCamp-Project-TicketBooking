package com.kodluyoruz.flightticket.models.requests.Seat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatCreateRequest {

    @NotNull
    private Integer seatNumber;
    @NotNull
    private Integer flightId;
    // it will be in update
    //private Integer ticketId;


}
