package com.vedernikov.service.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.DAO.implementation.MatchDAO;
import com.vedernikov.model.Match;
import com.vedernikov.service.Service;

import java.sql.SQLException;
import java.util.List;

public class MatchService implements Service<Match> {
    private final DAO<Match> dao = new MatchDAO();

    @Override
    public List<Match> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Match findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Match match) throws SQLException {
        dao.create(match);
    }

    @Override
    public void update(Integer id, Match match) throws SQLException {
        dao.update(id, match);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}