package ru.maxvgrad.tutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityBaseRepository<T> extends JpaRepository<T, Long> {
    T getById(Long id);
}
