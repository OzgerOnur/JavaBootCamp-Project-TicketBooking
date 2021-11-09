package com.kodluyoruz.flightticket.models.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "passengers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = " UPDATE passengers SET deleted = true WHERE id = ? ")
@Where(clause = " deleted = false ")
public class Passenger extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL ,mappedBy = "passenger",orphanRemoval = true)
    private List<Ticket> tickets;

    private String name;

    private String mail;





}