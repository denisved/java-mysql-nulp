package com.vedernikov.mapper.impl;

import org.springframework.stereotype.Component;
import com.vedernikov.DTO.PlayerDTO;
import com.vedernikov.domain.Player;
import com.vedernikov.mapper.AbstractMapper;

@Component
public class PlayerMapper implements AbstractMapper<Player, PlayerDTO> {
    @Override
    public PlayerDTO map(Player player){
        return PlayerDTO.builder()
                .id(player.getId())
                .age(player.getAge())
                .assists(player.getAssists())
                .end_of_contract(player.getEndOfContract())
                .goals(player.getGoals())
                .name(player.getName())
                .nationality(player.getNationality())
                .position(player.getPosition())
                .salary_for_season_in_euros(player.getSalary())
                .start_of_contract(player.getStartOfContract())
                .surname(player.getSurname())
                .Team_id(player.getTeamId())
                .build();
    }
}
