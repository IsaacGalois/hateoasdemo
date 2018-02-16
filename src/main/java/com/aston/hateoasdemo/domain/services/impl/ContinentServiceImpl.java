package com.aston.hateoasdemo.domain.services.impl;

import com.aston.hateoasdemo.domain.Continent;
import com.aston.hateoasdemo.domain.repositories.ContinentRepository;
import com.aston.hateoasdemo.domain.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinentServiceImpl implements ContinentService{

    @Autowired
    private ContinentRepository continentRepository;

    @Override
    public Iterable<Continent> listAllContinents() {
        return continentRepository.findAll();
    }

    @Override
    public Continent getContinentById(int id) {
        return continentRepository.findOne(id);
    }

    @Override
    public Continent saveContinent(Continent continent) {
        return continentRepository.save(continent);
    }

    @Override
    public Iterable<Continent> saveContinentList(Iterable<Continent> continentIterable) {
        return continentRepository.save(continentIterable);
    }

    @Override
    public void deleteContinent(int id) {
        continentRepository.delete(id);
    }
}
