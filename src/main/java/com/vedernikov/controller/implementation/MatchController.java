package com.vedernikov.controller.implementation;

import com.vedernikov.controller.Controller;
import com.vedernikov.model.Match;
import com.vedernikov.service.Service;
import com.vedernikov.service.implementation.MatchService;

import java.sql.SQLException;
import java.util.List;

public class MatchController implements Controller<Match>{
    private final Service<Match> service = new MatchService();

    @Override
    public List<Match> findAll() throws  SQLException {
        return service.findAll();
    }

    @Override
    public Match findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Match match) throws SQLException {
        service.create(match);
    }

    @Override
    public void update(Integer id, Match match) throws SQLException {
        service.update(id, match);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}