package com.kodluyoruz.flightticket.model;


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
public class Plane extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String planeName;

    private Integer capacity;


}
