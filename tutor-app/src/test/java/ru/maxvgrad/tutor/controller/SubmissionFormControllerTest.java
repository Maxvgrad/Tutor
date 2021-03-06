package ru.maxvgrad.tutor.controller;

import org.junit.jupiter.api.Test;
import ru.maxvgrad.tutor.entity.ExaminationForm;
import ru.maxvgrad.tutor.form.EgeMathProfForm;
import ru.maxvgrad.tutor.repository.AnswerRepository;
import ru.maxvgrad.tutor.repository.ExaminationFormRepository;
import ru.maxvgrad.tutor.utils.ControllerTest;
import ru.maxvgrad.tutor.utils.TestEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

abstract class SubmissionFormControllerTest extends ControllerTest {

    @Test
    void listAll() {

        ExaminationForm examinationForm = TestEntity.buildExaminationForm(getSubmissionForm());
        getExaminationFormRepository().save(examinationForm);

        getAnswerRepository().save(TestEntity.buildAnswer(getSubmissionForm(), examinationForm));
        getAnswerRepository().save(TestEntity.buildAnswer(getSubmissionForm(), examinationForm));

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

    abstract EgeMathProfForm getSubmissionForm();
}