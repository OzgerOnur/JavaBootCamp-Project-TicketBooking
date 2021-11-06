package com.kodluyoruz.flightticket.models.dto;

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
public class SeatDto {

    private Integer id;
    private Integer seatNumber;
    private Integer flightId;
    private Integer ticketId;

}
