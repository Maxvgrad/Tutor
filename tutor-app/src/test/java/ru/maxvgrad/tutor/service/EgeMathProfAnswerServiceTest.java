package ru.maxvgrad.tutor.service;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import ru.maxvgrad.tutor.dto.EgeMathProfFormDto;
import ru.maxvgrad.tutor.repository.AnswerRepository;
import ru.maxvgrad.tutor.utils.TestObject;

class EgeMathProfAnswerServiceTest extends AnswerServiceTest<EgeMathProfFormDto> {

    private static AnswerRepository answerRepository;

    private static AnswerService<EgeMathProfFormDto> answerService;

    private EgeMathProfFormDto form;

    @BeforeAll
    static void init() {
        mockAll();
    }

    private static void mockAll() {
        answerRepository = Mockito.mock(AnswerRepository.class);
        Mockito.when(answerRepository.getById(VALID_ANSWER_ID)).thenReturn(TestObject.buildAnswer());
        Mockito.when(answerRepository.getById(INVALID_ANSWER_ID)).thenReturn(null);
        answerService = new EgeMathProfAnswerService(answerRepository);
    }


    @Override
    AnswerService<EgeMathProfFormDto> getAnswerService() {
        return answerService;
    }

    @Override
    EgeMathProfFormDto buildValidForm() {
        return form;
    }

    @Override
    AnswerRepository getAnswerRepository() {
        return answerRepository;
    }
}