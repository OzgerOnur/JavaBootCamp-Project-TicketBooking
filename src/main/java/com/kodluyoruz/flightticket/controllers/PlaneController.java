package com.kodluyoruz.flightticket.controllers;

import com.kodluyoruz.flightticket.models.requests.PlaneRequest;
import com.kodluyoruz.flightticket.models.dto.PlaneDto;
import com.kodluyoruz.flightticket.services.PlaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("planes")
@RequiredArgsConstructor
public class PlaneController {
    private final PlaneService planeService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PlaneDto createPlane(@RequestBody PlaneRequest planeRequest){
        return planeService.createPlane(planeRequest);
    }

    @GetMapping()
    public List<PlaneDto> getPlanes(){
        return planeService.getPlanes();
    }

    @GetMapping("{id}")
    public PlaneDto getPlane(@PathVariable Integer id){
        return planeService.getPlane(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlane(@PathVariable Integer id){
        planeService.deletePlane(id);
    }

}
