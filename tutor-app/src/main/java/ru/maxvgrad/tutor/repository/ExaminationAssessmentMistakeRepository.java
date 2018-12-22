package ru.maxvgrad.tutor.repository;

import org.springframework.stereotype.Repository;
import ru.maxvgrad.tutor.entity.ExaminationAssessmentMistake;

@Repository
public interface ExaminationAssessmentMistakeRepository<T> extends EntityBaseRepository<ExaminationAssessmentMistake<T>> {
}
