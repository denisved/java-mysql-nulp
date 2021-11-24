package com.vedernikov.service.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.DAO.implementation.MainCoachDAO;
import com.vedernikov.model.MainCoach;
import com.vedernikov.service.Service;
import jdk.jfr.internal.tool.Main;

import java.sql.SQLException;
import java.util.List;

public class MainCoachService implements Service<MainCoach> {
    private final DAO<MainCoach> dao = new MainCoachDAO();

    @Override
    public List<MainCoach> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public MainCoach findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(MainCoach mainCoach) throws SQLException {
        dao.create(mainCoach);
    }

    @Override
    public void update(Integer id, MainCoach mainCoach) throws SQLException {
        dao.update(id, mainCoach);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}