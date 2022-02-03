package com.vedernikov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.vedernikov.domain.Stadium;
import com.vedernikov.repository.StadiumRepository;
import com.vedernikov.service.AbstractService;

@AllArgsConstructor
@Service
public class StadiumService extends AbstractService<Stadium> {
    private final StadiumRepository stadiumRepository;

    @Override
    public JpaRepository<Stadium, Integer> getRepository(){
        return stadiumRepository;
    }
}
