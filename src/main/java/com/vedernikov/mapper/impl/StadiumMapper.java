package com.vedernikov.mapper.impl;

import org.springframework.stereotype.Component;
import com.vedernikov.DTO.StadiumDTO;
import com.vedernikov.domain.Stadium;
import com.vedernikov.mapper.AbstractMapper;

@Component
public class StadiumMapper implements AbstractMapper<Stadium, StadiumDTO> {
    @Override
    public StadiumDTO map(Stadium stadium){
        return StadiumDTO.builder()
                .id(stadium.getId())
                .City_id(stadium.getCityId())
                .name(stadium.getName())
                .capacity(stadium.getCapacity())
                .build();
    }
}
