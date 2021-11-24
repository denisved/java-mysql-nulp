package com.vedernikov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@ToString
@AllArgsConstructor
@Getter
@Setter

public class Sponsor {
    private Integer id;
    private String name;
    private String start_of_contract;
    private String end_of_contract;

    public Sponsor(String name, String start_of_contract, String end_of_contract){
        this(null, name, start_of_contract, end_of_contract);
    }
}
