package ru.maxvgrad.tutor.repository;

import org.springframework.stereotype.Repository;
import ru.maxvgrad.tutor.entity.AppUser;

import java.util.Optional;

@Repository
public interface AppUserRepository extends EntityBaseRepository<AppUser> {

    Optional<AppUser> findAppUserByLogin(String login);

    Optional<AppUser> findAppUserByEmail(String email);

}
