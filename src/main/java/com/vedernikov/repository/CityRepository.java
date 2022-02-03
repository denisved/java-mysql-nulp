package com.vedernikov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedernikov.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
