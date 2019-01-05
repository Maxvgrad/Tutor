package ru.maxvgrad.tutor.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import ru.maxvgrad.tutor.dto.EgeMathProfFormDto;
import ru.maxvgrad.tutor.dto.enums.ExaminationFormType;
import ru.maxvgrad.tutor.entity.Answer;
import ru.maxvgrad.tutor.entity.ExaminationForm;

import java.time.Instant;

@UtilityClass
public class TestObject {

    private ObjectMapper objectMapper = new ObjectMapper();

    public EgeMathProfFormDto buildEgeMathProfForm() {
        return EgeMathProfFormDto.builder().b1(1.2).b2(2.2).b3(3.2).b4(4.2).b5(5.2).b6(6.2).b7(7.2).b8(8.2).build();
    }

    public Answer buildEgeMathProfAnswer(EgeMathProfFormDto submitForm, ExaminationForm examinationForm) {

        try {
            String s = objectMapper.writeValueAsString(submitForm);
            return Answer.builder().submitForm(s).examinationForm(examinationForm).total(4).build();
        } catch (JsonProcessingException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public <T> ExaminationForm buildExaminationForm(EgeMathProfFormDto questionKey) {
        try {
            String s = objectMapper.writeValueAsString(questionKey);
            return ExaminationForm.builder()
                                  .creationDate(Instant.now())
                                  .examType(ExaminationFormType.EGE_MATH_PROFESSIONAL)
                                  .total(5)
                                  .questionKey(s)
                                  .build();
        } catch (JsonProcessingException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
