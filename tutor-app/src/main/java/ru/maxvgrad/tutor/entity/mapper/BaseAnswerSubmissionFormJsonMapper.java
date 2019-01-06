package ru.maxvgrad.tutor.entity.mapper;

import com.vladmihalcea.hibernate.type.json.internal.JacksonUtil;
import lombok.RequiredArgsConstructor;
import ru.maxvgrad.tutor.dto.SubmissionFormDto;
import ru.maxvgrad.tutor.entity.Answer;
import ru.maxvgrad.tutor.entity.ExaminationForm;

import java.util.Arrays;

@RequiredArgsConstructor
public abstract class BaseAnswerSubmissionFormJsonMapper<T> implements Mapper<Answer, SubmissionFormDto<T>> {

    @Override
    public SubmissionFormDto<T> fromEntity(Answer entity) {
        if (entity == null) {
            return null;
        }
        return SubmissionFormDto.<T>builder()
                .id(entity.getId())
                .examinationFormId(entity.getExaminationForm().getId())
                .form(JacksonUtil.fromString(entity.getSubmitForm(), getFormClass()))
                .build();
    }

    protected abstract Class<T> getFormClass();

    @Override
    public Answer fromDto(SubmissionFormDto<T> dto) {
        if (dto == null) {
            return null;
        }
        return Answer.builder()
                     .id(dto.getId())
                     .total(countNotNullQuestions(dto.getForm()))
                     .submitForm(JacksonUtil.toString(dto.getForm()))
                     .examinationForm(ExaminationForm.builder().id(dto.getExaminationFormId()).build())
                     .build();
    }

    @Override
    public Answer update(Answer entity, SubmissionFormDto<T> dto) {
        throw new UnsupportedOperationException();
    }

    int countNotNullQuestions(T form) {
        return (int) Arrays.stream(getFormClass().getDeclaredFields()).filter(field -> {
            try {
                field.setAccessible(true);
                return field.get(form) != null;
            } catch (IllegalAccessException ex) {
                throw new IllegalArgumentException(ex);
            }
        }).count();
    }
}
