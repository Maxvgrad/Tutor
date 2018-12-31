package ru.maxvgrad.tutor.service;

import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.entity.Answer;

import java.util.List;
import java.util.Optional;

@Service
public interface AnswerService<T> {

    List<Answer<T>> listAll();

    Answer<T> save(T submittingAnswersForm);

    void remove(Long id);

    Optional<Answer<T>> get(Long id);

    Answer<T> evaluate(T submittingAnswersForm);


}
