package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.exceptions.exceptionsType.NotFoundEntityException;
import com.kodluyoruz.flightticket.models.dto.PageAbleResponse;
import com.kodluyoruz.flightticket.models.dto.PassangerDto;
import com.kodluyoruz.flightticket.models.entity.Passenger;
import com.kodluyoruz.flightticket.models.requests.PageableRequest;
import com.kodluyoruz.flightticket.models.requests.passanger.CreatePassangerRequest;
import com.kodluyoruz.flightticket.models.requests.passanger.PassengerUpdateRequest;
import com.kodluyoruz.flightticket.models.requests.passanger.SearchPassengerRequest;
import com.kodluyoruz.flightticket.repositories.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.flightticket.models.mappers.PassengerMapper.MAPPER_PASSENGER;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;


    public PassangerDto createPassenger(CreatePassangerRequest createPassangerRequest) {
        Passenger passenger = MAPPER_PASSENGER.createPassengerRequestToPassenger(createPassangerRequest);
        Passenger createdPassenger = passengerRepository.save(passenger);
        return MAPPER_PASSENGER.passengerToPassengerDto(createdPassenger);
    }

    public PassangerDto getPassanger(Integer id) {
        Passenger passenger = getPassengerEntity(id);
        return MAPPER_PASSENGER.passengerToPassengerDto(passenger);
    }

    private Passenger getPassengerEntity(Integer id) {
        Passenger passenger = passengerRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException(id + "Passenger Not Found")
        );
        return passenger;
    }
    //@Valid PageableRequest pageableRequest
    public PageAbleResponse<PassangerDto> searchPassengers(SearchPassengerRequest searchPassengerRequest,
                                                           PageableRequest pageableRequest) {

        Page<Passenger> passengers = passengerRepository.findPassengerWithNameOrMail(
                searchPassengerRequest.getName(),
                searchPassengerRequest.getMail(),
                PageRequest.of(pageableRequest.getCurrentPage(), pageableRequest.getSizePage())
        );
        return MAPPER_PASSENGER.passengerPageToPassengerPageDtos(passengers);

    }

    public void deletePassenger(Integer id) {
        passengerRepository.deleteById(id);
    }

    public PassangerDto updatePassenger(Integer id, PassengerUpdateRequest passengerUpdateRequest) {
        Passenger passenger = getPassengerEntity(id);
        MAPPER_PASSENGER.passengerUpdateFromUpdateRequest(passenger,passengerUpdateRequest);
        return MAPPER_PASSENGER.passengerToPassengerDto(passengerRepository.save(passenger));
    }
}
