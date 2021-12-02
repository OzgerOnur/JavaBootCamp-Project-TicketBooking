package com.kodluyoruz.flightticket.controllers;

import com.kodluyoruz.flightticket.models.dto.PageAbleResponse;
import com.kodluyoruz.flightticket.models.dto.PlaneDto;
import com.kodluyoruz.flightticket.models.requests.PageableRequest;
import com.kodluyoruz.flightticket.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping()
    public PageAbleResponse<PlaneDto> test(PageableRequest pageableRequest){

        return testService.getPlanes(pageableRequest);

    }

}
