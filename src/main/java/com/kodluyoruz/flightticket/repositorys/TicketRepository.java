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


    @Query("select t.passengerId from Ticket t where t.id = ?1 ")
    Integer getPassengerIdWithTicketId(Integer ticketId);



}
