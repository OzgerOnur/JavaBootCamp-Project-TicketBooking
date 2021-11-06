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
        // gateid ile airport eşleşiyor mu
        Gate gate = gateRepository.findByIdAndAirportIdEquals(gateReg.getGateId(), fromAirportId).orElseThrow(
                () -> new NotFoundEntityException(fromAirportId + " And "+ gateReg.getGateId() + "arent matched")
        );
       //todo  // bu gate idye sahip Gate'de Gatereg durumu ne denemesini yap
        gateRegRepository.existsGateRegByGateIdEqualsAndStartingDateIsBetweenOrEndDateIsBetween(
                gate.getId(),gateReg.getStartingDate(),gateReg.getEndDate())
                    .ifPresent(
                            (aBoolean) -> new NotFoundEntityException(
                            "Gate of "+gate.getId() + " is Booked earlier ")
                    );

    }
}
