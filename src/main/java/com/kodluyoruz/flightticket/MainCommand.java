package com.kodluyoruz.flightticket;

import com.kodluyoruz.flightticket.models.entity.*;
import com.kodluyoruz.flightticket.models.entity.aboutAirport.Airport;
import com.kodluyoruz.flightticket.models.entity.aboutAirport.Gate;
import com.kodluyoruz.flightticket.models.entity.aboutPlane.Plane;
import com.kodluyoruz.flightticket.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.util.*;

//@Component
@RequiredArgsConstructor
public class MainCommand implements CommandLineRunner {
    private final PlaneRepository planeRepository;
    private final AirportRepository airportRepository;
    private final GateRepository gateRepository;
    private final FlightRepository flightRepository;
    private final GateRegRepository gateRegRepository;
    private final PassengerRepository passengerRepository;
    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;



    List<Plane> planeBuilder(){
        List<Plane> planes = Arrays.asList(
                Plane.builder().capacity(120).name("Boing").serialNumber(1990).flights(null).build(),
                Plane.builder().capacity(50).name("airCraft").serialNumber(1980).flights(null).build()
        );

        for (Plane p: planes) {
            p = planeRepository.save(p);
        }
        return planes;

    } // 2 plane

    List<Airport> airportBuilder(){
        List<Airport> airports = Arrays.asList(
                Airport.builder().name("Sabiha").gateCapacity(50).gates(new ArrayList<Gate>()).takingFlights(null).goingFlights(null).build(),
                Airport.builder().name("London").gateCapacity(30).gates(new ArrayList<Gate>()).takingFlights(null).goingFlights(null).build(),
                Airport.builder().name("Esenboga").gateCapacity(50).gates(new ArrayList<Gate>()).takingFlights(null).goingFlights(null).build()
        );

        for (Airport ap: airports) {
            ap = airportRepository.save(ap);
        }
        return airports;

    } // 3 airport

    List<Gate>  gatesBuilder(List<Airport> airports){
        List<Gate> gatesTurnback = new ArrayList<>();

        for (Airport ap: airports) {
            List<Gate> gates = Arrays.asList(
                    Gate.builder().gateNumber(null).airportId(null).gateRegs(null).build(),
                    Gate.builder().gateNumber(null).airportId(null).gateRegs(null).build(),
                    Gate.builder().gateNumber(null).airportId(null).gateRegs(null).build(),
                    Gate.builder().gateNumber(null).airportId(null).gateRegs(null).build()
            );
            int i = 1;
            for (Gate g: gates) {
                g.setGateNumber(i);
                i++;
                g.setAirportId(ap.getId());
                g = gateRepository.save(g);

            }
            ap.getGates().addAll(gates);
            gatesTurnback.addAll(gates);
        }
        return gatesTurnback;
    } //4 gate for each airport
        // 3 flight to this gateReg
    List<Flight> flightAndGateRegBuilder(List<Plane> planes, List<Airport> airports, List<Gate> gates ){

        // gateReg numbers should be equal Flight number
        List<GateReg> gateRegs = Arrays.asList(
                GateReg.builder().flightId(null).gateId(null).startingDate(new Date()).endDate(new Date()).build(),
                GateReg.builder().flightId(null).gateId(null).startingDate(new Date()).endDate(new Date()).build()
        );

        List<Date> flightDates = new ArrayList<>();
        for (int i = 0; i<gateRegs.size(); i++){
            flightDates.add(new Date());

            gateRegs.get(i).getStartingDate().setTime(gateRegs.get(i).getStartingDate().getTime() + (long)10*i*1000*60*60);
            gateRegs.get(i).getEndDate().setTime(gateRegs.get(i).getStartingDate().getTime() + 1000*60*60);
            flightDates.get(i).setTime(gateRegs.get(i).getEndDate().getTime() - 1000*60*20 );
        }

        List<Flight> fligts = new ArrayList<>();

               Flight flight0 =  Flight.builder().planeId(
                                planes.get(0).getId())
                        .toAirportId(airports.get(0).getId())
                        .fromAirportId(airports.get(1).getId())
                        .flightDate(flightDates.get(0))
                        .gateReg(null).seats(null).build();
               flight0 = flightRepository.save(flight0);
               gateRegs.get(0).setGateId(airports.get(1).getGates().get(0).getId());
               gateRegs.get(0).setFlightId(flight0.getId());
               gateRegRepository.save(gateRegs.get(0));
               fligts.add(flight0);

        Flight flight1 =  Flight.builder().planeId(
                        planes.get(1).getId())
                .toAirportId(airports.get(2).getId())
                .fromAirportId(airports.get(1).getId())
                .flightDate(flightDates.get(1))
                .gateReg(null).seats(null).build();
        flight1 = flightRepository.save(flight1);
        gateRegs.get(1).setGateId(airports.get(1).getGates().get(1).getId());
        gateRegs.get(1).setFlightId(flight1.getId());
        gateRegRepository.save(gateRegs.get(1));
        fligts.add(flight1);

        return fligts;
    }

