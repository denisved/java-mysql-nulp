package com.vedernikov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@ToString
@AllArgsConstructor
@Getter
@Setter

public class Referee {
    private Integer id;
    private Integer Match_id;
    private String name;
    private String surname;
    private Integer age;
    private String nationality;

    public Referee(Integer match_id, String name, String surname, Integer age, String nationality) {
        this(null, match_id, name, surname, age, nationality);
    }
}
