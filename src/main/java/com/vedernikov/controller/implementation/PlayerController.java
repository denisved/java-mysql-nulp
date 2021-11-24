package com.vedernikov.controller.implementation;

import com.vedernikov.controller.Controller;
import com.vedernikov.model.Player;
import com.vedernikov.service.Service;
import com.vedernikov.service.implementation.PlayerService;

import java.sql.SQLException;
import java.util.List;

public class PlayerController implements Controller<Player>{
    private final Service<Player> service = new PlayerService();

    @Override
    public List<Player> findAll() throws  SQLException {
        return service.findAll();
    }

    @Override
    public Player findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Player player) throws SQLException {
        service.create(player);
    }

    @Override
    public void update(Integer id, Player player) throws SQLException {
        service.update(id, player);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}