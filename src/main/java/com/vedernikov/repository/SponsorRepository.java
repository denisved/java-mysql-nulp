package com.vedernikov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedernikov.domain.Sponsor;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Integer> {
}
