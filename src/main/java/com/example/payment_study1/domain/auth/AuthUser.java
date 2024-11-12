package com.example.payment_study1.domain.auth;

import com.example.payment_study1.domain.user.entity.UserRole;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Getter
public class AuthUser {

    private final Long id;

    private final String name;

    private final String email;

    private final Collection<? extends GrantedAuthority> authorities;

    public AuthUser(Long id, String name, String email, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.authorities = List.of(new SimpleGrantedAuthority(role.name()));
    }

}
