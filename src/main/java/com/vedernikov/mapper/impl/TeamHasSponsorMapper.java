package com.vedernikov.mapper.impl;

import org.springframework.stereotype.Component;
import com.vedernikov.DTO.TeamHasSponsorDTO;
import com.vedernikov.domain.TeamHasSponsor;
import com.vedernikov.mapper.AbstractMapper;

@Component
public class TeamHasSponsorMapper implements AbstractMapper<TeamHasSponsor, TeamHasSponsorDTO> {
    @Override
    public TeamHasSponsorDTO map(TeamHasSponsor teamHasSponsor){
        return TeamHasSponsorDTO.builder()
                .id(teamHasSponsor.getId())
                .sponsorId(teamHasSponsor.getSponsorId())
                .teamId(teamHasSponsor.getTeamId())
                .build();
    }
}
