package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.exceptions.exceptionsType.NotFoundEntityException;
import com.kodluyoruz.flightticket.models.entity.GateReg;
import com.kodluyoruz.flightticket.models.entity.aboutAirport.Gate;
import com.kodluyoruz.flightticket.repositorys.GateRegRepository;
import com.kodluyoruz.flightticket.repositorys.GateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GateService {
    private final GateRepository gateRepository;
    private final GateRegRepository gateRegRepository;


    public void isGateValidAndAvailable(Integer fromAirportId, GateReg gateReg) {

        Gate gate = gateRepository.findByIdAndAirportId(gateReg.getGateId(), fromAirportId).orElseThrow(
                () -> new NotFoundEntityException(fromAirportId + " And "+ gateReg.getGateId() + "arent matched")
        );

        if (gateRegRepository.existsGateRegByGateIdEqualsAndStartingDateIsBetweenOrEndDateIsBetween(
                gate.getId()
                ,gateReg.getStartingDate(),gateReg.getEndDate()
                ,gateReg.getStartingDate(),gateReg.getEndDate())){
            throw new NotFoundEntityException("Gate of "+gate.getId() + " is Booked earlier ");
        }

    }
}
