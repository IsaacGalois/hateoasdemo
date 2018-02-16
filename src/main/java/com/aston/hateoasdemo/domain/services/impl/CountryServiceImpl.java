package com.aston.hateoasdemo.domain.services.impl;

import com.aston.hateoasdemo.domain.Country;
import com.aston.hateoasdemo.domain.repositories.CountryRepository;
import com.aston.hateoasdemo.domain.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;


    @Override
    public Iterable<Country> listAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(int id) {
        return countryRepository.findOne(id);
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Iterable<Country> saveCountryList(Iterable<Country> countryIterable) {
        return countryRepository.save(countryIterable);
    }

    @Override
    public void deleteCountry(int id) {
        countryRepository.delete(id);
    }
}
