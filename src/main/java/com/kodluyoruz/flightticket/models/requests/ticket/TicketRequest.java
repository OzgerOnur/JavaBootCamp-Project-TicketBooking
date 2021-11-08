package com.kodluyoruz.flightticket.models.requests.ticket;

import com.kodluyoruz.flightticket.models.entity.Passenger;
import com.kodluyoruz.flightticket.models.entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketRequest {
    // @NotBlank if it is neccecary
    private Integer id;
    private Integer passengerId;
    private Seat seat;

}
