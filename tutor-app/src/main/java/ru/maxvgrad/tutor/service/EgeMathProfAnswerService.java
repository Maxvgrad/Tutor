package ru.maxvgrad.tutor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.dto.EgeMathProfFormDto;
import ru.maxvgrad.tutor.entity.Answer;
import ru.maxvgrad.tutor.repository.AnswerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EgeMathProfAnswerService implements AnswerService<EgeMathProfFormDto> {

    private final AnswerRepository answerRepository;

    @Override
    public List<EgeMathProfFormDto> listAll() {

        return null;
    }

    @Override
    public EgeMathProfFormDto save(EgeMathProfFormDto submissionForm) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Optional<EgeMathProfFormDto> get(Long id) {
        return Optional.empty();
    }

    @Override
    public Answer evaluate(EgeMathProfFormDto submissionForm) {
        return null;
    }
}
