package com.vedernikov.controller.impl;

import com.vedernikov.model.dao.impl.AbstractGenericDaoImpl;
import com.vedernikov.model.dao.impl.SponsorDAO;
import com.vedernikov.model.entities.Sponsor;

public class SponsorController extends AbstractGenericControllerImpl<Sponsor> {
    private final SponsorDAO sponsorDao = new SponsorDAO();

    @Override
    public AbstractGenericDaoImpl<Sponsor> getDao(){
        return sponsorDao;
    }
}

