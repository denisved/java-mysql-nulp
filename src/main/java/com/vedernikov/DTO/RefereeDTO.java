package com.vedernikov.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefereeDTO {
    private Integer id;
    private Integer Match_id;
    private String name;
    private String surname;
    private Integer age;
    private String nationality;
}
