package ru.maxvgrad.tutor.utils;

import lombok.experimental.UtilityClass;
import ru.maxvgrad.tutor.dto.enums.AppUserStatus;
import ru.maxvgrad.tutor.dto.enums.ExaminationFormType;
import ru.maxvgrad.tutor.entity.Answer;
import ru.maxvgrad.tutor.entity.AppUser;
import ru.maxvgrad.tutor.entity.ExaminationForm;
import ru.maxvgrad.tutor.form.EgeMathProfForm;

import java.time.Instant;

@UtilityClass
public class TestEntity {

    private static final String EMPTY_JSON = "{}";

    public EgeMathProfForm buildEgeMathProfForm() {
        return EgeMathProfForm.builder().b1(1.2).b2(2.2).b3(3.2).b4(4.2).b5(5.2).b6(6.2).b7(7.2)
                                 .b8(8.2)
                                 .b9(9.2)
                                 .b10(10.2)
                                 .b11(11.2)
                                 .b12(12.2)
                                 .build();
    }

    public Answer buildAnswer() {
        return buildAnswer(EMPTY_JSON, buildExaminationForm());
    }

    public <T> Answer buildAnswer(T submitForm, ExaminationForm examinationForm) {
        String submitFormJson = TestUtils.writeValueAsString(submitForm);
        return buildAnswer(submitFormJson, examinationForm);
    }

    public Answer buildAnswer(String submitFormJson, ExaminationForm examinationForm) {
        return Answer.builder()
                     .id(1L)
                     .submitForm(submitFormJson)
                     .examinationForm(examinationForm)
                     .total(4).build();
    }

    public <T> ExaminationForm buildExaminationForm() {
        return buildExaminationForm(EMPTY_JSON);
    }

    public <T> ExaminationForm buildExaminationForm(T questionKey) {
        String questionKeyJson = TestUtils.writeValueAsString(questionKey);
        return buildExaminationForm(questionKeyJson);
    }

    public ExaminationForm buildExaminationForm(String questionKeyJson) {
        return ExaminationForm.builder()
                              .id(1L)
                              .creationDate(Instant.now())
                              .examType(ExaminationFormType.EGE_MATH_PROFESSIONAL)
                              .total(5)
                              .questionKey(questionKeyJson)
                              .build();
    }

    public AppUser buildAppUser() {
        return AppUser.builder()
                      .id(42L)
                      .status(AppUserStatus.ACTIVE)
                      .phone("+79528850909")
                      .password("99")
                      .fullName("Maksim Vinogradov")
                      .login("maxvgrad")
                      .email("max@gmail.com")
                      .build();
    }
}
