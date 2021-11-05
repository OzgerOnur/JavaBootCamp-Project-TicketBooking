package com.kodluyoruz.flightticket.models.entity.aboutAirport;

import com.kodluyoruz.flightticket.models.entity.BaseEntity;
import com.kodluyoruz.flightticket.models.entity.Flight;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airports")
public class Airport extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String name;

    private Integer gateCapacity;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "airport",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Gate> gates;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "toAirport")
    private List<Flight> takingFlights;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "fromAirport")
    private List<Flight> goingFlights;

}
