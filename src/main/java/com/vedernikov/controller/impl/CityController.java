package com.vedernikov.controller.impl;

import com.vedernikov.model.dao.impl.AbstractGenericDaoImpl;
import com.vedernikov.model.dao.impl.CityDAO;
import com.vedernikov.model.entities.City;

public class CityController extends AbstractGenericControllerImpl<City> {
    private final CityDAO cityDao = new CityDAO();

    @Override
    public AbstractGenericDaoImpl<City> getDao(){
        return cityDao;
    }
}