package com.kodluyoruz.flightticket.models.requests.passanger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePassangerRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String mail;

}
