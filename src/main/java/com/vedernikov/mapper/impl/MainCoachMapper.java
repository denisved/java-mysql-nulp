package com.vedernikov.mapper.impl;

import org.springframework.stereotype.Component;
import com.vedernikov.DTO.MainCoachDTO;
import com.vedernikov.domain.MainCoach;
import com.vedernikov.mapper.AbstractMapper;

@Component
public class MainCoachMapper implements AbstractMapper<MainCoach, MainCoachDTO> {
    @Override
    public MainCoachDTO map(MainCoach mainCoach){
        return MainCoachDTO.builder()
                .id(mainCoach.getId())
                .name(mainCoach.getName())
                .surname(mainCoach.getSurname())
                .age(mainCoach.getAge())
                .salary_for_season_in_euros(mainCoach.getSalary())
                .start_of_contract(mainCoach.getStartOfContract())
                .end_of_contract(mainCoach.getEndOfContract())
                .nationality(mainCoach.getNationality())
                .build();
    }
}
