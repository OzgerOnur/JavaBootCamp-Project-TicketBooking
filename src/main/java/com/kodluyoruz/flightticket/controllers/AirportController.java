package com.kodluyoruz.flightticket.controllers;

import com.kodluyoruz.flightticket.models.dto.AirportDto;
import com.kodluyoruz.flightticket.models.requests.AirportRequest;
import com.kodluyoruz.flightticket.services.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airport")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AirportDto createAirport(AirportRequest airportRequest) {
        return airportService.createAirport(airportRequest);
    }

    @GetMapping("{id}")
    public AirportDto getAirport(@PathVariable Integer id) {
        return airportService.getAirport(id);
    }

    @GetMapping()
    public List<AirportDto> getAirports() {
        return airportService.getAirports();
    }

    @PatchMapping("{id}")
    public AirportDto updateAirport (@PathVariable Integer id, @RequestBody AirportRequest airportRequest){
        return airportService.updateAirport(id, airportRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAirport(@PathVariable Integer id){
        airportService.deleteAirport(id);
    }

}
