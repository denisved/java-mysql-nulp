package com.vedernikov.controller.impl;

import com.vedernikov.model.dao.impl.AbstractGenericDaoImpl;
import com.vedernikov.model.dao.impl.RefereeDAO;
import com.vedernikov.model.entities.Referee;

public class RefereeController extends AbstractGenericControllerImpl<Referee> {
    private final RefereeDAO refereeDao = new RefereeDAO();

    @Override
    public AbstractGenericDaoImpl<Referee> getDao(){
        return refereeDao;
    }
}
