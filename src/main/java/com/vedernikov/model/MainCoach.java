package com.vedernikov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class MainCoach {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private Integer salary_for_season_in_euros;
    private String start_of_contract;
    private String end_of_contract;
    private String nationality;

    public MainCoach(String name, String surname, Integer age, Integer salary_for_season_in_euros,
                     String start_of_contract, String end_of_contract, String nationality) {
        this(null, name, surname, age, salary_for_season_in_euros, start_of_contract, end_of_contract, nationality);
    }
}
