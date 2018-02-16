package com.aston.hateoasdemo.domain.services;

import com.aston.hateoasdemo.domain.Country;

public interface CountryService {

    Iterable<Country> listAllCountries();

    Country getCountryById(int id);

    Country saveCountry(Country country);

    Iterable<Country> saveCountryList(Iterable<Country> countryIterable);

    void deleteCountry(int id);
}
