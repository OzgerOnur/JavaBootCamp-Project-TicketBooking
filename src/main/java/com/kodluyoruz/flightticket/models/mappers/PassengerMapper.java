package com.kodluyoruz.flightticket.models.mappers;

import com.kodluyoruz.flightticket.models.dto.PassangerDto;
import com.kodluyoruz.flightticket.models.entity.Passenger;
import com.kodluyoruz.flightticket.models.requests.passanger.CreatePassangerRequest;
import com.kodluyoruz.flightticket.models.requests.passanger.PassengerUpdateRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    PassengerMapper MAPPER_PASSENGER = Mappers.getMapper(PassengerMapper.class);

    Passenger createPassangerRequestToPassenger(CreatePassangerRequest createPassangerRequest);

    PassangerDto passengerToPassengerDto(Passenger createdPassenger);

    List<PassangerDto> passengersToPassengerDtos(List<Passenger> passengers);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void passengerUpdateFromUpdateRequest(@MappingTarget Passenger passenger, PassengerUpdateRequest passengerUpdateRequest);
}
