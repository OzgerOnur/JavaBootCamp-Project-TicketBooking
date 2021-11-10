package com.kodluyoruz.flightticket.controllers;

import com.kodluyoruz.flightticket.models.dto.FlightDto;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import com.kodluyoruz.flightticket.models.requests.flight.FlightSearchRequestWithName;
import com.kodluyoruz.flightticket.models.requests.flight.FlightUpdateRequest;
import com.kodluyoruz.flightticket.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flightExpeditions")
@RequiredArgsConstructor
public class FlightExpeditionController {
    private final FlightService flightService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public FlightDto createFlight(@RequestBody FlightCreateRequest flightCreateRequest){
        return flightService.createFlight(flightCreateRequest);
    }

    @GetMapping("{id}")
    public FlightDto getFlight(@PathVariable Integer id){
        return flightService.getFlightWithId(id);
    }

    @GetMapping()
    public List<FlightDto> getFlightWithName(FlightSearchRequestWithName flightSearchRequestWithName){
        return flightService.getFlightsWithName(flightSearchRequestWithName);
    }

    @PatchMapping("{id}")
    public FlightDto updateFlight(@PathVariable Integer id,
                                  @RequestBody FlightUpdateRequest flightUpdateRequest){
        return flightService.updateFlight(id,flightUpdateRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlight(@PathVariable Integer id){
        flightService.deleteFlight(id);
    }



}
