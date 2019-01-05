package ru.maxvgrad.tutor.service;

import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.dto.SubmissionForm;
import ru.maxvgrad.tutor.entity.Answer;

import java.util.List;
import java.util.Optional;

@Service
public interface AnswerService<T extends SubmissionForm> {

    List<T> listAll();

    T save(T submissionForm);

    void remove(Long id);

    Optional<T> get(Long id);

    Answer evaluate(T submissionForm);


}
