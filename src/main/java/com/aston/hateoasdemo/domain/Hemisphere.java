package com.aston.hateoasdemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Hemisphere {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HemisphereId")
    private int id;

    private String name;

    public Hemisphere(String name) {
        this.name = name;
    }
}
