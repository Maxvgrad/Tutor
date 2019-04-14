package ru.maxvgrad.tutor.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.entity.AppUser;
import ru.maxvgrad.tutor.entity.UserRole;
import ru.maxvgrad.tutor.repository.AppUserRepository;

import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findAppUserByEmail(username).map(this::buildUser).orElseThrow(() -> {
            log.error("#loadUserByUsername: User(login:{})  not found.", username);
            return new IllegalArgumentException("User " + username + " not found in db.");
        });
    }

    private UserDetails buildUser(AppUser user) {
        return User.builder().username(user.getEmail()).password(user.getPassword())
                   .authorities(
                           user.getUserRole().stream().map(UserRole::getName).map(SimpleGrantedAuthority::new)
                               .collect(Collectors.toList())).
                           build();
    }
}
