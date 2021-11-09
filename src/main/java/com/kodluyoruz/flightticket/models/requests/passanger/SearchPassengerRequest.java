package com.kodluyoruz.flightticket.models.requests.passanger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchPassengerRequest {

    @NotNull
    private String name;
    @NotNull
    private String mail;

}
