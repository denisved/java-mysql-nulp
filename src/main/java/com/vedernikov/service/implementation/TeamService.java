package com.vedernikov.service.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.DAO.implementation.TeamDAO;
import com.vedernikov.model.Team;
import com.vedernikov.service.Service;

import java.sql.SQLException;
import java.util.List;

public class TeamService implements Service<Team> {
    private final DAO<Team> dao = new TeamDAO();

    @Override
    public List<Team> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Team findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Team team) throws SQLException {
        dao.create(team);
    }

    @Override
    public void update(Integer id, Team team) throws SQLException {
        dao.update(id, team);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
