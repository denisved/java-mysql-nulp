package com.vedernikov.controller;

import com.vedernikov.model.dao.impl.AbstractGenericDaoImpl;

import java.util.List;

public interface AbstractGenericController<E> {

    AbstractGenericDaoImpl<E> getDao();

    List<E> findAll();

    E findById(Integer id);

    void create(E entity);

    void update(Integer id, E entity);

    void delete(Integer id);
}