package com.vedernikov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.vedernikov.domain.Player;
import com.vedernikov.repository.PlayerRepository;
import com.vedernikov.service.AbstractService;

@AllArgsConstructor
@Service
public class PlayerService extends AbstractService<Player> {
    private final PlayerRepository playerRepository;

    @Override
    public JpaRepository<Player, Integer> getRepository(){
        return playerRepository;
    }
}
