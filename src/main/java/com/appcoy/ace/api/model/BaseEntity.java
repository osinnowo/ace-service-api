package com.appcoy.ace.api.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDate;

@MappedSuperclass
@Getter
public class BaseEntity<T> {
    @Id
    @GeneratedValue
    protected Long id;
    protected LocalDate dateCreated;
    protected LocalDate dateModified;
    protected Boolean isDeleted;
}
