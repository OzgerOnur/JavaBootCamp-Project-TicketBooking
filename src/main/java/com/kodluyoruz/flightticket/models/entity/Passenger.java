package com.kodluyoruz.flightticket.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "passengers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Passenger extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "passenger",orphanRemoval = true)
    private List<Ticket> ticket;


    private String name;





}