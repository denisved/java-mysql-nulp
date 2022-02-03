package com.vedernikov.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "player")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Team_id")
    private Integer teamId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private Integer age;
    @Column(name = "position")
    private String position;
    @Column(name = "salary_for_season_in_euros")
    private Integer salary;
    @Column(name = "start_of_contract")
    private String startOfContract;
    @Column(name = "end_of_contract")
    private String endOfContract;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "goals")
    private Integer goals;
    @Column(name = "assists")
    private Integer assists;

    public Player(Integer id, Integer teamId, String name, String surname, Integer age, String position, Integer salary,
                  String startOfContract, String endOfContract, String nationality, Integer goals, Integer assists) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.startOfContract = startOfContract;
        this.endOfContract = endOfContract;
        this.nationality = nationality;
        this.goals = goals;
        this.assists = assists;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", teamId=" + teamId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", startOfContract='" + startOfContract + '\'' +
                ", endOfContract='" + endOfContract + '\'' +
                ", nationality='" + nationality + '\'' +
                ", goals=" + goals +
                ", assists=" + assists +
                '}';
    }
}
