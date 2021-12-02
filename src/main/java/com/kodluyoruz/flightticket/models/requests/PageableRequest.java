package com.kodluyoruz.flightticket.models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableRequest {

    @NotNull
    Integer currentPage;
    @NotNull
    Integer sizePage;


    public void setCurrentPage(Integer i){
        this.currentPage = i - 1; // so that the user side can start from the first page
       if(this.currentPage <= 0 ) this.currentPage = 0;
    }
}
