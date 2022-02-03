package com.vedernikov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.vedernikov.domain.Referee;
import com.vedernikov.repository.RefereeRepository;
import com.vedernikov.service.AbstractService;

@AllArgsConstructor
@Service
public class RefereeService extends AbstractService<Referee> {
    private final RefereeRepository refereeRepository;

    @Override
    public JpaRepository<Referee, Integer> getRepository(){
        return refereeRepository;
    }
}
