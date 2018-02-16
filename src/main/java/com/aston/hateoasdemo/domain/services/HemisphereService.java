package com.aston.hateoasdemo.domain.services;

import com.aston.hateoasdemo.domain.Hemisphere;

public interface HemisphereService {

    Iterable<Hemisphere> listAllHemispheres();

    Hemisphere getHemisphereById(int id);

    Hemisphere saveHemisphere(Hemisphere hemisphere);

    Iterable<Hemisphere> saveHemisphereList(Iterable<Hemisphere> hemisphereIterable);

    void deleteHemisphere(int id);
}
