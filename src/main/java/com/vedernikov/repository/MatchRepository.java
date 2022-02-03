package com.vedernikov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedernikov.domain.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
}
