package com.kodluyoruz.flightticket.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder()
public class PageAbleResponse<T>  {
    private int currentPageNumber;
    private int currentPageSize;
    private int totalElement;
    private int totalPage;
    private List<T> data;



}
