package ru.maxvgrad.tutor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.dto.SubmissionFormDto;
import ru.maxvgrad.tutor.entity.Answer;
import ru.maxvgrad.tutor.entity.mapper.Mapper;
import ru.maxvgrad.tutor.form.EgeMathProfForm;
import ru.maxvgrad.tutor.repository.AnswerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EgeMathProfFormService implements SubmissionFormService<EgeMathProfForm> {

    private final AnswerRepository answerRepository;

    private final Mapper<Answer, SubmissionFormDto<EgeMathProfForm>> mapper;

    @Override
    public List<SubmissionFormDto<EgeMathProfForm>> listAll() {
        return null;
    }

    @Override
    public SubmissionFormDto<EgeMathProfForm> save(SubmissionFormDto<EgeMathProfForm> submissionForm) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Optional<SubmissionFormDto<EgeMathProfForm>> get(Long id) {
        Answer answer = answerRepository.getById(id);
        return Optional.ofNullable(mapper.fromEntity(answer));
    }

    @Override
    public SubmissionFormDto<EgeMathProfForm> evaluate(SubmissionFormDto<EgeMathProfForm> submissionForm) {
        return null;
    }
}
