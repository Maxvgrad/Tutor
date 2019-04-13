package ru.maxvgrad.tutor.controller;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.maxvgrad.tutor.TutorApplication;
import ru.maxvgrad.tutor.form.EgeMathProfForm;
import ru.maxvgrad.tutor.repository.AnswerRepository;
import ru.maxvgrad.tutor.repository.ExaminationFormRepository;
import ru.maxvgrad.tutor.utils.TestEntity;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TutorApplication.class)
@AutoConfigureEmbeddedDatabase
@FlywayTest
@AutoConfigureMockMvc
class EgeMathProfFormControllerTest extends SubmissionFormControllerTest {

    private static String baseUrl = TutorApplication.MODULE_BASE_URL + "/examination/assessment/ege/math/prof";

    @Autowired private AnswerRepository answerRepository;

    @Autowired private ExaminationFormRepository examinationFormRepository;

    @Override
    String getBaseUrl() {
        return baseUrl;
    }

    @Override
    AnswerRepository getAnswerRepository() {
        return answerRepository;
    }

    @Override
    EgeMathProfForm getSubmissionForm() {
        return TestEntity.buildEgeMathProfForm();
    }

    @Override
    ExaminationFormRepository getExaminationFormRepository() {
        return examinationFormRepository;
    }
}