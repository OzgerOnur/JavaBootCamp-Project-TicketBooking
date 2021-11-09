package com.kodluyoruz.flightticket.exceptions;

import com.kodluyoruz.flightticket.exceptions.exceptionsType.FlightAndGateRegDateException;
import com.kodluyoruz.flightticket.exceptions.exceptionsType.GateRegEarlierBookedException;
import com.kodluyoruz.flightticket.exceptions.exceptionsType.NotFoundEntityException;
import com.kodluyoruz.flightticket.exceptions.exceptionsType.PlaneCapacityException;
import com.kodluyoruz.flightticket.models.dto.GateRegDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

import static com.kodluyoruz.flightticket.models.mappers.GateRegMapper.MAPPER_GATEREG;

@ControllerAdvice
@Slf4j
public class GlobalExceptionsHandler {

    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<String> notFoundEntity(NotFoundEntityException exception){
        log.trace("\n -- " + exception.getLocalizedMessage() + "\n ++ " + exception.getStackTrace() + "\n -- ");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());

    }

    @ExceptionHandler(GateRegEarlierBookedException.class)
    public ResponseEntity<List<GateRegDto>> gateRegBooked(GateRegEarlierBookedException gateRegEarlierBookedException){
        List<GateRegDto> gateRegDtos = MAPPER_GATEREG.gateregsToGateRegDtos(gateRegEarlierBookedException.getGateRegs());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(gateRegDtos);
    }

    @ExceptionHandler(FlightAndGateRegDateException.class)
    public ResponseEntity<FlightAndGateRegDateException.ExceptionDates> FlightAndGateRegDateNotMatched(FlightAndGateRegDateException flightAndGateRegDateException){
       return ResponseEntity.status(HttpStatus.CONFLICT).body(flightAndGateRegDateException.getExceptionDates());
    }

    @ExceptionHandler(PlaneCapacityException.class)
    public ResponseEntity<PlaneCapacityException.ExceptionFlightCapacity> PlaneCapacityNotValid(PlaneCapacityException planeCapacityException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(planeCapacityException.getExceptionPlanesCapacity());
    }



}
