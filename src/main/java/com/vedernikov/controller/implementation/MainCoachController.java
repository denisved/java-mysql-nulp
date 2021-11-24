package com.vedernikov.controller.implementation;

import com.vedernikov.controller.Controller;
import com.vedernikov.model.MainCoach;
import com.vedernikov.service.Service;
import com.vedernikov.service.implementation.MainCoachService;

import java.sql.SQLException;
import java.util.List;

public class MainCoachController implements Controller<MainCoach>{
    private final Service<MainCoach> service = new MainCoachService();

    @Override
    public List<MainCoach> findAll() throws  SQLException {
        return service.findAll();
    }

    @Override
    public MainCoach findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(MainCoach mainCoach) throws SQLException {
        service.create(mainCoach);
    }

    @Override
    public void update(Integer id, MainCoach mainCoach) throws SQLException {
        service.update(id, mainCoach);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}