package ru.maxvgrad.tutor.entity.mapper;

import org.springframework.stereotype.Component;
import ru.maxvgrad.tutor.form.EgeMathProfForm;

@Component
public class AnswerEgeMathProfMapper extends BaseAnswerSubmissionFormJsonMapper<EgeMathProfForm> {

    @Override
    protected Class<EgeMathProfForm> getFormClass() {
        return EgeMathProfForm.class;
    }
}
