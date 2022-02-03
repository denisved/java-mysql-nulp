package com.vedernikov.mapper.impl;

import org.springframework.stereotype.Component;
import com.vedernikov.DTO.CityDTO;
import com.vedernikov.domain.City;
import com.vedernikov.mapper.AbstractMapper;

@Component
public class CityMapper implements AbstractMapper<City, CityDTO> {
    @Override
    public CityDTO map(City city){
        return CityDTO.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }
}
