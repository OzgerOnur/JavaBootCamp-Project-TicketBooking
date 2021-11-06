package com.kodluyoruz.flightticket.exceptions.exceptionsType;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundEntityException extends RuntimeException {
    public NotFoundEntityException(String msg) {
        super(msg);
    }
}
