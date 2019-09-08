package com.orgon.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Orgon {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String location;

    private Integer chemtrailsPercentage;

    public Orgon(String name, String location, Integer chemtrailsPercentage) {
        this.name = name;
        this.location = location;
        this.chemtrailsPercentage = chemtrailsPercentage;
    }
}
