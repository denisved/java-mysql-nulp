package com.vedernikov.controller.impl;

import com.vedernikov.model.dao.impl.AbstractGenericDaoImpl;
import com.vedernikov.model.dao.impl.PlayerDAO;
import com.vedernikov.model.entities.Player;

public class PlayerController extends AbstractGenericControllerImpl<Player> {
    private final PlayerDAO playerDao = new PlayerDAO();

    @Override
    public AbstractGenericDaoImpl<Player> getDao(){
        return playerDao;
    }
}
