package com.aston.hateoasdemo.domain.repositories;

import com.aston.hateoasdemo.domain.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer>{
}
