package com.kodluyoruz.flightticket.controllers;

import com.kodluyoruz.flightticket.models.dto.GateRegDto;
import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.entity.GateReg;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import com.kodluyoruz.flightticket.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.kodluyoruz.flightticket.models.mappers.FlightMapper.MAPPER_FLIGHT;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @PostMapping
    public ResponseEntity<String> test(@RequestBody FlightCreateRequest flightCreateRequest){

        return testService.test(flightCreateRequest);

    }

}
