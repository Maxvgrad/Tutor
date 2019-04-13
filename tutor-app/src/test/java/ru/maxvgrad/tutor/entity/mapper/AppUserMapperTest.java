package ru.maxvgrad.tutor.entity.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.maxvgrad.tutor.TutorApplication;
import ru.maxvgrad.tutor.dto.AppUserDto;
import ru.maxvgrad.tutor.entity.AppUser;
import ru.maxvgrad.tutor.utils.TestDto;
import ru.maxvgrad.tutor.utils.TestEntity;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TutorApplication.class)
class AppUserMapperTest {

    @Autowired
    private AppUserMapper appUserMapper;

    @Test
    void appUserToAppUserDto() {
        //given
        AppUser appUser = TestEntity.buildAppUser();
        //when
        AppUserDto appUserDto = appUserMapper.appUserToAppUserDto(appUser);
        //then
        assertThat(appUserDto.getEmail()).isEqualTo(appUser.getEmail());
        assertThat(appUserDto.getFullName()).isEqualTo(appUser.getFullName());
        assertThat(appUserDto.getPassword()).isEqualTo(appUser.getPassword());
        assertThat(appUserDto.getLogin()).isEqualTo(appUser.getLogin());
        assertThat(appUserDto.getId()).isEqualTo(appUser.getId());
        assertThat(appUserDto.getPhone()).isEqualTo(appUser.getPhone());
        assertThat(appUserDto.getStatus()).isEqualTo(appUser.getStatus());
    }

    @Test
    void appUserDtoToAppUser() {
        //given
        AppUserDto appUserDto = TestDto.builAppUserDto();
        //when
        AppUser appUser = appUserMapper.appUserDtoToAppUser(appUserDto);
        //then
        assertThat(appUser.getEmail()).isEqualTo(appUserDto.getEmail());
        assertThat(appUser.getFullName()).isEqualTo(appUserDto.getFullName());
        assertThat(appUser.getPassword()).isEqualTo(appUserDto.getPassword());
        assertThat(appUser.getLogin()).isEqualTo(appUserDto.getLogin());
        assertThat(appUser.getId()).isEqualTo(appUserDto.getId());
        assertThat(appUser.getPhone()).isEqualTo(appUserDto.getPhone());
        assertThat(appUser.getStatus()).isEqualTo(appUserDto.getStatus());
    }
}