package ru.maxvgrad.tutor.repository;

import org.springframework.stereotype.Repository;
import ru.maxvgrad.tutor.entity.ExaminationAssessment;

@Repository
public interface ExaminationAssessmentRepository<T> extends EntityBaseRepository<ExaminationAssessment<T>> {

}
