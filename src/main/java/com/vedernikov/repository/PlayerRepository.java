package com.vedernikov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedernikov.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
