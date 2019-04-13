package ru.maxvgrad.tutor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.maxvgrad.tutor.dto.enums.AppUserStatus;
import ru.maxvgrad.tutor.validation.PasswordMatches;
import ru.maxvgrad.tutor.validation.ValidEmail;

import javax.validation.constraints.NotBlank;

@PasswordMatches
@Builder
@Data
@AllArgsConstructor
public class AppUserDto {

    /**
     * Идентификатор
     */
    private Long id;

    /**
     * ФИО
     */
    @NotBlank
    private String fullName;

    private String login;

    @NotBlank
    private String password;

    private String matchingPassword;

    @ValidEmail
    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    /**
     * Статус пользователя
     */
    private AppUserStatus status;

}
