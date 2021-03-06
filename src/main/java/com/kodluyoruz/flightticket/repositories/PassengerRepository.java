package com.kodluyoruz.flightticket.repositories;

import com.kodluyoruz.flightticket.models.entity.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {



    @Query("select p from Passenger p "
            +" where p.name like %?1% AND p.mail like %?2% ")
    List<Passenger> findPassengerWithNameOrMail(String name,String mail);

    @Query("select p from Passenger p "
            +" where p.name like %?1% AND p.mail like %?2% ")
    Page<Passenger> findPassengerWithNameOrMail(String name, String mail, Pageable pageable);

    @Query("select p from Passenger p where p.id = ?1")
    Optional<Passenger> isPassengerExist(Integer passengerId);


}
