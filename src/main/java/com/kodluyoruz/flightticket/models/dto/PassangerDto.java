package com.kodluyoruz.flightticket.models.dto;

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
public class PassangerDto {

    private Integer id;
    private String name;
    private String mail;
    private List<Ticket> ticket;

}

