package com.kodluyoruz.flightticket.models.requests.Seat;

import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatCreateRequest {

    private Integer seatNumber;
    private Integer flightId;
    // it will be in update
    //private Integer ticketId;


}
