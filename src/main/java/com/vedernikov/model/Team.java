package com.vedernikov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@ToString
@AllArgsConstructor
@Getter
@Setter

public class Team {
    private Integer id;
    private Integer Main_Coach_id;
    private String name;
    private Integer UPL_position;
    private Integer number_of_wins;
    private Integer number_of_loses;
    private Integer number_of_draws;
    private Integer number_of_points;

    public Team(Integer main_Coach_id, String name, Integer UPL_position, Integer number_of_wins,
                Integer number_of_loses, Integer number_of_draws, Integer number_of_points) {
        this(null, main_Coach_id, name, UPL_position, number_of_wins, number_of_loses, number_of_draws, number_of_points);
    }
}
