package com.vedernikov.controller.implementation;

import com.vedernikov.controller.Controller;
import com.vedernikov.model.MatchHasTeam;
import com.vedernikov.service.Service;
import com.vedernikov.service.implementation.MatchHasTeamService;

import java.sql.SQLException;
import java.util.List;

public class MatchHasTeamController implements Controller<MatchHasTeam>{
    private final Service<MatchHasTeam> service = new MatchHasTeamService();

    @Override
    public List<MatchHasTeam> findAll() throws  SQLException {
        return service.findAll();
    }

    @Override
    public MatchHasTeam findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(MatchHasTeam matchHasTeam) throws SQLException {
        service.create(matchHasTeam);
    }

    @Override
    public void update(Integer id, MatchHasTeam matchHasTeam) throws SQLException {
        service.update(id, matchHasTeam);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
