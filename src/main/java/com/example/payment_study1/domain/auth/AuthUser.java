package com.example.payment_study1.domain.auth;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class AuthUser {

    private final Long id;

    private final String name;

    private final String email;

//    private final Collection<? extends GrantedAuthority> authorities;

    public AuthUser(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
