package com.kodluyoruz.flightticket.repositorys;

import com.kodluyoruz.flightticket.models.entity.GateReg;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface GateRegRepository extends JpaRepository<GateReg,Integer> {
    Boolean existsGateRegByGateIdEqualsAndStartingDateIsBetweenOrEndDateIsBetween
            (Integer gateId, Date dateStart1, Date dateEnd1,Date dateStart2, Date dateEnd2);
}
