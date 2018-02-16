package com.aston.hateoasdemo.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.aston.hateoasdemo.domain.Hemisphere;
import com.aston.hateoasdemo.domain.services.HemisphereService;
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
public class HemisphereController {

    @Autowired
    HemisphereService hemisphereService;

    @RequestMapping(value = "/hemispheres", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Resource<Hemisphere>> getAllHemispheres() {
        List<Resource<Hemisphere>> resources = new ArrayList<>();
        for(Hemisphere continent:hemisphereService.listAllHemispheres()) {
            resources.add(getHemisphereResource(continent));
        }

        return resources;
    }

    @RequestMapping(value = "/hemisphere/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resource<Hemisphere> getHemisphere(@PathVariable(value = "id") int id) {
        Hemisphere hemisphere = hemisphereService.getHemisphereById(id);
        return getHemisphereResource(hemisphere);
    }

    private Resource<Hemisphere> getHemisphereResource(Hemisphere hemisphere) {
        Resource<Hemisphere> hemisphereResource = new Resource(hemisphere);
        hemisphereResource.add(linkTo(methodOn(HemisphereController.class).getHemisphere(hemisphere.getId())).withSelfRel());

        return hemisphereResource;
    }
}
