package ru.maxvgrad.tutor.service;

import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.entity.ExaminationAssessment;

import java.util.List;
import java.util.Optional;

@Service
public interface ExaminationAssessmentService<T> {

    List<ExaminationAssessment<T>> listAll();

    ExaminationAssessment<T> save(T submittingAnswersForm);

    void remove(Long id);

    Optional<ExaminationAssessment<T>> get(Long id);

    ExaminationAssessment<T> evaluate(T submittingAnswersForm);


}
