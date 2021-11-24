package com.vedernikov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@ToString
@AllArgsConstructor
@Getter
@Setter

public class City {
    private Integer id;
    private String name;

    public City(String name) {
        this(null, name);
    }


}
