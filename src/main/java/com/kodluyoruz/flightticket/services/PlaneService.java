package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.exceptions.exceptionsType.NotFoundEntityException;
import com.kodluyoruz.flightticket.exceptions.exceptionsType.PlaneCapacityException;
import com.kodluyoruz.flightticket.models.dto.PlaneDto;
import com.kodluyoruz.flightticket.models.entity.Flight;
import com.kodluyoruz.flightticket.models.entity.aboutPlane.Plane;
import com.kodluyoruz.flightticket.models.requests.plane.PlaneUpdateRequest;
import com.kodluyoruz.flightticket.repositorys.PlaneRepository;
import com.kodluyoruz.flightticket.models.requests.plane.PlaneCreateRequest;
import com.kodluyoruz.flightticket.repositorys.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.flightticket.models.mappers.PlaneMapper.MAPPER_PLANE;

@Service
@RequiredArgsConstructor
public class PlaneService {
    private final PlaneRepository planeRepository;
    private final FlightService flightService;
    private final SeatRepository seatRepository ;


    public PlaneDto createPlane(PlaneCreateRequest planeCreateRequest) {
        Plane plane = MAPPER_PLANE.requestToPlane(planeCreateRequest);
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
        Plane plane = planeRepository.findById(id).orElseThrow(() ->
                new NotFoundEntityException(id + " Plane not found"));
        return plane;
    }

    public void deletePlane(Integer id) {
       planeRepository.deleteById(id);
    }

    public void isPlaneExist(Integer planeId) {
        planeRepository.findById(planeId).orElseThrow(() -> new NotFoundEntityException("Plane Not Found") );
    }


    public PlaneDto updatePlane(Integer id, PlaneUpdateRequest planeUpdateRequest) {
        Plane plane = getPlaneEntity(id);
        MAPPER_PLANE.planeUpdateRequest(plane,planeUpdateRequest);
        PlaneUpdateValid(plane);
        return MAPPER_PLANE.planeToPlaneDto(planeRepository.save(plane));
    }

    private void PlaneUpdateValid(Plane plane) {
        List<Flight> flights = flightService.getFlightWithInPlaneIdAfterNow(plane.getId());
        for (Flight f: flights) {
            Integer soldSeatNumber = seatRepository.countSeatByFlightIdEquals(f.getId());
            if(!(plane.getCapacity() >= soldSeatNumber)){
                throw new PlaneCapacityException(plane,f,soldSeatNumber);
            }
        }
    }
}
