package com.kodluyoruz.flightticket.models.mappers;

import com.kodluyoruz.flightticket.models.dto.PlaneDto;
import com.kodluyoruz.flightticket.models.entity.aboutPlane.Plane;
import com.kodluyoruz.flightticket.models.requests.plane.PlaneCreateRequest;
import com.kodluyoruz.flightticket.models.requests.plane.PlaneUpdateRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaneMapper {
    PlaneMapper MAPPER_PLANE = Mappers.getMapper(PlaneMapper.class);

    Plane requestToPlane(PlaneCreateRequest planeCreateRequest);

    PlaneDto planeToPlaneDto(Plane createdPlane);

    List<PlaneDto> planeToPlaneDtos(List<Plane> planes);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void planeUpdateRequest(@MappingTarget Plane plane, PlaneUpdateRequest planeUpdateRequest);
}
