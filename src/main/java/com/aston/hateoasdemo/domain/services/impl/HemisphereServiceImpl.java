package com.aston.hateoasdemo.domain.services.impl;

import com.aston.hateoasdemo.domain.Hemisphere;
import com.aston.hateoasdemo.domain.repositories.HemisphereRepository;
import com.aston.hateoasdemo.domain.services.HemisphereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HemisphereServiceImpl implements HemisphereService{

    @Autowired
    private HemisphereRepository hemisphereRepository;

    @Override
    public Iterable<Hemisphere> listAllHemispheres() {
        return hemisphereRepository.findAll();
    }

    @Override
    public Hemisphere getHemisphereById(int id) {
        return hemisphereRepository.findOne(id);
    }

    @Override
    public Hemisphere saveHemisphere(Hemisphere hemisphere) {
        return hemisphereRepository.save(hemisphere);
    }

    @Override
    public Iterable<Hemisphere> saveHemisphereList(Iterable<Hemisphere> hemisphereIterable) {
        return hemisphereRepository.save(hemisphereIterable);
    }

    @Override
    public void deleteHemisphere(int id) {
        hemisphereRepository.delete(id);
    }
}
