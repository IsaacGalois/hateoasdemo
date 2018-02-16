package com.aston.hateoasdemo.domain.services;

import com.aston.hateoasdemo.domain.Continent;

public interface ContinentService {

    Iterable<Continent> listAllContinents();

    Continent getContinentById(int id);

    Continent saveContinent(Continent continent);

    Iterable<Continent> saveContinentList(Iterable<Continent> continentIterable);

    void deleteContinent(int id);
}
