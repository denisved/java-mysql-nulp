package com.vedernikov.mapper.impl;

import org.springframework.stereotype.Component;
import com.vedernikov.DTO.MatchHasTeamDTO;
import com.vedernikov.domain.MatchHasTeam;
import com.vedernikov.mapper.AbstractMapper;

@Component
public class MatchHasTeamMapper implements AbstractMapper<MatchHasTeam, MatchHasTeamDTO> {
    @Override
    public MatchHasTeamDTO map(MatchHasTeam matchHasTeam){
        return MatchHasTeamDTO.builder()
                .id(matchHasTeam.getId())
                .Match_id(matchHasTeam.getMatchId())
                .Team_id(matchHasTeam.getTeamId())
                .build();
    }
}
