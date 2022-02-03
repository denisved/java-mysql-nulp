package com.vedernikov.mapper.impl;

import org.springframework.stereotype.Component;
import com.vedernikov.DTO.TeamDTO;
import com.vedernikov.domain.Team;
import com.vedernikov.mapper.AbstractMapper;

@Component
public class TeamMapper implements AbstractMapper<Team, TeamDTO> {
    @Override
    public TeamDTO map(Team team){
        return TeamDTO.builder()
                .id(team.getId())
                .Main_Coach_id(team.getMainCoachId())
                .name(team.getName())
                .UPL_position(team.getUplPositon())
                .number_of_draws(team.getNumberOfDraws())
                .number_of_loses(team.getNumberOfLoses())
                .number_of_wins(team.getNumberOfWins())
                .number_of_points(team.getNumberOfPoints())
                .build();
    }
}
