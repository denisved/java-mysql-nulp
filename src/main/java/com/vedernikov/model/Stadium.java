package com.vedernikov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@ToString
@AllArgsConstructor
@Getter
@Setter

public class Stadium {
    private Integer id;
    private Integer City_id;
    private String name;
    private Integer capcity;

    public Stadium (Integer city_id, String name, Integer capacity) {
        this(null, city_id, name, capacity);
    }
}
