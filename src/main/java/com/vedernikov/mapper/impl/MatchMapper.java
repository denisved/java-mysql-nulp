package com.vedernikov.mapper.impl;

import org.springframework.stereotype.Component;
import com.vedernikov.DTO.MatchDTO;
import com.vedernikov.domain.Match;
import com.vedernikov.mapper.AbstractMapper;

@Component
public class MatchMapper implements AbstractMapper<Match, MatchDTO> {
    @Override
    public MatchDTO map(Match match){
        return MatchDTO.builder()
                .id(match.getId())
                .Stadium_id(match.getStadiumId())
                .winner(match.getWinner())
                .loser(match.getLoser())
                .draw(match.getDraw())
                .final_score(match.getFinalScore())
                .goals_total(match.getGoalsTotal())
                .red_cards(match.getRedCards())
                .yellow_cards(match.getYellowCards())
                .number_of_replacements(match.getNumberOfReplacements())
                .number_of_fouls(match.getNumberOfFouls())
                .number_of_offsides(match.getNumberOfOffsides())
                .number_of_corners(match.getNumberOfCorners())
                .start_time(match.getStartTime())
                .end_time(match.getEndTime())
                .build();
    }
}
