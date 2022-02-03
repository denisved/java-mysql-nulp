package com.vedernikov.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractService<Entity> {
    public abstract JpaRepository<Entity, Integer> getRepository();

    public List<Entity> getAll() {
        return getRepository().findAll();
    }

    public Entity get(Integer id) {
        return getRepository().getOne(id);
    }

    public Entity create(Entity entity) {
        return getRepository().save(entity);
    }

    public Entity update(Integer id, Entity entity) {
        if (getRepository().findById(id).isPresent()) {
            return getRepository().save(entity);
        }

        return null;
    }

    public Entity delete(Integer id) {
        Entity entityToDelete = null;
        if (getRepository().findById(id).isPresent()) {
            entityToDelete = getRepository().getOne(id);
            getRepository().deleteById(id);
        }

        return entityToDelete;
    }
}