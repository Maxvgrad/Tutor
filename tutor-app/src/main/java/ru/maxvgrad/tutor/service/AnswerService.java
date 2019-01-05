package ru.maxvgrad.tutor.service;

import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.entity.Answer;

import java.util.List;
import java.util.Optional;

@Service
public interface AnswerService<T> {

    List<Answer> listAll();

    Answer save(T submittingAnswersForm);

    void remove(Long id);

    Optional<Answer> get(Long id);

    Answer evaluate(T submittingAnswersForm);


}
