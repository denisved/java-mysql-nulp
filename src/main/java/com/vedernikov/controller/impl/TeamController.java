package com.vedernikov.controller.impl;

import com.vedernikov.model.dao.impl.AbstractGenericDaoImpl;
import com.vedernikov.model.dao.impl.TeamDAO;
import com.vedernikov.model.entities.Team;

public class TeamController extends AbstractGenericControllerImpl<Team> {
    private final TeamDAO teamDao = new TeamDAO();

    @Override
    public AbstractGenericDaoImpl<Team> getDao(){
        return teamDao;
    }
}
