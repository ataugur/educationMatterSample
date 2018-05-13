package com.xo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class City extends AbstractEntity {

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 10, unique = true, nullable = false)
    private String code;
}
