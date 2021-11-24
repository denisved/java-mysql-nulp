package com.vedernikov.service.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.DAO.implementation.PlayerDAO;
import com.vedernikov.model.Player;
import com.vedernikov.service.Service;

import java.sql.SQLException;
import java.util.List;

public class PlayerService implements Service<Player> {
    private final DAO<Player> dao = new PlayerDAO();

    @Override
    public List<Player> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Player findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Player player) throws SQLException {
        dao.create(player);
    }

    @Override
    public void update(Integer id, Player player) throws SQLException {
        dao.update(id, player);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
