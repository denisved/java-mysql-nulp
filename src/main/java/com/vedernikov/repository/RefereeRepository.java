package com.vedernikov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedernikov.domain.Referee;

@Repository
public interface RefereeRepository extends JpaRepository<Referee, Integer> {
}
