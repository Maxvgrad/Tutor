package ru.maxvgrad.tutor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.dto.EgeMathProfFormDto;
import ru.maxvgrad.tutor.entity.Answer;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EgeMathProfAnswerService implements AnswerService<EgeMathProfFormDto> {

//    private final AnswerRepository<EgeMathProfFormDto> answerRepository;

    @Override
    public List<Answer> listAll() {
        return null;
    }

    @Override
    public Answer save(EgeMathProfFormDto submittingAnswersForm) {
        //todo
        return null;
    }

    @Override
    public void remove(Long id) {

//        answerRepository.deleteById(id);
    }

    @Override
    public Optional<Answer> get(Long id) {
        return null;//Optional.ofNullable(answerRepository.getById(id));
    }

    @Override
    public Answer evaluate(EgeMathProfFormDto submittingAnswersForm) {
        //todo

        return null;
    }
}
