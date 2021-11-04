package com.kodluyoruz.flightticket.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "seats")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Seat extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private Integer seatNumber;

    @Column(name = "flight_id")
    private Integer flightId;

    @ManyToOne
    @JoinColumn(name = "flight_id",nullable = false,insertable = false,updatable = false)
    private Flight flight;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "seat")
    private Ticket ticket;





}