package com.vedernikov.controller.impl;

import com.vedernikov.model.dao.impl.AbstractGenericDaoImpl;
import com.vedernikov.model.dao.impl.StadiumDAO;
import com.vedernikov.model.entities.Stadium;

public class StadiumController extends AbstractGenericControllerImpl<Stadium> {
    private final StadiumDAO stadiumDao = new StadiumDAO();

    @Override
    public AbstractGenericDaoImpl<Stadium> getDao(){
        return stadiumDao;
    }
}

