package com.kodluyoruz.flightticket.controllers;

import com.kodluyoruz.flightticket.models.dto.FlightDto;
import com.kodluyoruz.flightticket.models.dto.PageAbleResponse;
import com.kodluyoruz.flightticket.models.requests.PageableRequest;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import com.kodluyoruz.flightticket.models.requests.flight.FlightSearchRequestWithName;
import com.kodluyoruz.flightticket.models.requests.flight.FlightUpdateRequest;
import com.kodluyoruz.flightticket.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public PageAbleResponse<FlightDto> getFlightWithName(@Valid FlightSearchRequestWithName flightSearchRequestWithName,
                                                         @Valid PageableRequest pageableRequest){
        return flightService.getFlightsWithName(flightSearchRequestWithName,pageableRequest);
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
