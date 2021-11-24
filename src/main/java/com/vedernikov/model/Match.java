package com.vedernikov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class Match {
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

    public Match(Integer stadium_id, String winner, String loser, Integer draw, String final_score,
                 Integer goals_total, Integer red_cards, Integer yellow_cards, Integer number_of_replacements,
                 Integer number_of_fouls, Integer number_of_offsides, Integer number_of_corners, String start_time,
                 String end_time) {
        this(null, stadium_id, winner, loser, draw, final_score, goals_total, red_cards, yellow_cards,
                number_of_replacements, number_of_fouls, number_of_offsides, number_of_corners, start_time, end_time);
    }
}
