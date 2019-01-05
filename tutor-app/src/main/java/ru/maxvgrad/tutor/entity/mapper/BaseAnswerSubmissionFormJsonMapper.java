package ru.maxvgrad.tutor.entity.mapper;

import com.vladmihalcea.hibernate.type.json.internal.JacksonUtil;
import lombok.RequiredArgsConstructor;
import ru.maxvgrad.tutor.dto.SubmissionFormDto;
import ru.maxvgrad.tutor.entity.Answer;

@RequiredArgsConstructor
public abstract class BaseAnswerSubmissionFormJsonMapper<T> implements Mapper<Answer, SubmissionFormDto<T>> {

    @Override
    public SubmissionFormDto<T> fromEntity(Answer entity) {
        return SubmissionFormDto.<T>builder()
                .id(entity.getId())
                .examinationFormId(entity.getExaminationForm().getId())
                .form(JacksonUtil.fromString(entity.getSubmitForm(), getFormClass()))
                .build();
    }

    protected abstract Class<T> getFormClass();

    @Override
    public Answer fromDto(SubmissionFormDto<T> dto) {
        return null;
    }

    @Override
    public Answer update(Answer entity, SubmissionFormDto<T> dto) {
        return null;
    }
}
