package ru.maxvgrad.tutor.service;

import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.dto.SubmissionFormDto;

import java.util.List;
import java.util.Optional;

@Service
public interface SubmissionFormService<T> {

    List<SubmissionFormDto<T>> listAll();

    SubmissionFormDto<T> save(SubmissionFormDto<T> submissionForm);

    void remove(Long id);

    Optional<SubmissionFormDto<T>> get(Long id);

    SubmissionFormDto<T> evaluate(SubmissionFormDto<T> submissionForm);


}
