package com.vedernikov.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SponsorDTO {
    private Integer id;
    private String name;
    private String start_of_contract;
    private String end_of_contract;
}