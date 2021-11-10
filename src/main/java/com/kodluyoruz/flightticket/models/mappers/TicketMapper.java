package com.kodluyoruz.flightticket.models.mappers;

import com.kodluyoruz.flightticket.models.dto.TicketDto;
import com.kodluyoruz.flightticket.models.entity.Ticket;
import com.kodluyoruz.flightticket.models.requests.ticket.TicketCreateRequest;
import com.kodluyoruz.flightticket.models.requests.ticket.UpdateTicketRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    TicketMapper MAPPER_TICKET = Mappers.getMapper(TicketMapper.class);


     TicketDto ticketToTicketDto(Ticket ticket);

    Ticket creatTicketRequestToTicket(TicketCreateRequest ticketCreateRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTicketRequestToTicket(@MappingTarget Ticket ticket, UpdateTicketRequest updateTicketRequest);
}
