package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.exceptions.exceptionsType.NotFoundEntityException;
import com.kodluyoruz.flightticket.models.dto.AirportDto;
import com.kodluyoruz.flightticket.models.entity.aboutAirport.Airport;
import com.kodluyoruz.flightticket.models.requests.airport.AirportRequest;
import com.kodluyoruz.flightticket.repositories.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.flightticket.models.mappers.AirportMapper.MAPPER_AIRPORT;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportDto createAirport(AirportRequest airportRequest) {
        Airport airport = MAPPER_AIRPORT.requestToAirport(airportRequest);
        Airport createdAirport = airportRepository.save(airport);
        return MAPPER_AIRPORT.airportToAirportDto(createdAirport);
    }


    public AirportDto getAirport(Integer id) {
        Airport airport = getAirportEntity(id);
        return MAPPER_AIRPORT.airportToAirportDto(airport);
    }

    private Airport getAirportEntity(Integer id) {
        Airport airport = airportRepository.getById(id);
        return airport;
    }

    public AirportDto updateAirport(Integer id, AirportRequest airportRequest) {
        Airport airport = airportRepository.getById(id);
        MAPPER_AIRPORT.updateAirport(airport,airportRequest);
        Airport updatedAirport = airportRepository.save(airport);
        return MAPPER_AIRPORT.airportToAirportDto(updatedAirport);
    }

    public List<AirportDto> getAirports() {
        List<Airport> airports = airportRepository.findAll();
        return MAPPER_AIRPORT.airportsToAirportDtos(airports);
    }


    public void deleteAirport(Integer id) {
        airportRepository.deleteById(id);
    }

    public void isAirportExist(Integer toAirportId) {
        airportRepository.findById(toAirportId).orElseThrow(
                () -> new NotFoundEntityException( toAirportId + "Airport Not Found"));
    }
}
