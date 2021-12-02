package com.kodluyoruz.flightticket.repositories;

import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.requests.PageableRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    @Query("select f from #{#entityName} f " +
            " where f.fromAirport.name like %?2% AND f.toAirport.name like %?1% "
            +" AND f.flightDate >= ?4 and f.flightDate <= ?3 ")
    List<Flight> findFlightWithName(
            String toAirport,
            String fromAirport,
            Date toDate,
            Date fromDate,
            Pageable pageableRequest
    );


    List<Flight> getFlightByPlaneId(Integer planeId);
    List<Flight> getFlightByPlaneIdAndFlightDateAfter(Integer planeId,Date datesAfter);

    @Query("select f from Flight f where f.id = ?1")
    Optional<Flight> isFlightExist(Integer flightId);

    @Query("select count(f.seats) from Flight f where f.id = ?1")
    int countNumberOfFlightsSeat(Integer flightId);


}
