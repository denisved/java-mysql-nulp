package com.vedernikov.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchHasTeamDTO {
    private Integer id;
    private Integer Match_id;
    private Integer Team_id;
}