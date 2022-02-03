package com.vedernikov.controller.impl;

import com.vedernikov.model.dao.impl.AbstractGenericDaoImpl;
import com.vedernikov.model.dao.impl.MatchDAO;
import com.vedernikov.model.entities.Match;

public class MatchController extends AbstractGenericControllerImpl<Match> {
    private final MatchDAO matchDao = new MatchDAO();

    @Override
    public AbstractGenericDaoImpl<Match> getDao(){
        return matchDao;
    }
}
