package com.xo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xo.exception.CityNotFoundException;
import com.xo.model.entity.City;
import com.xo.repository.CityRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Autowired
    CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City getCity(String code) {
        log.debug("Getting city with code {}", code);
        City city = cityRepository.findByCode(code);
        if (city == null) {
            throw new CityNotFoundException(code);
        }
        return city;
    }
}
