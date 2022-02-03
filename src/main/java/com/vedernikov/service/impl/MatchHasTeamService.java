package com.vedernikov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.vedernikov.domain.MatchHasTeam;
import com.vedernikov.repository.MatchHasTeamRepository;
import com.vedernikov.service.AbstractService;

@AllArgsConstructor
@Service
public class MatchHasTeamService extends AbstractService<MatchHasTeam> {
    private final MatchHasTeamRepository matchHasTeamRepository;

    @Override
    public JpaRepository<MatchHasTeam, Integer> getRepository(){
        return matchHasTeamRepository;
    }
}
