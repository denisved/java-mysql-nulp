package com.vedernikov.controller.implementation;

import com.vedernikov.controller.Controller;
import com.vedernikov.model.City;
import com.vedernikov.service.Service;
import com.vedernikov.service.implementation.CityService;

import java.sql.SQLException;
import java.util.List;

public class CityController implements Controller<City>{
    private final Service<City> service = new CityService();

    @Override
    public List<City> findAll() throws  SQLException {
        return service.findAll();
    }

    @Override
    public City findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(City city) throws SQLException {
        service.create(city);
    }

    @Override
    public void update(Integer id, City city) throws SQLException {
        service.update(id, city);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
