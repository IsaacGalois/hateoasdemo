package com.aston.hateoasdemo.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import com.aston.hateoasdemo.domain.Country;
import com.aston.hateoasdemo.domain.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Resource<Country>> getAllCountries() {
        List<Resource<Country>> resources = new ArrayList<>();
        for(Country country:countryService.listAllCountries()) {
            resources.add(getCountryResource(country));
        }

        return resources;
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resource<Country> getCountry(@PathVariable(value = "id") int id) {
        Country country = countryService.getCountryById(id);
        return getCountryResource(country);
    }

    private Resource<Country> getCountryResource(Country country) {
        Resource<Country> resource = new Resource<>(country);

        resource.add(linkTo(methodOn(CountryController.class).getCountry(country.getId())).withSelfRel());
        resource.add(linkTo(methodOn(ContinentController.class).getContinent(country.getContinent().getId())).withRel("continent"));

        return  resource;
    }
}
