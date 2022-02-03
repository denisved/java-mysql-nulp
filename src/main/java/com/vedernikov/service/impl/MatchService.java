package com.vedernikov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.vedernikov.domain.Match;
import com.vedernikov.repository.MatchRepository;
import com.vedernikov.service.AbstractService;

@AllArgsConstructor
@Service
public class MatchService extends AbstractService<Match> {
    private final MatchRepository matchRepository;

    @Override
    public JpaRepository<Match, Integer> getRepository(){
        return matchRepository;
    }
}
