package com.kodluyoruz.flightticket.service;

import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.repositorys.FlightRepository;
import com.kodluyoruz.flightticket.services.AirportService;
import com.kodluyoruz.flightticket.services.FlightService;
import com.kodluyoruz.flightticket.services.GateService;
import com.kodluyoruz.flightticket.services.PlaneService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {
    @InjectMocks
    private FlightService sut; // system under test
    @Mock
    private FlightRepository flightRepository;
    @Mock
    private PlaneService planeService;
    @Mock
    private AirportService airportService;
    @Mock
    private GateService gateService;


    @Test
    void it_should_throw_exception_when_flight_is_exist() {
        //given


        //when


        //then

    }
}
