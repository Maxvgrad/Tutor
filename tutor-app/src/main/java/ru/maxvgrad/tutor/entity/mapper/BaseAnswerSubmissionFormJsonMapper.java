package ru.maxvgrad.tutor.entity.mapper;

import com.vladmihalcea.hibernate.type.json.internal.JacksonUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import ru.maxvgrad.tutor.dto.SubmissionFormDto;
import ru.maxvgrad.tutor.entity.Answer;
import ru.maxvgrad.tutor.entity.ExaminationForm;

import java.lang.reflect.Field;
import java.util.Objects;

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
        Field[] fields = getFormClass().getDeclaredFields();

        int count = 0;

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (Objects.nonNull(field.get(form))) {
                    count++;
                }
            } catch (IllegalAccessException ex) {
                ExceptionUtils.rethrow(ex);
            }
        }
        return count;
    }
}
