package com.aston.hateoasdemo.domain.services;

import com.aston.hateoasdemo.domain.Province;

public interface ProvinceService {

    Iterable<Province> listAllProvinces();

    Province getProvinceById(int id);

    Province saveProvince(Province province);

    Iterable<Province> saveProvinceList(Iterable<Province> provinceIterable);

    void deleteProvince(int id);
}
