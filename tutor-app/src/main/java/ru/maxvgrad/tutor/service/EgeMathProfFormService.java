package ru.maxvgrad.tutor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.dto.SubmissionFormDto;
import ru.maxvgrad.tutor.entity.Answer;
import ru.maxvgrad.tutor.entity.ExaminationForm;
import ru.maxvgrad.tutor.form.EgeMathProfForm;
import ru.maxvgrad.tutor.repository.AnswerRepository;
import ru.maxvgrad.tutor.repository.ExaminationFormRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EgeMathProfFormService implements SubmissionFormService<EgeMathProfForm> {

    private final AnswerRepository answerRepository;
    private final ExaminationFormRepository examinationFormRepository;

    @Override
    public List<SubmissionFormDto<EgeMathProfForm>> listAll() {
        return null;
    }

    @Override
    public SubmissionFormDto<EgeMathProfForm> save(SubmissionFormDto<EgeMathProfForm> submissionForm) {
        ExaminationForm examinationForm = examinationFormRepository.getById(1L);
        Answer answer = null;//mapper.fromDto(submissionForm); //TODO
        answer.setExaminationForm(examinationForm);
        answerRepository.save(answer);
        return submissionForm;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Optional<SubmissionFormDto<EgeMathProfForm>> get(Long id) {
        Answer answer = answerRepository.getById(id);
        return Optional.empty(); //TODO
    }

    @Override
    public SubmissionFormDto<EgeMathProfForm> evaluate(SubmissionFormDto<EgeMathProfForm> submissionForm) {
        return null;
    }
}
