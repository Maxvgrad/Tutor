package ru.maxvgrad.tutor.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.maxvgrad.tutor.repository.AppUserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findAppUserByEmail(username).map(AppUserDetails::new).orElseThrow(() -> {
            log.error("#loadUserByUsername: User(login:{})  not found.", username);
            return new IllegalArgumentException("User " + username + " not found in db.");
        });
    }
}
