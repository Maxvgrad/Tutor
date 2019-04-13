package ru.maxvgrad.tutor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.maxvgrad.tutor.dto.AppUserDto;
import ru.maxvgrad.tutor.repository.AppUserRepository;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Transactional
    public void registerNewUserAccount(AppUserDto accountDto, BindingResult result) {

        if (emailExist(accountDto.getEmail())) {
            result.rejectValue("email", "message.regError");
            return;
        }


    }

    private boolean emailExist(String email) {
        return appUserRepository.findAppUserByEmail(email).isPresent();
    }
}
