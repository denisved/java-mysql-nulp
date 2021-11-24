package com.vedernikov.service.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.DAO.implementation.StadiumDAO;
import com.vedernikov.model.Stadium;
import com.vedernikov.service.Service;

import java.sql.SQLException;
import java.util.List;

public class StadiumService implements Service<Stadium> {
    private final DAO<Stadium> dao = new StadiumDAO();

    @Override
    public List<Stadium> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Stadium findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Stadium stadium) throws SQLException {
        dao.create(stadium);
    }

    @Override
    public void update(Integer id, Stadium stadium) throws SQLException {
        dao.update(id, stadium);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}