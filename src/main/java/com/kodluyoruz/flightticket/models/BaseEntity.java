package com.kodluyoruz.flightticket.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Builder
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;
    //@Builder.Default
    private Boolean deleted = false;





}