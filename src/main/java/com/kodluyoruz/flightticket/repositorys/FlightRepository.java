package com.kodluyoruz.flightticket.repositorys;

import com.kodluyoruz.flightticket.models.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {



    List<Flight> findByToAirportIdAndFromAirportIdAndFlightDateBetween(
            Integer toAirportId,
            Integer fromAirPortId,
            Date fromDate,
            Date toDate
    );

    @Query("select f from #{#entityName} f " +
            " where f.fromAirport.name like %?2% AND f.toAirport.name like %?1% "
            +" AND f.flightDate >= ?4 and f.flightDate <= ?3 ")
    List<Flight> findFlightWithName(
          String toAirport,
          String fromAirport,
          Date toDate,
          Date fromDate
    );



}
