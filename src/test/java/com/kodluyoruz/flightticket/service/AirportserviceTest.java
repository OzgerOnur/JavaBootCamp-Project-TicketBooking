package com.kodluyoruz.flightticket.service;

import com.kodluyoruz.flightticket.exceptions.exceptionsType.NotFoundEntityException;
import com.kodluyoruz.flightticket.models.dto.AirportDto;
import com.kodluyoruz.flightticket.models.dto.FlightDto;
import com.kodluyoruz.flightticket.models.dto.GateDto;
import com.kodluyoruz.flightticket.models.entity.aboutAirport.Airport;
import com.kodluyoruz.flightticket.models.requests.airport.AirportRequest;
import com.kodluyoruz.flightticket.repositories.AirportRepository;
import com.kodluyoruz.flightticket.services.AirportService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AirportserviceTest {
    @InjectMocks
    private AirportService sut;

    @Mock
    private AirportRepository airportRepository;

    @Captor
    private ArgumentCaptor<Airport> airportArgumentCaptor;

    private Airport airport;
    private AirportRequest airportRequest;
    private AirportDto airportDto;
    private FlightDto flightDto;
    private GateDto gateDto;

    @BeforeEach
    void setUp() {
        airport = Airport.builder()
                .id(1)
                .name("sabiha")
                .gateCapacity(1)
                .build();
        airportRequest = AirportRequest.builder()
                .id(1)
                .name("sabiha")
                .gateCapacity(1)
                .build();

        airportDto = AirportDto.builder()
                .id(1)
                .name("karaelmas")
                .gateCapacity(1)
                .gates(null)
                .takingFlights(null)
                .goingFlights(null)
                .build();
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4})
    void it_should_throw_exception_while_deleting_if_Airport_Exist(int i) {
        //given



        when(airportRepository.findById(anyInt())).thenReturn(Optional.empty());
        when(airportRepository.findById(eq(3))).thenReturn(Optional.of(airport));
        //when

    // sut.isAirportExist(id);

        //then
        Assertions.assertThrows(NotFoundEntityException.class,() -> sut.isAirportExist(i) );

    }
    @Test
    void it_should_return_airportDto(){
        //given

        when(airportRepository.save(airportArgumentCaptor.capture())).thenReturn(airport);
        //when

        AirportDto s = sut.createAirport(airportRequest);

        //then
        Assertions.assertEquals(airportDto,s);
//        verify(airportRepository.save(airport));

        Airport airportCaptured = airportArgumentCaptor.getValue();
        Assertions.assertEquals(airportCaptured,airportRequest);

        verify(airportRepository).save(airport);
    }
}
