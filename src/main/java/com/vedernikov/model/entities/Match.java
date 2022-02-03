package com.vedernikov.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "match")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Stadium_id")
    private Integer stadiumId;
    @Column(name = "winner")
    private String winner;
    @Column(name = "loser")
    private String loser;
    @Column(name = "draw")
    private Integer draw;
    @Column(name = "final_score")
    private String finalScore;
    @Column(name = "goals_total")
    private Integer goalsTotal;
    @Column(name = "red_cards")
    private Integer redCards;
    @Column(name = "yellow_cards")
    private Integer yellowCards;
    @Column(name = "number_of_replacements")
    private Integer numberOfReplacements;
    @Column(name = "number_of_fouls")
    private Integer numberOfFouls;
    @Column(name = "number_of_offsides")
    private Integer numberOfOffsides;
    @Column(name = "number_of_corners")
    private Integer numberOfCorners;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;

    public Match(Integer id, Integer stadiumId, String winner, String loser, Integer draw, String finalScore,
                 Integer goalsTotal, Integer redCards, Integer yellowCards, Integer numberOfReplacements,
                 Integer numberOfFouls, Integer numberOfOffsides, Integer numberOfCorners, String startTime,
                 String endTime) {
        this.id = id;
        this.stadiumId = stadiumId;
        this.winner = winner;
        this.loser = loser;
        this.draw = draw;
        this.finalScore = finalScore;
        this.goalsTotal = goalsTotal;
        this.redCards = redCards;
        this.yellowCards = yellowCards;
        this.numberOfReplacements = numberOfReplacements;
        this.numberOfFouls = numberOfFouls;
        this.numberOfOffsides = numberOfOffsides;
        this.numberOfCorners = numberOfCorners;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", stadiumId=" + stadiumId +
                ", winner='" + winner + '\'' +
                ", loser='" + loser + '\'' +
                ", draw=" + draw +
                ", finalScore='" + finalScore + '\'' +
                ", goalsTotal=" + goalsTotal +
                ", redCards=" + redCards +
                ", yellowCards=" + yellowCards +
                ", numberOfReplacements=" + numberOfReplacements +
                ", numberOfFouls=" + numberOfFouls +
                ", numberOfOffsides=" + numberOfOffsides +
                ", numberOfCorners=" + numberOfCorners +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
