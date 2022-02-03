package com.vedernikov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.vedernikov.domain.Team;
import com.vedernikov.repository.TeamRepository;
import com.vedernikov.service.AbstractService;

@AllArgsConstructor
@Service
public class TeamService extends AbstractService<Team> {
    private final TeamRepository teamRepository;

    @Override
    public JpaRepository<Team, Integer> getRepository(){
        return teamRepository;
    }
}
