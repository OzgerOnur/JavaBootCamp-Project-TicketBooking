package com.kodluyoruz.flightticket.models.mappers;

import com.kodluyoruz.flightticket.models.dto.GateRegDto;
import com.kodluyoruz.flightticket.models.entity.GateReg;
import com.kodluyoruz.flightticket.models.requests.Gate.GateRegInFlightUpdateRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GateRegMapper {
    GateRegMapper MAPPER_GATEREG = Mappers.getMapper(GateRegMapper.class);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void GateRegUpdate(@MappingTarget GateReg gateReg, GateRegInFlightUpdateRequest gateRegInFlightUpdateRequest) ;

    GateReg gateregUpdateRequestToGatereg(GateRegInFlightUpdateRequest gateRegInFlightUpdateRequest);


    List<GateRegDto> gateregsToGateRegDtos(List<GateReg> gateRegs);
}
