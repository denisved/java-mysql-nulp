package com.vedernikov.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MainCoachDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private Integer salary_for_season_in_euros;
    private String start_of_contract;
    private String end_of_contract;
    private String nationality;
}
