package com.aston.hateoasdemo.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import com.aston.hateoasdemo.domain.Continent;
import com.aston.hateoasdemo.domain.Hemisphere;
import com.aston.hateoasdemo.domain.services.ContinentService;
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
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @RequestMapping(value = "/continents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Resource<Continent>> getAllContinents() {
        List<Resource<Continent>> resources = new ArrayList<>();
        for(Continent continent:continentService.listAllContinents()) {
            resources.add(getContinentResource(continent));
        }

        return resources;
    }

    @RequestMapping(value = "/continent/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resource<Continent> getContinent(@PathVariable(value = "id") int id) {
        Continent continent = continentService.getContinentById(id);
        return getContinentResource(continent);
    }

    private Resource<Continent>getContinentResource(Continent continent) {
        Resource<Continent> resource = new Resource<>(continent);

        resource.add(linkTo(methodOn(ContinentController.class).getContinent(continent.getId())).withSelfRel());
        for(Hemisphere hemisphere:continent.getHemisphereList()) {
            resource.add(linkTo(methodOn(HemisphereController.class).getHemisphere(hemisphere.getId())).withRel("hemisphere"));
        }

        return resource;
    }
}
