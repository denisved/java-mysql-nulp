package com.vedernikov.service.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.DAO.implementation.CityDAO;
import com.vedernikov.model.City;
import com.vedernikov.service.Service;

import java.sql.SQLException;
import java.util.List;

public class CityService implements Service<City> {
    private final DAO<City> dao = new CityDAO();

    @Override
    public List<City> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public City findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(City city) throws SQLException {
        dao.create(city);
    }

    @Override
    public void update(Integer id, City city) throws SQLException {
        dao.update(id, city);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
