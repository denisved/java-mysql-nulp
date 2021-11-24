package com.vedernikov.service.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.DAO.implementation.SponsorDAO;
import com.vedernikov.model.Sponsor;
import com.vedernikov.service.Service;

import java.sql.SQLException;
import java.util.List;

public class SponsorService implements Service<Sponsor> {
    private final DAO<Sponsor> dao = new SponsorDAO();

    @Override
    public List<Sponsor> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Sponsor findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Sponsor sponsor) throws SQLException {
        dao.create(sponsor);
    }

    @Override
    public void update(Integer id, Sponsor sponsor) throws SQLException {
        dao.update(id, sponsor);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}