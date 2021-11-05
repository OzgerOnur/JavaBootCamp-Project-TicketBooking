package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.models.dto.PlaneDto;
import com.kodluyoruz.flightticket.models.entity.aboutPlane.Plane;
import com.kodluyoruz.flightticket.repositorys.PlaneRepository;
import com.kodluyoruz.flightticket.models.requests.PlaneRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.flightticket.models.mappers.PlaneMapper.MAPPER_PLANE;

@Service
@RequiredArgsConstructor
public class PlaneService {
    private final PlaneRepository planeRepository;

    public PlaneDto createPlane(PlaneRequest planeRequest) {
        Plane plane = MAPPER_PLANE.requestToPlane(planeRequest);
        Plane createdPlane = planeRepository.save(plane);
        return MAPPER_PLANE.planeToPlaneDto(createdPlane);
    }

    public List<PlaneDto> getPlanes() {
        List<Plane> planes = planeRepository.findAll();
        return MAPPER_PLANE.planeToPlaneDtos(planes);
    }

    public PlaneDto getPlane(Integer id) {
        Plane plane = getPlaneEntity(id);
        return MAPPER_PLANE.planeToPlaneDto(plane);
    }

    private Plane getPlaneEntity(Integer id) {
        Plane plane = planeRepository.getById(id);
        return plane;
    }

    public void deletePlane(Integer id) {
        //todo delete muhabbeti

    }
}
