package com.mehmetaliakar.springbootaccountuserdemo.core.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdDate;
    private Date updatedDate;
    @PrePersist
    public void onCreate(){
        this.createdDate = new Date();
    }
    @PreUpdate
    public void onUpdate(){
        this.updatedDate = new Date();
    }
}
