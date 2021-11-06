package com.kodluyoruz.flightticket.repositorys;

import com.kodluyoruz.flightticket.models.entity.GateReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface GateRegRepository extends JpaRepository<GateReg,Integer> {
    Boolean existsGateRegByGateIdEqualsAndStartingDateIsBetween(Integer gateId, Date dateStart, Date dateEnd);
    Optional<Boolean> existsGateRegByGateIdEqualsAndStartingDateIsBetweenOrEndDateIsBetween
            (Integer gateId, Date dateStart, Date dateEnd);

}
