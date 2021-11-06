package com.kodluyoruz.flightticket.exceptions;

import com.kodluyoruz.flightticket.exceptions.exceptionsType.NotFoundEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionsHandler {

    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<String> notFoundEntity(NotFoundEntityException exception){
        log.trace("\n -- " + exception.getLocalizedMessage() + "\n ++ " + exception.getStackTrace() + "\n -- ");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());

    }



}
