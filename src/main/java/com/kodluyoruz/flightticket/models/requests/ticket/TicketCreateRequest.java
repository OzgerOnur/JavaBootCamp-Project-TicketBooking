package com.kodluyoruz.flightticket.models.requests.ticket;

import com.kodluyoruz.flightticket.models.requests.Seat.SeatCreateRequest;
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
public class TicketCreateRequest {
    // @NotBlank if it is neccecary
   // private Integer id;
    @NotNull
    private Integer passengerId;
    @NotNull
    private SeatCreateRequest seat;
    @NotBlank
    private String paymentInformation;

}
