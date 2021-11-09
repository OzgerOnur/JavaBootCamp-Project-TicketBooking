package com.kodluyoruz.flightticket.models.requests.passanger;

import com.kodluyoruz.flightticket.models.requests.ticket.TicketCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerUpdateRequest {

    private String name;
    private String mail;



}
