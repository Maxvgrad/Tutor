package ru.maxvgrad.tutor.entity.mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.maxvgrad.tutor.dto.SubmissionFormDto;
import ru.maxvgrad.tutor.entity.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
abstract class BaseAnswerSubmissionFormJsonMapperTest<T> {

    @Test
    void fromEntity() {
        Answer answer = getAnswer();
        SubmissionFormDto<T> submissionForm = getMapper().fromEntity(answer);
        assertNotNull(submissionForm);
        assertEquals(answer.getId(), submissionForm.getId());
        assertEquals(answer.getExaminationForm().getId(), submissionForm.getExaminationFormId());
    }

    @Test
    void fromDto() {
        SubmissionFormDto<T> submissionForm = getSubmissionForm();
        Answer answer = getMapper().fromDto(getSubmissionForm());
        assertNotNull(answer);
        assertNotNull(answer.getExaminationForm());
        assertNotNull(answer.getSubmitForm());
        assertEquals(submissionForm.getExaminationFormId(), answer.getExaminationForm().getId());
        assertEquals(submissionForm.getId(), answer.getId());
        assertNotNull(answer.getTotal());
    }

    @Test
    void update() {
        assertThrows(UnsupportedOperationException.class, () -> getMapper().update(getAnswer(), getSubmissionForm()));
    }

    abstract Mapper<Answer, SubmissionFormDto<T>> getMapper();

    abstract Answer getAnswer();

    abstract SubmissionFormDto<T> getSubmissionForm();

    abstract void assertForm(T form);
}