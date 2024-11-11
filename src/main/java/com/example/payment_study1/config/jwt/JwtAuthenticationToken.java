package com.example.payment_study1.config.jwt;

import com.example.payment_study1.domain.auth.AuthUser;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private AuthUser authUser;

    public JwtAuthenticationToken(AuthUser authUser) {
        super(authUser)
    }
}
