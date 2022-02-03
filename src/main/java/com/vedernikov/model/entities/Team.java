package com.vedernikov.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "team")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Main_Coach_id")
    private Integer mainCoachId;
    @Column(name = "name")
    private String name;
    @Column(name = "UPL_position")
    private Integer uplPositon;
    @Column(name = "number_of_wins")
    private Integer numberOfWins;
    @Column(name = "number_of_loses")
    private Integer numberOfLoses;
    @Column(name = "number_of_draws")
    private Integer numberOfDraws;
    @Column(name = "number_of_points")
    private Integer numberOfPoints;

    public Team(Integer id, Integer mainCoachId, String name, Integer uplPositon, Integer numberOfWins,
                Integer numberOfLoses, Integer numberOfDraws, Integer numberOfPoints) {
        this.id = id;
        this.mainCoachId = mainCoachId;
        this.name = name;
        this.uplPositon = uplPositon;
        this.numberOfWins = numberOfWins;
        this.numberOfLoses = numberOfLoses;
        this.numberOfDraws = numberOfDraws;
        this.numberOfPoints = numberOfPoints;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", mainCoachId=" + mainCoachId +
                ", name='" + name + '\'' +
                ", uplPositon=" + uplPositon +
                ", numberOfWins=" + numberOfWins +
                ", numberOfLoses=" + numberOfLoses +
                ", numberOfDraws=" + numberOfDraws +
                ", numberOfPoints=" + numberOfPoints +
                '}';
    }
}
