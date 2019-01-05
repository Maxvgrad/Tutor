package ru.maxvgrad.tutor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.dto.SubmissionFormDto;
import ru.maxvgrad.tutor.form.EgeMathProfForm;
import ru.maxvgrad.tutor.repository.AnswerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EgeMathProfFormService implements SubmissionFormService<EgeMathProfForm> {

    private final AnswerRepository answerRepository;

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
        return Optional.empty();
    }

    @Override
    public SubmissionFormDto<EgeMathProfForm> evaluate(SubmissionFormDto<EgeMathProfForm> submissionForm) {
        return null;
    }
}
