package com.vedernikov.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "match_has_team")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class MatchHasTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Match_id")
    private Integer matchId;
    @Column(name = "Team_id")
    private Integer teamId;

    public MatchHasTeam(Integer id, Integer matchId, Integer teamId) {
        this.id = id;
        this.matchId = matchId;
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "MatchHasTeam{" +
                "id=" + id +
                ", matchId=" + matchId +
                ", teamId=" + teamId +
                '}';
    }
}
