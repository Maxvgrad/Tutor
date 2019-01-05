package ru.maxvgrad.tutor.controller;

import org.junit.jupiter.api.Test;
import ru.maxvgrad.tutor.dto.EgeMathProfFormDto;
import ru.maxvgrad.tutor.entity.ExaminationForm;
import ru.maxvgrad.tutor.repository.AnswerRepository;
import ru.maxvgrad.tutor.repository.ExaminationFormRepository;
import ru.maxvgrad.tutor.utils.ControllerTest;
import ru.maxvgrad.tutor.utils.TestObject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

abstract class AnswerControllerTest extends ControllerTest {

    @Test
    void listAll() {

        ExaminationForm examinationForm = TestObject.buildExaminationForm(getSubmissionForm());
        getExaminationFormRepository().save(examinationForm);

        getAnswerRepository().save(TestObject.buildAnswer(getSubmissionForm(), examinationForm));
        getAnswerRepository().save(TestObject.buildAnswer(getSubmissionForm(), examinationForm));

        assertNotNull(getAnswerRepository().getById(1L));

//        assertEquals(2, getAnswerRepository().findAll().size());
    }

//    @Test
    void save() {
    }

    @Test
    void get() {

    }

//    @Test
    void evaluate() {
    }

//    @Test
    void delete() {
    }

    abstract String getBaseUrl();

    abstract AnswerRepository getAnswerRepository();

    abstract ExaminationFormRepository getExaminationFormRepository();

    abstract EgeMathProfFormDto getSubmissionForm();
}