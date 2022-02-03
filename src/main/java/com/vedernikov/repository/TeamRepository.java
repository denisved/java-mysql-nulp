package com.vedernikov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedernikov.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
