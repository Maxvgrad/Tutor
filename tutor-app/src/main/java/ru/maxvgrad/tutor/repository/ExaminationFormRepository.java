package ru.maxvgrad.tutor.repository;

import org.springframework.stereotype.Repository;
import ru.maxvgrad.tutor.entity.ExaminationForm;

@Repository
public interface ExaminationFormRepository<T> extends EntityBaseRepository<ExaminationForm<T>> {
}
