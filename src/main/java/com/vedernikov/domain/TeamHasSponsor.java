package com.vedernikov.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "team_has_sponsor")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class TeamHasSponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Team_id")
    private Integer teamId;
    @Column(name = "Sponsor_id")
    private Integer sponsorId;

    public TeamHasSponsor(Integer id, Integer teamId, Integer sponsorId) {
        this.id = id;
        this.teamId = teamId;
        this.sponsorId = sponsorId;
    }

    @Override
    public String toString() {
        return "TeamHasSponsor{" +
                "id=" + id +
                ", teamId=" + teamId +
                ", sponsorId=" + sponsorId +
                '}';
    }
}
