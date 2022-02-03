package com.vedernikov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedernikov.domain.TeamHasSponsor;

@Repository
public interface TeamHasSponsorRepository extends JpaRepository<TeamHasSponsor, Integer> {
}
