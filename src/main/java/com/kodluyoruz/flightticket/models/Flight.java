package com.kodluyoruz.flightticket.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flights")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Flight extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Plane plane;

    @ManyToOne(fetch = FetchType.LAZY)
    private Airport toAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    private Airport fromAirport;

    private Date flightDate;

    @JoinColumn(name = "gate_reg_Id")
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private GateReg gateReg;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
    private List<Seat> seats;



}
