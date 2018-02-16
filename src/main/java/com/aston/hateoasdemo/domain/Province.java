package com.aston.hateoasdemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ProvinceId")
    private int id;

    private String name;
    private String capitol;
    private int population;

    @ManyToOne
    private Country country;

    public Province(String name, String capitol, int population, Country country) {
        this.name = name;
        this.capitol = capitol;
        this.population = population;
        this.country = country;
    }
}
