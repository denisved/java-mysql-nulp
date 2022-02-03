package com.vedernikov.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "stadium")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "City_id")
    private Integer cityId;
    @Column(name = "name")
    private String name;
    @Column(name = "capacity")
    private Integer capacity;

    public Stadium(Integer id, Integer cityId, String name, Integer capacity) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Stadium{" +
                "id=" + id +
                ", cityId=" + cityId +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
