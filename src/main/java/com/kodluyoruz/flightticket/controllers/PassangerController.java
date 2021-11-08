package com.kodluyoruz.flightticket.controllers;

import com.kodluyoruz.flightticket.models.dto.PassangerDto;
import com.kodluyoruz.flightticket.models.entity.Passenger;
import com.kodluyoruz.flightticket.models.requests.passanger.CreatePassangerRequest;
import com.kodluyoruz.flightticket.models.requests.passanger.PassengerUpdateRequest;
import com.kodluyoruz.flightticket.models.requests.passanger.SearchPassengerRequest;
import com.kodluyoruz.flightticket.services.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("passangers")
@RequiredArgsConstructor
public class PassangerController {
    private final PassengerService passengerService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PassangerDto createPassenger(@Valid @RequestBody CreatePassangerRequest createPassangerRequest){
        return passengerService.createPassanger(createPassangerRequest);
    }

    @GetMapping("{id}")
    public PassangerDto getPassenger(@PathVariable Integer id){
        return passengerService.getPassanger(id);
    }

    @GetMapping()
    public List<PassangerDto> searchPassenger(@Valid SearchPassengerRequest searchPassengerRequest){
        return passengerService.searchPassengers(searchPassengerRequest);
    }

    @PatchMapping("{id}")
    public PassangerDto updatePassenger(@PathVariable Integer id, @RequestBody PassengerUpdateRequest passengerUpdateRequest){
        return passengerService.updatePassenger(id,passengerUpdateRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePassenger(@PathVariable Integer id){
        passengerService.deletePassenger(id);

    }

}
