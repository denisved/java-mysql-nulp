package com.vedernikov.service.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.DAO.implementation.MatchHasTeamDAO;
import com.vedernikov.model.MatchHasTeam;
import com.vedernikov.service.Service;

import java.sql.SQLException;
import java.util.List;

public class MatchHasTeamService implements Service<MatchHasTeam> {
    private final DAO<MatchHasTeam> dao = new MatchHasTeamDAO();

    @Override
    public List<MatchHasTeam> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public MatchHasTeam findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(MatchHasTeam matchHasTeam) throws SQLException {
        dao.create(matchHasTeam);
    }

    @Override
    public void update(Integer id, MatchHasTeam matchHasTeam) throws SQLException {
        dao.update(id, matchHasTeam);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}