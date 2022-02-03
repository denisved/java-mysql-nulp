package com.vedernikov.mapper;

public interface AbstractMapper<Entity, DTO> {
    DTO map(Entity entity);
}
