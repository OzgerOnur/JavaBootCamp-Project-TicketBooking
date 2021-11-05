package com.kodluyoruz.flightticket.models.mappers;

import com.kodluyoruz.flightticket.models.dto.PlaneDto;
import com.kodluyoruz.flightticket.models.entity.aboutPlane.Plane;
import com.kodluyoruz.flightticket.models.requests.PlaneRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaneMapper {
    PlaneMapper MAPPER_PLANE = Mappers.getMapper(PlaneMapper.class);

    Plane requestToPlane(PlaneRequest planeRequest);

    PlaneDto planeToPlaneDto(Plane createdPlane);

    List<PlaneDto> planeToPlaneDtos(List<Plane> planes);
}
