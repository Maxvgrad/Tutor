package ru.maxvgrad.tutor.validation;

import ru.maxvgrad.tutor.dto.AppUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {

        if (obj instanceof AppUserDto) {
            AppUserDto user = (AppUserDto) obj;
            return user.getPassword().equals(user.getMatchingPassword());
        }

        return false;
    }
}
