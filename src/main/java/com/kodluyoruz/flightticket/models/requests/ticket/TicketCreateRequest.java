package com.kodluyoruz.flightticket.models.requests.ticket;

import com.kodluyoruz.flightticket.models.requests.Seat.SeatCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketCreateRequest {
    // @NotBlank if it is neccecary
    private Integer id;
    private Integer passengerId;
    private SeatCreateRequest seat;

}
