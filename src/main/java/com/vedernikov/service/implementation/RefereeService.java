package com.vedernikov.service.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.DAO.implementation.RefereeDAO;
import com.vedernikov.model.Referee;
import com.vedernikov.service.Service;

import java.sql.SQLException;
import java.util.List;

public class RefereeService implements Service<Referee> {
    private final DAO<Referee> dao = new RefereeDAO();

    @Override
    public List<Referee> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Referee findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Referee referee) throws SQLException {
        dao.create(referee);
    }

    @Override
    public void update(Integer id, Referee referee) throws SQLException {
        dao.update(id, referee);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}