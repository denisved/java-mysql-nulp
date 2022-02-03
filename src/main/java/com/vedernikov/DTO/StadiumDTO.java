package com.vedernikov.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StadiumDTO {
    private Integer id;
    private Integer City_id;
    private String name;
    private Integer capacity;
}