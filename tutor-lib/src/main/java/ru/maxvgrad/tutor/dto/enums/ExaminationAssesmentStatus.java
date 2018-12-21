package ru.maxvgrad.tutor.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum  ExaminationAssesmentStatus {
    PROCESSING(0), SUBMITTED(1), ERROR(2), REMOVED(3);

    private final int code;
}
