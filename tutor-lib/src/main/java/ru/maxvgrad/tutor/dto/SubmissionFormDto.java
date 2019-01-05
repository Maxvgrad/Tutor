package ru.maxvgrad.tutor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionFormDto<T> {

    private Long id;

    private Long examinationFormId;

    private T form;
}
