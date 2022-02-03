package com.vedernikov.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDTO {
    private Integer id;
    private Integer Team_id;
    private String name;
    private String surname;
    private Integer age;
    private String position;
    private Integer salary_for_season_in_euros;
    private String start_of_contract;
    private String end_of_contract;
    private String nationality;
    private Integer goals;
    private Integer assists;
}
