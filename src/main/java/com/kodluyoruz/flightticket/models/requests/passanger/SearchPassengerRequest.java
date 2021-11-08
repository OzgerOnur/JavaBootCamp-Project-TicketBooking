package com.kodluyoruz.flightticket.models.requests.passanger;

import com.kodluyoruz.flightticket.models.entity.Ticket;
import com.kodluyoruz.flightticket.models.requests.ticket.TicketRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchPassengerRequest {

    @NotNull
    private String name;
    @NotNull
    private String mail;

}
