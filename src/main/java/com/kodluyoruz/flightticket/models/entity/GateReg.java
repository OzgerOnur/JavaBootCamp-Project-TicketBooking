package com.kodluyoruz.flightticket.models.entity;

import com.kodluyoruz.flightticket.models.entity.aboutAirport.Gate;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Table(name = "gatereg")
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

    @Column(name = "flight_id")
    private Integer flightId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id",updatable = false,insertable = false,nullable = false)
    private Flight flight;

    @Column(name = "gate_id")
    private Integer gateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gate_id",nullable = false,insertable = false,updatable = false)
    private Gate gate;

    private Date startingDate;

    private Date endDate;



}