package ru.maxvgrad.tutor.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.maxvgrad.tutor.entity.AppUser;
import ru.maxvgrad.tutor.entity.UserRole;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class AppUserDetails implements UserDetails {

    private static final String ROLE_PREFIX = "ROLE_";

    private final String userName;

    private final String password;

    private final Collection<? extends GrantedAuthority> authorities;


    public AppUserDetails(AppUser appUser) {
        Objects.requireNonNull(appUser);
        this.userName = appUser.getLogin();
        this.password = appUser.getPassword();
        this.authorities = initGrantedAuthorities(appUser.getUserRole());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    private Collection<? extends GrantedAuthority> initGrantedAuthorities(Set<UserRole> roleSet) {
        return roleSet.stream().map(r -> new SimpleGrantedAuthority(ROLE_PREFIX + r)).collect(Collectors.toList());
    }
}
