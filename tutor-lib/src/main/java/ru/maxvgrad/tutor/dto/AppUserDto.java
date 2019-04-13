package ru.maxvgrad.tutor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.maxvgrad.tutor.validation.PasswordMatches;
import ru.maxvgrad.tutor.validation.ValidEmail;

import javax.validation.constraints.NotBlank;

@PasswordMatches
@Builder
@Data
@AllArgsConstructor
public class AppUserDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String password;
    private String matchingPassword;

    @ValidEmail
    @NotBlank
    private String email;

}
