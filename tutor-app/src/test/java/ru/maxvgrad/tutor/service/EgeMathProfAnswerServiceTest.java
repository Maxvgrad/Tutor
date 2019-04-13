package ru.maxvgrad.tutor.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import ru.maxvgrad.tutor.form.EgeMathProfForm;
import ru.maxvgrad.tutor.repository.AnswerRepository;
import ru.maxvgrad.tutor.utils.TestEntity;


class EgeMathProfAnswerServiceTest extends SubmissionFormServiceTest<EgeMathProfForm> {

    private static AnswerRepository answerRepository;

    private static SubmissionFormService<EgeMathProfForm> answerService;

    private EgeMathProfForm form;

    @BeforeAll
    static void initClass() {
        answerRepository = mockAnswerRepository();
        answerService = null;//new EgeMathProfFormService(answerRepository, mapper);
    }

    @BeforeEach
    void initInstant() {
        form = TestEntity.buildEgeMathProfForm();
    }

    private static AnswerRepository mockAnswerRepository() {
        answerRepository = Mockito.mock(AnswerRepository.class);
        Mockito.when(answerRepository.getById(VALID_ANSWER_ID)).thenReturn(TestEntity.buildAnswer());
        Mockito.when(answerRepository.getById(INVALID_ANSWER_ID)).thenReturn(null);
        return answerRepository;
    }


    @Override
    SubmissionFormService<EgeMathProfForm> getAnswerService() {
        return answerService;
    }

    @Override
    EgeMathProfForm buildValidForm() {
        return form;
    }

    @Override
    AnswerRepository getAnswerRepository() {
        return answerRepository;
    }
}