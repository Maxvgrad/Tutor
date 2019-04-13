package ru.maxvgrad.tutor.utils;

import lombok.experimental.UtilityClass;
import ru.maxvgrad.tutor.dto.AppUserDto;
import ru.maxvgrad.tutor.dto.enums.AppUserStatus;

@UtilityClass
public class TestDto {

    public AppUserDto builAppUserDto() {
        return AppUserDto.builder()
                         .id(42L)
                         .status(AppUserStatus.ACTIVE)
                         .phone("+79528850909")
                         .password("99")
                         .matchingPassword("99")
                         .fullName("Maksim Vinogradov")
                         .login("maxvgrad")
                         .email("max@gmail.com")
                         .build();
    }

}
