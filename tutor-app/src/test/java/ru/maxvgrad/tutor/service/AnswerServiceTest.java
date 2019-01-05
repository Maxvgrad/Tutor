package ru.maxvgrad.tutor.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.maxvgrad.tutor.dto.SubmissionForm;
import ru.maxvgrad.tutor.repository.AnswerRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
abstract class AnswerServiceTest<T extends SubmissionForm> {

    static final Long VALID_ANSWER_ID = 1L;
    static final Long INVALID_ANSWER_ID = -1L;

    private T form;

    @Test
    void listAll() {

    }

    @Test
    void save() {
    }

    @Test
    void remove() {
    }

    @Test
    void getSuccessTest() {
        form = getAnswerService().get(VALID_ANSWER_ID).orElseThrow(IllegalArgumentException::new);
        thenAssert();
    }

    @Test
    void getNotFoundTest() {
        assertFalse(getAnswerService().get(INVALID_ANSWER_ID).isPresent());
    }

    @Test
    void evaluate() {
    }

    abstract AnswerService<T> getAnswerService();

    abstract T buildValidForm();

    abstract AnswerRepository getAnswerRepository();

    void thenAssert() {
        assertNotNull(form);
        assertNotNull(form.getId());
        assertNotNull(form.getExaminationFormId());
    }
}