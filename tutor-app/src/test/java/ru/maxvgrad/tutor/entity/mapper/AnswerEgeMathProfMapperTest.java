package ru.maxvgrad.tutor.entity.mapper;

import ru.maxvgrad.tutor.dto.SubmissionFormDto;
import ru.maxvgrad.tutor.entity.Answer;
import ru.maxvgrad.tutor.form.EgeMathProfForm;
import ru.maxvgrad.tutor.utils.TestObject;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerEgeMathProfMapperTest extends BaseAnswerSubmissionFormJsonMapperTest<EgeMathProfForm> {

    private static Mapper<Answer, SubmissionFormDto<EgeMathProfForm>> mapper = new AnswerEgeMathProfMapper();

    @Override
    Mapper<Answer, SubmissionFormDto<EgeMathProfForm>> getMapper() {
        return mapper;
    }

    @Override
    Answer getAnswer() {
        return TestObject.buildAnswer(TestObject.buildEgeMathProfForm(), TestObject.buildExaminationForm());
    }

    @Override
    void assertForm(EgeMathProfForm form) {
        assertEquals(TestObject.buildEgeMathProfForm(), form);
    }

    @Override
    SubmissionFormDto<EgeMathProfForm> getSubmissionForm() {
        return TestObject.buildSubmissionForm(TestObject.buildEgeMathProfForm());
    }
}