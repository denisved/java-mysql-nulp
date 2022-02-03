package com.vedernikov.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDTO {
    private Integer id;
    private Integer Main_Coach_id;
    private String name;
    private Integer UPL_position;
    private Integer number_of_wins;
    private Integer number_of_loses;
    private Integer number_of_draws;
    private Integer number_of_points;
}