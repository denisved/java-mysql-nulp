package com.vedernikov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.vedernikov.domain.MainCoach;
import com.vedernikov.repository.MainCoachRepository;
import com.vedernikov.service.AbstractService;

@AllArgsConstructor
@Service
public class MainCoachService extends AbstractService<MainCoach> {
    private final MainCoachRepository mainCoachRepository;

    @Override
    public JpaRepository<MainCoach, Integer> getRepository(){
        return mainCoachRepository;
    }
}
