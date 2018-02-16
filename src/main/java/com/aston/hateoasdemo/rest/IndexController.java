package com.aston.hateoasdemo.rest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class IndexController {

    @RequestMapping(value = {"/",""}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getIndex() {
        return Stream.of("http://localhost:8080/provinces","http://localhost:8080/countries","http://localhost:8080/continents","http://localhost:8080/hemispheres").collect(Collectors.toList());
    }
}
