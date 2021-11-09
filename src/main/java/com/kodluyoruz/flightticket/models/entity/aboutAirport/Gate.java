package com.kodluyoruz.flightticket.models.entity.aboutAirport;

import com.kodluyoruz.flightticket.models.entity.BaseEntity;
import com.kodluyoruz.flightticket.models.entity.GateReg;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gates")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = " UPDATE gates SET deleted = true WHERE id = ? ")
@Where(clause = " deleted = false ")
public class Gate extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer gateNumber;

    @Column(name = "airport_id")
    private Integer airportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_id",updatable = false,insertable = false,nullable = false)
    private Airport airport;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "gate",cascade = CascadeType.ALL)
    private List<GateReg> gateRegs;

}
