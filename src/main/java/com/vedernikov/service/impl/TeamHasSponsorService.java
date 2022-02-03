package com.vedernikov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.vedernikov.domain.TeamHasSponsor;
import com.vedernikov.repository.TeamHasSponsorRepository;
import com.vedernikov.service.AbstractService;

@AllArgsConstructor
@Service
public class TeamHasSponsorService extends AbstractService<TeamHasSponsor> {
    private final TeamHasSponsorRepository teamHasSponsorRepository;

    @Override
    public JpaRepository<TeamHasSponsor, Integer> getRepository(){
        return teamHasSponsorRepository;
    }
}
