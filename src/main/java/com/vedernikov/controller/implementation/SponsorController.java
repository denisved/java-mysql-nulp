package com.vedernikov.controller.implementation;

import com.vedernikov.controller.Controller;
import com.vedernikov.model.Sponsor;
import com.vedernikov.service.Service;
import com.vedernikov.service.implementation.SponsorService;

import java.sql.SQLException;
import java.util.List;

public class SponsorController implements Controller<Sponsor>{
    private final Service<Sponsor> service = new SponsorService();

    @Override
    public List<Sponsor> findAll() throws  SQLException {
        return service.findAll();
    }

    @Override
    public Sponsor findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Sponsor sponsor) throws SQLException {
        service.create(sponsor);
    }

    @Override
    public void update(Integer id, Sponsor sponsor) throws SQLException {
        service.update(id, sponsor);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}