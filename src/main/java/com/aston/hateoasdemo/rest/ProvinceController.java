package com.aston.hateoasdemo.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import com.aston.hateoasdemo.domain.Province;
import com.aston.hateoasdemo.domain.services.ProvinceService;
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
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @RequestMapping(value = "/provinces", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Resource<Province>> getAllProvinces() {
        List<Resource<Province>> resources = new ArrayList<>();
        for(Province province:provinceService.listAllProvinces()) {
            resources.add(getProvinceResource(province));
        }

        return resources;
    }

    @RequestMapping(value = "/province/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resource<Province> getProvince(@PathVariable(value = "id") int id) {
        Province province = provinceService.getProvinceById(id);
        return getProvinceResource(province);
    }

    private Resource<Province> getProvinceResource(Province province) {
        Resource<Province> resource = new Resource<>(province);

        resource.add(linkTo(methodOn(ProvinceController.class).getProvince(province.getId())).withSelfRel());
        resource.add(linkTo(methodOn(CountryController.class).getCountry(province.getCountry().getId())).withRel("Country"));

        return resource;
    }
}
