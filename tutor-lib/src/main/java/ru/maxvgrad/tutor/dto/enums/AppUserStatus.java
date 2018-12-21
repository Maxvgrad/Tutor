package ru.maxvgrad.tutor.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AppUserStatus {
    ACTIVE(0), BLOCKED(1), REMOVED(3);

    private final int code;
}
