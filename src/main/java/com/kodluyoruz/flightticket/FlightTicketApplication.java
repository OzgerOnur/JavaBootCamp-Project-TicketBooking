package com.kodluyoruz.flightticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class FlightTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightTicketApplication.class, args);
    }



    // todo Unit tests should be written.

    // todo pageable and  transcation, use them

    // todo exceptions should be regulated

}
