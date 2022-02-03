package com.vedernikov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedernikov.domain.MatchHasTeam;

@Repository
public interface MatchHasTeamRepository extends JpaRepository<MatchHasTeam, Integer> {
}
