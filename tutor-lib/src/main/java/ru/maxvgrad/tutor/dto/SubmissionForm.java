package ru.maxvgrad.tutor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionForm {

    private Long id;

    private Long examinationFormId;
}
