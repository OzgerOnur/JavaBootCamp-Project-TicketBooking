package com.kodluyoruz.flightticket.exceptions.exceptionsType;

import com.kodluyoruz.flightticket.models.entity.GateReg;
import lombok.Data;

import java.util.List;

@Data
public class GateRegEarlierBookedException extends RuntimeException {
    private List<GateReg> gateRegs;
    public GateRegEarlierBookedException(List<GateReg> bookedGateReg) {
        gateRegs = bookedGateReg;

    }
}
