package ru.maxvgrad.tutor.repository;

import ru.maxvgrad.tutor.entity.UserRole;

public interface UserRoleRepository extends EntityBaseRepository<UserRole> {

    UserRole getUserRoleByName(String name);

}
