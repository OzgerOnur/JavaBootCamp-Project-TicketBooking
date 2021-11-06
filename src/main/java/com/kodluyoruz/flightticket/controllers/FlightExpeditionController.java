package com.kodluyoruz.flightticket.controllers;

import com.kodluyoruz.flightticket.models.dto.FlightDto;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import com.kodluyoruz.flightticket.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("FlightsExpedition")
@RequiredArgsConstructor
public class FlightExpeditionController {
    private final FlightService flightService;

    @PostMapping()
    public FlightDto createFlight(@RequestBody FlightCreateRequest flightCreateRequest){
        return flightService.createFlight(flightCreateRequest);
    }
}
