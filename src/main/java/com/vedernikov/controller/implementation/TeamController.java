package com.vedernikov.controller.implementation;

import com.vedernikov.controller.Controller;
import com.vedernikov.model.Team;
import com.vedernikov.service.Service;
import com.vedernikov.service.implementation.TeamService;


import java.sql.SQLException;
import java.util.List;

public class TeamController implements Controller<Team>{
    private final Service<Team> service = new TeamService();

    @Override
    public List<Team> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Team findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Team team) throws SQLException {
        service.create(team);
    }

    @Override
    public void update(Integer id, Team team) throws SQLException {
        service.update(id, team);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
