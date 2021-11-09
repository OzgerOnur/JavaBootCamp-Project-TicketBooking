package com.kodluyoruz.flightticket.models.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "seats")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = " UPDATE seats SET deleted = true WHERE id = ? ")
@Where(clause = " deleted = false ")
public class Seat extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer seatNumber;

    @Column(name = "flight_id")
    private Integer flightId;

    @ManyToOne
    @JoinColumn(name = "flight_id",nullable = false,insertable = false,updatable = false)
    private Flight flight;

    @Column(name = "ticket_id")
    private Integer ticketId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id",nullable = false,insertable = false,updatable = false)
    private Ticket ticket;





}