package com.kodluyoruz.flightticket.repositorys;

import com.kodluyoruz.flightticket.models.entity.aboutAirport.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GateRepository extends JpaRepository<Gate,Integer> {
    Optional<Gate> findByIdAndAirportIdEquals(Integer gateId,Integer AirportId);



}
