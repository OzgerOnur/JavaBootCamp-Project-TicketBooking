package com.kodluyoruz.flightticket.models.mappers;

import com.kodluyoruz.flightticket.models.dto.TicketDto;
import com.kodluyoruz.flightticket.models.entity.Ticket;
import com.kodluyoruz.flightticket.models.requests.ticket.TicketCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    TicketMapper MAPPER_TICKET = Mappers.getMapper(TicketMapper.class);


     TicketDto ticketToTicketDto(Ticket ticket);

    Ticket creatTicketRequestToTicket(TicketCreateRequest ticketCreateRequest);
}
