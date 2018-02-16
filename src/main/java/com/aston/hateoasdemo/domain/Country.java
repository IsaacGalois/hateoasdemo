package com.aston.hateoasdemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CountryId")
    private int id;

    private String name;
    private String capitol;
    private int population;

    @ManyToOne
    private Continent continent;

    public Country(String name, String capitol, int population, Continent continent) {
        this.name = name;
        this.capitol = capitol;
        this.population = population;
        this.continent = continent;
    }
}
