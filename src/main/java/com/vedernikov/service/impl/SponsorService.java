package com.vedernikov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.vedernikov.domain.Sponsor;
import com.vedernikov.repository.SponsorRepository;
import com.vedernikov.service.AbstractService;

@AllArgsConstructor
@Service
public class SponsorService extends AbstractService<Sponsor> {
    private final SponsorRepository sponsorRepository;

    @Override
    public JpaRepository<Sponsor, Integer> getRepository(){
        return sponsorRepository;
    }
}