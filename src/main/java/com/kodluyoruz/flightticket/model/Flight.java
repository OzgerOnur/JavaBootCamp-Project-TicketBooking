package com.kodluyoruz.flightticket.model;

import lombok.*;

import javax.persistence.*;
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

    private String goTo;

    private String from;

    // todo gate ve rezervasyon

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
    private List<Seat> seats;



}
