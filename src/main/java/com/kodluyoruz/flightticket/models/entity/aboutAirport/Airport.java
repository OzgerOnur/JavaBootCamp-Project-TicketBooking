package com.kodluyoruz.flightticket.models.entity.aboutAirport;

import com.kodluyoruz.flightticket.models.entity.BaseEntity;
import com.kodluyoruz.flightticket.models.entity.Flight;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airports")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@SQLDelete(sql = "UPDATE airports SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Airport extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
