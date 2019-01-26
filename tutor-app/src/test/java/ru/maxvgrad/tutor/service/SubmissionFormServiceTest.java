package ru.maxvgrad.tutor.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.maxvgrad.tutor.dto.SubmissionFormDto;
import ru.maxvgrad.tutor.entity.Answer;
import ru.maxvgrad.tutor.repository.AnswerRepository;
import ru.maxvgrad.tutor.utils.TestObject;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@Disabled
abstract class SubmissionFormServiceTest<T> {

    static final Long VALID_ANSWER_ID = 1L;
    static final Long INVALID_ANSWER_ID = -1L;

    private SubmissionFormDto<T> submissionForm;

    @Test
    void listAll() {

    }

    @Test
    void saveNew() {
        submissionForm = getAnswerService().save(TestObject.buildSubmissionForm(buildValidForm()));
        Mockito.verify(getAnswerRepository()).save(any(Answer.class));
    }

    @Test
    void remove() {
    }

    @Test
    private void getSuccess() {
        Optional<SubmissionFormDto<T>> submissionFormOpt = getAnswerService().get(VALID_ANSWER_ID);
        assertTrue(submissionFormOpt.isPresent());
        Mockito.verify(getAnswerRepository()).getById(VALID_ANSWER_ID);
    }

    @Test
    void getNotFoundTest() {
        assertFalse(getAnswerService().get(INVALID_ANSWER_ID).isPresent());
    }

    @Test
    void evaluate() {
    }

    abstract SubmissionFormService<T> getAnswerService();

    abstract T buildValidForm();

    abstract AnswerRepository getAnswerRepository();

    void thenAssert() {
        assertNotNull(submissionForm);
        assertNotNull(submissionForm.getId());
        assertNotNull(submissionForm.getExaminationFormId());
    }
}