    List<Passenger> passengerBuilder(){
        List<Passenger> passengers = Arrays.asList(
                Passenger.builder().name("ali").mail("ali@mail").build(),
                Passenger.builder().name("veli").mail("veli@mail").build(),
                Passenger.builder().name("zeynep").mail("zeynep@mail").build(),
                Passenger.builder().name("ayse").mail("ayse@mail").build(),
                Passenger.builder().name("berkeCan").mail("berkeCan@mail").build(),
                Passenger.builder().name("PelinSu").mail("PelinSu@mail").build()
        );

        passengers = passengerRepository.saveAll(passengers);
        return passengers;

    }

    List<Ticket> ticketBuilder(List<Passenger> passengers){
        List<Ticket> tickets = Arrays.asList(
                Ticket.builder().passengerId(null).seat(null).build(),
                Ticket.builder().passengerId(null).seat(null).build(),
                Ticket.builder().passengerId(null).seat(null).build(),
                Ticket.builder().passengerId(null).seat(null).build(),
                Ticket.builder().passengerId(null).seat(null).build(),
                Ticket.builder().passengerId(null).seat(null).build()
        );
        for (int i = 0; i < tickets.size();i++){
            tickets.get(i).setPassengerId(passengers.get(i).getId());
        }
        return ticketRepository.saveAll(tickets);

    }

    List<Seat> seatBuilder(List<Ticket> tickets, List<Flight> flights){
        List<Seat> seats = Arrays.asList(
                Seat.builder().seatNumber(null).flightId(null).ticketId(null).build(),
                Seat.builder().seatNumber(null).flightId(null).ticketId(null).build(),
                Seat.builder().seatNumber(null).flightId(null).ticketId(null).build(),
                Seat.builder().seatNumber(null).flightId(null).ticketId(null).build(),
                Seat.builder().seatNumber(null).flightId(null).ticketId(null).build(),
                Seat.builder().seatNumber(null).flightId(null).ticketId(null).build()
        );
        for (int i = 0; i < 3;i++){
            seats.get(i).setSeatNumber(i+7);
            seats.get(i).setFlightId(flights.get(0).getId());
            seats.get(i).setTicketId(tickets.get(i).getId());
        }
        for (int i = 3; i < 6;i++){
            seats.get(i).setSeatNumber(i+7);
            seats.get(i).setFlightId(flights.get(1).getId());
            seats.get(i).setTicketId(tickets.get(i).getId());
        }

        return seatRepository.saveAll(seats);



    }


    @Override
    public void run(String... args) throws Exception {

        List<Plane> Planes = planeBuilder();
        List<Airport> airports = airportBuilder();
        List<Gate> gates = gatesBuilder(airports);
        List<Flight> flights = flightAndGateRegBuilder(Planes,airports,gates);
        List<Passenger> passengers = passengerBuilder();
        List<Ticket> tickets = ticketBuilder(passengers);
        List<Seat> seats = seatBuilder(tickets,flights);






    }
}
