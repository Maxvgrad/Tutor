package ru.maxvgrad.tutor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.maxvgrad.tutor.dto.AppUserDto;
import ru.maxvgrad.tutor.dto.enums.AppUserStatus;
import ru.maxvgrad.tutor.dto.enums.UserRoleEnum;
import ru.maxvgrad.tutor.entity.AppUser;
import ru.maxvgrad.tutor.entity.UserRole;
import ru.maxvgrad.tutor.entity.mapper.AppUserMapper;
import ru.maxvgrad.tutor.repository.AppUserRepository;
import ru.maxvgrad.tutor.repository.UserRoleRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AppUserRepository appUserRepository;
    private final UserRoleRepository userRoleRepository;
    private final AppUserMapper appUserMapper;


    @Transactional
    public void registerNewUserAccount(AppUserDto accountDto, BindingResult result) {

        if (emailExist(accountDto.getEmail())) {
            result.rejectValue("email", "message.regError");
            return;
        }

        AppUser appUser = appUserMapper.appUserDtoToAppUser(accountDto);
        UserRole userRole = userRoleRepository.getUserRoleByName(UserRoleEnum.USER.getTitle());
        appUser.getUserRole().add(userRole);
        appUser.setStatus(AppUserStatus.ACTIVE);

        appUserRepository.save(appUser);
    }

    private boolean emailExist(String email) {
        return appUserRepository.findAppUserByEmail(email).isPresent();
    }
}
