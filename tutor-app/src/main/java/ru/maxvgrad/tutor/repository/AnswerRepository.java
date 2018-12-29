package ru.maxvgrad.tutor.repository;

import org.springframework.stereotype.Repository;
import ru.maxvgrad.tutor.entity.Answer;

@Repository
public interface AnswerRepository<T> extends EntityBaseRepository<Answer<T>> {
}
