package com.vedernikov.controller.impl;

import com.vedernikov.model.dao.impl.AbstractGenericDaoImpl;
import com.vedernikov.model.dao.impl.TeamHasSponsorDAO;
import com.vedernikov.model.entities.TeamHasSponsor;

public class TeamHasSponsorController extends AbstractGenericControllerImpl<TeamHasSponsor> {
    private final TeamHasSponsorDAO teamHasSponsorDao = new TeamHasSponsorDAO();

    @Override
    public AbstractGenericDaoImpl<TeamHasSponsor> getDao(){
        return teamHasSponsorDao;
    }
}

