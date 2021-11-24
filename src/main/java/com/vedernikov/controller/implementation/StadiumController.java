package com.vedernikov.controller.implementation;

import com.vedernikov.controller.Controller;
import com.vedernikov.model.Stadium;
import com.vedernikov.service.Service;
import com.vedernikov.service.implementation.StadiumService;


import java.sql.SQLException;
import java.util.List;

public class StadiumController implements Controller<Stadium>{
    private final Service<Stadium> service = new StadiumService();

    @Override
    public List<Stadium> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Stadium findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Stadium stadium) throws SQLException {
        service.create(stadium);
    }

    @Override
    public void update(Integer id, Stadium stadium) throws SQLException {
        service.update(id, stadium);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}

