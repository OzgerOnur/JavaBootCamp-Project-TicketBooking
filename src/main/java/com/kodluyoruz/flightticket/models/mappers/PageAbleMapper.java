package com.kodluyoruz.flightticket.models.mappers;


import com.kodluyoruz.flightticket.models.dto.PageAbleResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper() //componentModel = "spring"
public interface PageAbleMapper   {
     PageAbleMapper MAPPER_PAGE_ABLE = Mappers.getMapper(PageAbleMapper.class);

    default <T,DTO> PageAbleResponse<DTO> toPageDto(Page<T> page,Function<T,DTO> mapperFon){
        PageAbleResponse<DTO> pageAbleResponse = PageAbleResponse.<DTO>builder()
                .totalPage(page.getTotalPages())
                .totalElement((int)page.getTotalElements())
                .currentPageNumber(page.getNumber() + 1) // pageAble start on zero
                .currentPageSize(page.getNumberOfElements())
                .data(page.stream().map(t -> mapperFon.apply(t)).collect(Collectors.toList()))
                .build();

        return pageAbleResponse;
    }

    default <T,DTO> PageAbleResponse<DTO> toPageDto(Page<T> page,List<DTO> dtoList){
        PageAbleResponse<DTO> pageAbleResponse = PageAbleResponse.<DTO>builder()
                .totalPage(page.getTotalPages())
                .totalElement((int)page.getTotalElements())
                .currentPageNumber(page.getNumber() + 1) // pageAble start on zero
                .data(dtoList)
                .currentPageSize(page.getNumberOfElements())
                .build();

        return pageAbleResponse;
    }




}

// , Function<T,DTO> mapperFon