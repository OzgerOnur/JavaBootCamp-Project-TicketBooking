package com.kodluyoruz.flightticket.controllers;

import com.kodluyoruz.flightticket.models.dto.PageAbleResponse;
import com.kodluyoruz.flightticket.models.requests.PageableRequest;
import com.kodluyoruz.flightticket.models.requests.plane.PlaneCreateRequest;
import com.kodluyoruz.flightticket.models.dto.PlaneDto;
import com.kodluyoruz.flightticket.models.requests.plane.PlaneUpdateRequest;
import com.kodluyoruz.flightticket.services.PlaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("planes")
@RequiredArgsConstructor
public class PlaneController {
    private final PlaneService planeService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PlaneDto createPlane(@RequestBody PlaneCreateRequest planeCreateRequest){
        return planeService.createPlane(planeCreateRequest);
    }

    @GetMapping()
    public PageAbleResponse<PlaneDto> getPlanes(@Valid PageableRequest pageableRequest){
        return planeService.getPlanes(pageableRequest);

    }

    @GetMapping("{id}")
    public PlaneDto getPlane(@PathVariable Integer id){
        return planeService.getPlane(id);
    }

    @PatchMapping("{id}")
    public PlaneDto updatePlane(@PathVariable Integer id,@RequestBody PlaneUpdateRequest planeUpdateRequest){
        return planeService.updatePlane(id,planeUpdateRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlane(@PathVariable Integer id){
        planeService.deletePlane(id);
    }



}
