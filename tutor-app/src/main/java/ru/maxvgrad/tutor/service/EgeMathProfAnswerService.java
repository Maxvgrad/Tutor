package ru.maxvgrad.tutor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.dto.EgeMathProfFormDto;
import ru.maxvgrad.tutor.entity.Answer;
import ru.maxvgrad.tutor.repository.AnswerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EgeMathProfAnswerService implements AnswerService<EgeMathProfFormDto> {

    @Autowired
    private final AnswerRepository<EgeMathProfFormDto> answerRepository;

    @Override
    public List<Answer<EgeMathProfFormDto>> listAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answer<EgeMathProfFormDto> save(EgeMathProfFormDto submittingAnswersForm) {
        //todo
        return null;
    }

    @Override
    public void remove(Long id) {
        answerRepository.deleteById(id);
    }

    @Override
    public Optional<Answer<EgeMathProfFormDto>> get(Long id) {
        return Optional.ofNullable(answerRepository.getById(id));
    }

    @Override
    public Answer<EgeMathProfFormDto> evaluate(EgeMathProfFormDto submittingAnswersForm) {
        //todo

        return null;
    }
}
