package com.kodluyoruz.flightticket.services;

import com.kodluyoruz.flightticket.repositorys.SeatRepository;
import com.kodluyoruz.flightticket.repositorys.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeatAndTicketService {
    private final SeatRepository seatRepository;
    private final TicketRepository ticketRepository;



    protected Integer getSoldSeatOfFlightNumber(Integer flightId){
        return seatRepository.countSeatByFlightIdEquals(flightId);
    }
}
