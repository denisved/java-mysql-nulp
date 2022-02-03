package com.vedernikov.controller.impl;

import com.vedernikov.model.dao.impl.AbstractGenericDaoImpl;
import com.vedernikov.model.dao.impl.MatchHasTeamDAO;
import com.vedernikov.model.entities.MatchHasTeam;

public class MatchHasTeamController extends AbstractGenericControllerImpl<MatchHasTeam> {
    private final MatchHasTeamDAO matchHasTeamDAO = new MatchHasTeamDAO();

    @Override
    public AbstractGenericDaoImpl<MatchHasTeam> getDao(){
        return matchHasTeamDAO;
    }
}
