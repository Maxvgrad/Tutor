package ru.maxvgrad.tutor.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExaminationFormType {
    EGE_MATH_PROFESSIONAL(0);

    private final int code;
}
