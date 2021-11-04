package com.kodluyoruz.flightticket.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airports")
public class Airport extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "toAirport")
    private List<Flight> takingFlights;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "fromAirport")
    private List<Flight> goingFlights;

}
