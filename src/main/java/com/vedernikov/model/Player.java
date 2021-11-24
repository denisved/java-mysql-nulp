package com.vedernikov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@ToString
@AllArgsConstructor
@Getter
@Setter

public class Player {
    private Integer id;
    private Integer Team_id;
    private String name;
    private String surname;
    private Integer age;
    private String position;
    private Integer salary_for_season_in_euros;
    private String start_of_contract;
    private String end_of_contract;
    private String nationality;
    private Integer goals;
    private Integer assists;

    public Player(Integer team_id, String name, String surname, Integer age, String position,
                  Integer salary_for_season_in_euros, String start_of_contract, String end_of_contract,
                  String nationality, Integer goals, Integer assists) {
        this(null, team_id, name, surname, age, position, salary_for_season_in_euros, start_of_contract, end_of_contract,
                nationality, goals, assists);
    }
}
