package ru.maxvgrad.tutor.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.maxvgrad.tutor.dto.AppUserDto;
import ru.maxvgrad.tutor.entity.AppUser;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    @Mappings({
                      @Mapping(target = "fullName", source = "fullName"),
                      @Mapping(target = "login", source = "login"),
                      @Mapping(target = "id", source = "id"),
                      @Mapping(target = "phone", source = "phone"),
              })
    AppUserDto appUserToAppUserDto(AppUser appUser);

    @Mappings({
                      @Mapping(target = "fullName", source = "fullName"),
                      @Mapping(target = "login", source = "login"),
                      @Mapping(target = "id", source = "id"),
                      @Mapping(target = "phone", source = "phone"),
              })
    AppUser appUserDtoToAppUser(AppUserDto appUser);
}
