package ru.maxvgrad.tutor.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRoleEnum {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER"),
    STUDENT("ROLE_STUDENT"),
    TUTOR("ROLE_TUTOR"),

    ;

    private final String title;

}
