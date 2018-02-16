package com.aston.hateoasdemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ContinentId")
    private int id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Hemisphere> hemisphereList;

    public Continent(String name, List<Hemisphere> hemisphereList) {
        this.name = name;
        this.hemisphereList = hemisphereList;
    }
}
