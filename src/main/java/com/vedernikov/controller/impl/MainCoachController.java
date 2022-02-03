package com.vedernikov.controller.impl;

import com.vedernikov.model.dao.impl.AbstractGenericDaoImpl;
import com.vedernikov.model.dao.impl.MainCoachDAO;
import com.vedernikov.model.entities.MainCoach;

public class MainCoachController extends AbstractGenericControllerImpl<MainCoach> {
    private final MainCoachDAO mainCoachDao = new MainCoachDAO();

    @Override
    public AbstractGenericDaoImpl<MainCoach> getDao(){
        return mainCoachDao;
    }
}