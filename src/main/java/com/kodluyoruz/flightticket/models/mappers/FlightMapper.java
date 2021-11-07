package com.kodluyoruz.flightticket.models.mappers;

import com.kodluyoruz.flightticket.models.dto.FlightDto;
import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import com.kodluyoruz.flightticket.models.requests.flight.FlightUpdateRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightMapper MAPPER_FLIGHT = Mappers.getMapper(FlightMapper.class);

    @Mapping(source = "gateRegCreateRequest", target = "gateReg")
    Flight createRequestToFlight(FlightCreateRequest flightCreateRequest);

    FlightDto flightToFlightDto(Flight createdFlight);

   List<FlightDto> flightsToFlightDtos(List<Flight> flights);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void flightUpdateRequest(@MappingTarget Flight flight, FlightUpdateRequest flightUpdateRequest);
}
