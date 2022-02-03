package com.vedernikov.mapper.impl;

import org.springframework.stereotype.Component;
import com.vedernikov.DTO.SponsorDTO;
import com.vedernikov.domain.Sponsor;
import com.vedernikov.mapper.AbstractMapper;

@Component
public class SponsorMapper implements AbstractMapper<Sponsor, SponsorDTO> {
    @Override
    public SponsorDTO map(Sponsor sponsor){
        return SponsorDTO.builder()
                .id(sponsor.getId())
                .name(sponsor.getName())
                .start_of_contract(sponsor.getStartOfContract())
                .end_of_contract(sponsor.getEndOfContract())
                .build();
    }
}