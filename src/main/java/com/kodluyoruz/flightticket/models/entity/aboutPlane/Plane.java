package com.kodluyoruz.flightticket.models.entity.aboutPlane;


import com.kodluyoruz.flightticket.models.entity.BaseEntity;
import com.kodluyoruz.flightticket.models.entity.Flight;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "planes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Plane extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String name;

    private Integer serialNumber;

    private Integer capacity;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "plane")
    private List<Flight> flights;


}
