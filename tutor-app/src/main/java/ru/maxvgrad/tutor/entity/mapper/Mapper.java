package ru.maxvgrad.tutor.entity.mapper;

public interface Mapper<E, D> {

    D fromEntity(E entity);

    E fromDto(D dto);

    E update(E entity, D dto);
}
