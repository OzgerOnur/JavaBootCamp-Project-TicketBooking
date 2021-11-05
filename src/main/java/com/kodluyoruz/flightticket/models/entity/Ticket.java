package com.kodluyoruz.flightticket.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Ticket extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(name = "passenger_id")
    private Integer passengerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id",updatable = false,insertable = false,nullable = false)
    private Passenger passenger;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "ticket")
    private Seat seat;



}
