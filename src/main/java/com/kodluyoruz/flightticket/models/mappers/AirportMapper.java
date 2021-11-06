package com.kodluyoruz.flightticket.models.mappers;

import com.kodluyoruz.flightticket.models.dto.AirportDto;
import com.kodluyoruz.flightticket.models.entity.aboutAirport.Airport;
import com.kodluyoruz.flightticket.models.requests.AirportRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirportMapper {
    AirportMapper MAPPER_AIRPORT = Mappers.getMapper(AirportMapper.class);

    Airport requestToAirport(AirportRequest airportRequest);

    AirportDto airportToAirportDto(Airport createdAirport);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    void updateAirport(@MappingTarget Airport airport, AirportRequest airportRequest);

    List<AirportDto> airportsToAirportDtos(List<Airport> airports);
}
