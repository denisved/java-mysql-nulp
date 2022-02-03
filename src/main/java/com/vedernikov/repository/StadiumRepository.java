package com.vedernikov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedernikov.domain.Stadium;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Integer> {
}
