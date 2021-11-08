package com.kodluyoruz.flightticket.models.requests.passanger;

import com.kodluyoruz.flightticket.models.entity.Ticket;
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
public class PassengerUpdateRequest {


    private Integer id;
    // todo bak private List<Ticket> tickets;
    private String name;
    private String mail;
}
