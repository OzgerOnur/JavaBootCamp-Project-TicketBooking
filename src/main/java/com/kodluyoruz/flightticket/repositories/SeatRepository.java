package com.kodluyoruz.flightticket.repositories;

import com.kodluyoruz.flightticket.models.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {

    Integer countSeatByFlightIdEquals(Integer flightId);

    Optional<Seat> findBySeatNumberEqualsAndFlightIdEquals(Integer seatNumber,Integer flightId);

    Boolean existsByFlightIdAndSeatNumber(Integer flightId,Integer seatNumber);



}
