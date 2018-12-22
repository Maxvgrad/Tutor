package ru.maxvgrad.tutor.repository;

import org.springframework.stereotype.Repository;
import ru.maxvgrad.tutor.entity.BaseJsonEntity;
import ru.maxvgrad.tutor.entity.ExaminationAssessmentAnswer;

@Repository
public interface ExaminationAssessmentAnswerRepository<T extends BaseJsonEntity>
        extends EntityBaseRepository<ExaminationAssessmentAnswer<T>> {
}
