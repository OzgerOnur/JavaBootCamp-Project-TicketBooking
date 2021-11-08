package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.exceptions.exceptionsType.NotFoundEntityException;
import com.kodluyoruz.flightticket.models.dto.PassangerDto;
import com.kodluyoruz.flightticket.models.entity.Passenger;
import com.kodluyoruz.flightticket.models.mappers.PassengerMapper;
import com.kodluyoruz.flightticket.models.requests.passanger.CreatePassangerRequest;
import com.kodluyoruz.flightticket.models.requests.passanger.PassengerUpdateRequest;
import com.kodluyoruz.flightticket.models.requests.passanger.SearchPassengerRequest;
import com.kodluyoruz.flightticket.repositorys.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.flightticket.models.mappers.PassengerMapper.MAPPER_PASSENGER;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;


    public PassangerDto createPassanger(CreatePassangerRequest createPassangerRequest) {
        Passenger passenger = MAPPER_PASSENGER.createPassangerRequestToPassenger(createPassangerRequest);
        Passenger createdPassenger = passengerRepository.save(passenger);
        return MAPPER_PASSENGER.passengerToPassengerDto(createdPassenger);
    }

    public PassangerDto getPassanger(Integer id) {
        Passenger passenger = getPassengerEntity(id);
        return MAPPER_PASSENGER.passengerToPassengerDto(passenger);
    }

    private Passenger getPassengerEntity(Integer id) {
        Passenger passenger = passengerRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException(id + "Passanger Not Found")
        );
        return passenger;
    }

    public List<PassangerDto> searchPassengers(SearchPassengerRequest searchPassengerRequest) {
        List<Passenger> passengers = passengerRepository.findPassengerWithNameOrMail(
                searchPassengerRequest.getName(),
                searchPassengerRequest.getMail()
        );
        return MAPPER_PASSENGER.passengersToPassengerDtos(passengers);

    }

    public void deletePassenger(Integer id) {
        passengerRepository.deleteById(id);
        // todo tickets of this passanger should be deleted because there is soft delete
        // todo  or try is this doing soft delete on Cascade too
    }

    public PassangerDto updatePassenger(Integer id, PassengerUpdateRequest passengerUpdateRequest) {
        Passenger passenger = getPassengerEntity(id);
        MAPPER_PASSENGER.passengerUpdateFromUpdateRequest(passenger,passengerUpdateRequest);
        return MAPPER_PASSENGER.passengerToPassengerDto(passengerRepository.save(passenger));
        // todo update edince cascadelerini de ediyor mu ? yani onlarında da idsini eşitliyor mu
    }
}