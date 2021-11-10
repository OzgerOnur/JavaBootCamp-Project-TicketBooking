package com.kodluyoruz.flightticket.repositorys;

import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.entity.Passenger;
import com.kodluyoruz.flightticket.models.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    @Query("select p from Passenger p where p.id = ?1")
    Optional<Passenger> isPassengerExist(Integer passengerId);

    @Query("select f from Flight f where f.id = ?1")
    Optional<Flight> isFlightExist(Integer flightId);

    @Query("select count(f.seats) from Flight f where f.id = ?1")
    int countNumberOfFlightsSeat(Integer flightId);


}
