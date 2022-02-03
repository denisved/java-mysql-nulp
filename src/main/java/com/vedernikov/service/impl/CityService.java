package com.vedernikov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.vedernikov.domain.City;
import com.vedernikov.repository.CityRepository;
import com.vedernikov.service.AbstractService;

@AllArgsConstructor
@Service
public class CityService extends AbstractService<City> {
    private final CityRepository cityRepository;

    @Override
    public JpaRepository<City, Integer> getRepository(){
        return cityRepository;
    }
}