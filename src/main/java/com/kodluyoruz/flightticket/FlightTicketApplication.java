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

    //todo Project should include example data initialization.
    // todo Unit tests should be written.
    //todo Attention should be paid to data consistency
}
