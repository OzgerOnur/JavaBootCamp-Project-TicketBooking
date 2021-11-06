package com.kodluyoruz.flightticket.service;

import com.kodluyoruz.flightticket.models.entity.GateReg;
import com.kodluyoruz.flightticket.models.entity.aboutAirport.Gate;
import com.kodluyoruz.flightticket.repositorys.GateRegRepository;
import com.kodluyoruz.flightticket.repositorys.GateRepository;
import com.kodluyoruz.flightticket.services.GateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GateServiceTest {
    @InjectMocks
    private GateService sut;
    @Mock
    private  GateRepository gateRepository;
    @Mock
    private  GateRegRepository gateRegRepository;

    @Test
    void it_should_throw_exp_when_airport_and_gateId_arent_matched() {
        //given
        Integer fromAirportId = 1;
        GateReg gateReg = GateReg.builder()
                .gateId(1)
                .gateId(1)
                .build();


        //when

        //sut.isGateValidAndAvailable();



        //then


    }
}
