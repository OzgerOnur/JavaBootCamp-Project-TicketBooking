package com.kodluyoruz.flightticket.models.mappers;

import com.kodluyoruz.flightticket.models.dto.AirportDto;
import com.kodluyoruz.flightticket.models.dto.PageAbleResponse;
import com.kodluyoruz.flightticket.models.entity.aboutAirport.Airport;
import com.kodluyoruz.flightticket.models.requests.airport.AirportRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

import static com.kodluyoruz.flightticket.models.mappers.PageAbleMapper.MAPPER_PAGE_ABLE;

@Mapper(componentModel = "spring")
public interface AirportMapper {
    AirportMapper MAPPER_AIRPORT = Mappers.getMapper(AirportMapper.class);

    Airport requestToAirport(AirportRequest airportRequest);

    AirportDto airportToAirportDto(Airport createdAirport);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    void updateAirport(@MappingTarget Airport airport, AirportRequest airportRequest);

    List<AirportDto> airportsToAirportDtos(List<Airport> airports);

    default PageAbleResponse<AirportDto> airportPageToAirportPageDtos(Page<Airport> airports){
        return MAPPER_PAGE_ABLE.toPageDto(airports,MAPPER_AIRPORT::airportToAirportDto);
    }
}
