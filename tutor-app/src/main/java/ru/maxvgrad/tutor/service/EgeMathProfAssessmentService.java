package ru.maxvgrad.tutor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.dto.EgeMathProfFormDto;
import ru.maxvgrad.tutor.entity.ExaminationAssessment;
import ru.maxvgrad.tutor.repository.ExaminationAssessmentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EgeMathProfAssessmentService implements ExaminationAssessmentService<EgeMathProfFormDto> {

    @Autowired
    private final ExaminationAssessmentRepository<EgeMathProfFormDto> examinationAssessmentRepository;

    @Override
    public List<ExaminationAssessment<EgeMathProfFormDto>> listAll() {
        return examinationAssessmentRepository.findAll();
    }

    @Override
    public ExaminationAssessment<EgeMathProfFormDto> save(
            EgeMathProfFormDto submittingAnswersForm) {
        return null;
    }

    @Override
    public void remove(Long id) {
        examinationAssessmentRepository.deleteById(id);
    }

    @Override
    public Optional<ExaminationAssessment<EgeMathProfFormDto>> get(Long id) {
        return examinationAssessmentRepository.findById(id);
    }

    @Override
    public ExaminationAssessment<EgeMathProfFormDto> evaluate(
            EgeMathProfFormDto submittingAnswersForm) {
        return null;
    }
}
