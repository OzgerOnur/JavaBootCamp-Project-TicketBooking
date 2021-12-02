package com.kodluyoruz.flightticket.models.mappers;

import com.kodluyoruz.flightticket.models.dto.PageAbleResponse;
import com.kodluyoruz.flightticket.models.dto.PlaneDto;
import com.kodluyoruz.flightticket.models.entity.aboutPlane.Plane;
import com.kodluyoruz.flightticket.models.requests.plane.PlaneCreateRequest;
import com.kodluyoruz.flightticket.models.requests.plane.PlaneUpdateRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

import static com.kodluyoruz.flightticket.models.mappers.PageAbleMapper.MAPPER_PAGE_ABLE;

@Mapper()//componentModel = "spring"
public interface PlaneMapper {
    PlaneMapper MAPPER_PLANE = Mappers.getMapper(PlaneMapper.class);

    Plane requestToPlane(PlaneCreateRequest planeCreateRequest);

    PlaneDto planeToPlaneDto(Plane createdPlane);

    List<PlaneDto> planeToPlaneDtos(List<Plane> planes);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void planeUpdateRequest(@MappingTarget Plane plane, PlaneUpdateRequest planeUpdateRequest);

    default PageAbleResponse<PlaneDto> planePageToPlanePageDtos(Page<Plane> planePage){
        return MAPPER_PAGE_ABLE.toPageDto(planePage,MAPPER_PLANE::planeToPlaneDto);
    }


}
