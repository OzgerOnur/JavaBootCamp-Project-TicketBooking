package com.kodluyoruz.flightticket.models.entity.aboutPlane;


import com.kodluyoruz.flightticket.models.entity.BaseEntity;
import com.kodluyoruz.flightticket.models.entity.Flight;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "planes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = " UPDATE planes SET deleted = true WHERE id = ? ")
@Where(clause = " deleted = false ")
public class Plane extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer serialNumber;

    private Integer capacity;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "plane")
    private List<Flight> flights;


}
