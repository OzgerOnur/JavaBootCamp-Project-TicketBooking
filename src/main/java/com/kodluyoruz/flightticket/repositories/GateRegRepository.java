package com.kodluyoruz.flightticket.repositories;

import com.kodluyoruz.flightticket.models.entity.GateReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GateRegRepository extends JpaRepository<GateReg,Integer> {
//    A /\ (B \/ C) <=> (A /\ B) \/ (A /\ C)
//    A and (B or C) <=> (A and B) or (A and C)
//    is like (first & condition) OR ( second & condition) --> condition & ( first or second)

    Boolean existsGateByGateIdEqualsAndStartingDateBetweenOrGateIdEqualsAndEndDateBetween
            (Integer gateId1, Date dateStart1, Date dateEnd1,Integer gateId2,Date dateStart2, Date dateEnd2);

    @Query("SELECT gr FROM #{#entityName} gr WHERE " +
            " gr.gateId = ?1 " +
            " AND ((( ?2 BETWEEN gr.startingDate AND gr.endDate) OR (?3 BETWEEN gr.startingDate AND gr.endDate)) " +
            " OR (( gr.startingDate BETWEEN ?2 AND ?3) OR (gr.endDate BETWEEN ?2 AND ?3))) ")
    List<GateReg> isExistsSameDateGateReg(Integer id, Date startingDate, Date endDate);
    //if there wasnt second betweens line , could be added date that including old dates


}
