package com.kodluyoruz.flightticket.models.mappers;

import com.kodluyoruz.flightticket.models.dto.FlightDto;
import com.kodluyoruz.flightticket.models.dto.PageAbleResponse;
import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.requests.flight.FlightCreateRequest;
import com.kodluyoruz.flightticket.models.requests.flight.FlightUpdateRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

import static com.kodluyoruz.flightticket.models.mappers.PageAbleMapper.MAPPER_PAGE_ABLE;

@Mapper(uses = GateRegMapper.class ) //componentModel = "spring",
public interface FlightMapper {
    FlightMapper MAPPER_FLIGHT = Mappers.getMapper(FlightMapper.class);

    @Mapping(source = "gateRegCreateRequest", target = "gateReg")
    Flight createRequestToFlight(FlightCreateRequest flightCreateRequest);

    FlightDto flightToFlightDto(Flight createdFlight);

   List<FlightDto> flightsToFlightDtos(List<Flight> flights);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void flightUpdateRequest(@MappingTarget Flight flight, FlightUpdateRequest flightUpdateRequest);

    default PageAbleResponse<FlightDto> flightPageToFlightPageDtos(Page<Flight> flightPage){
        return MAPPER_PAGE_ABLE.toPageDto(flightPage,MAPPER_FLIGHT::flightToFlightDto);
    }
}
