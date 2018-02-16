package com.aston.hateoasdemo.domain.services.impl;

import com.aston.hateoasdemo.domain.Province;
import com.aston.hateoasdemo.domain.repositories.ProvinceRepository;
import com.aston.hateoasdemo.domain.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService{

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> listAllProvinces() {
        return provinceRepository.findAll();
    }

    @Override
    public Province getProvinceById(int id) {
        return provinceRepository.findOne(id);
    }

    @Override
    public Province saveProvince(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public Iterable<Province> saveProvinceList(Iterable<Province> provinceIterable) {
        return provinceRepository.save(provinceIterable);
    }

    @Override
    public void deleteProvince(int id) {
        provinceRepository.delete(id);
    }
}
