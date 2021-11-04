package com.kodluyoruz.flightticket.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Table(name = "gate_reg")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GateReg extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "gateReg")
    private Flight flight;

    private Date startingDate;

    private Date endDate;



}