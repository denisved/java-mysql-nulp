package com.vedernikov.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchDTO {
    private Integer id;
    private Integer Stadium_id;
    private String winner;
    private String loser;
    private Integer draw;
    private String final_score;
    private Integer goals_total;
    private Integer red_cards;
    private Integer yellow_cards;
    private Integer number_of_replacements;
    private Integer number_of_fouls;
    private Integer number_of_offsides;
    private Integer number_of_corners;
    private String start_time;
    private String end_time;
}