package com.kodluyoruz.flightticket.models.entity;

import com.kodluyoruz.flightticket.models.entity.aboutAirport.Airport;
import com.kodluyoruz.flightticket.models.entity.aboutPlane.Plane;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@SQLDelete(sql = "UPDATE flights SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Flight extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(name = "gate_id")
    private Integer planeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gate_id",nullable = false,insertable = false,updatable = false)
    private Plane plane;

    @Column(name = "to_airport_id")
    private Integer toAirportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_airport_id",nullable = false,insertable = false,updatable = false)
    private Airport toAirport;

    @Column(name = "from_airport_id")
    private Integer fromAirportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_airport_id",nullable = false,insertable = false,updatable = false)
    private Airport fromAirport;

    private Date flightDate;


    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "flight")
    private GateReg gateReg;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
    private List<Seat> seats;



}
