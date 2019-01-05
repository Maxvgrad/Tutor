package ru.maxvgrad.tutor.service;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import ru.maxvgrad.tutor.form.EgeMathProfForm;
import ru.maxvgrad.tutor.repository.AnswerRepository;
import ru.maxvgrad.tutor.utils.TestObject;

class EgeMathProfAnswerServiceTest extends SubmissionFormServiceTest<EgeMathProfForm> {

    private static AnswerRepository answerRepository;

    private static SubmissionFormService<EgeMathProfForm> answerService;

    private EgeMathProfForm form;

    @BeforeAll
    static void init() {
        mockAll();
    }

    private static void mockAll() {
        answerRepository = Mockito.mock(AnswerRepository.class);
        Mockito.when(answerRepository.getById(VALID_ANSWER_ID)).thenReturn(TestObject.buildAnswer());
        Mockito.when(answerRepository.getById(INVALID_ANSWER_ID)).thenReturn(null);
        answerService = new EgeMathProfFormService(answerRepository);
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