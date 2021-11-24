package com.vedernikov.controller.implementation;

import com.vedernikov.controller.Controller;
import com.vedernikov.model.Referee;
import com.vedernikov.service.Service;
import com.vedernikov.service.implementation.RefereeService;

import java.sql.SQLException;
import java.util.List;

public class RefereeController implements Controller<Referee>{
    private final Service<Referee> service = new RefereeService();

    @Override
    public List<Referee> findAll() throws  SQLException {
        return service.findAll();
    }

    @Override
    public Referee findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Referee referee) throws SQLException {
        service.create(referee);
    }

    @Override
    public void update(Integer id, Referee referee) throws SQLException {
        service.update(id, referee);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}