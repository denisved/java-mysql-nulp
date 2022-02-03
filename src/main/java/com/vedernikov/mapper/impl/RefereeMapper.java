package com.vedernikov.mapper.impl;

import org.springframework.stereotype.Component;
import com.vedernikov.DTO.RefereeDTO;
import com.vedernikov.domain.Referee;
import com.vedernikov.mapper.AbstractMapper;

@Component
public class RefereeMapper implements AbstractMapper<Referee, RefereeDTO> {
    @Override
    public RefereeDTO map(Referee referee){
        return RefereeDTO.builder()
                .id(referee.getId())
                .age(referee.getAge())
                .Match_id(referee.getMatchId())
                .name(referee.getName())
                .nationality(referee.getNationality())
                .surname(referee.getSurname())
                .build();
    }
}
