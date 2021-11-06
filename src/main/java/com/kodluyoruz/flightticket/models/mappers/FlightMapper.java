package com.kodluyoruz.flightticket.models.mappers;

import com.kodluyoruz.flightticket.models.dto.FlightDto;
import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightMapper MAPPER_FLIGHT = Mappers.getMapper(FlightMapper.class);

    @Mapping(source = "gateRegCreateRequest", target = "gateReg")
    Flight createRequestToFlight(FlightCreateRequest flightCreateRequest);

    FlightDto flightToFlightDto(Flight createdFlight);
}
