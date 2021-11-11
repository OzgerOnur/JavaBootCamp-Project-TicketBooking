package com.kodluyoruz.flightticket.models.requests.ticket;

import com.kodluyoruz.flightticket.models.requests.Seat.SeatCreateRequest;
import com.kodluyoruz.flightticket.models.requests.Seat.SeatUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTicketRequest {

    @NotNull(message = "passenger id must be")
    private Integer passengerId;

    @NotNull(message = "seat must be ")
    private SeatUpdateRequest seat;

}
