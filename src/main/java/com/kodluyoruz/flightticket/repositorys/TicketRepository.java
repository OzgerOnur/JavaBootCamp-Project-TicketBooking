package com.kodluyoruz.flightticket.repositorys;

import com.kodluyoruz.flightticket.models.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

}
