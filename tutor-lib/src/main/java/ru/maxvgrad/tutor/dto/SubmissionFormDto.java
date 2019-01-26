package ru.maxvgrad.tutor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubmissionFormDto<T> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("examination_form_id")
    private Long examinationFormId;

    @JsonProperty("form")
    private T form;
}
