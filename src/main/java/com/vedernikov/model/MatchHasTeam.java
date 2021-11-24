package com.vedernikov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@ToString
@AllArgsConstructor
@Getter
@Setter

public class MatchHasTeam {
    private Integer id;
    private Integer Match_id;
    private Integer Team_id;

    public MatchHasTeam(Integer match_id, Integer team_id){
        this(null, match_id, team_id);
    }
}
