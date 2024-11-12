package com.example.payment_study1.domain.user.entity;

import com.example.payment_study1.domain.exception.CustomLogicException;
import com.example.payment_study1.domain.exception.ExceptionCode;

import java.util.Arrays;

public enum UserRole {

    USER, ADMIN;

    public static UserRole of(String role) {
        return Arrays.stream(UserRole.values())
                .filter(r -> r.name().equalsIgnoreCase(role))
                .findFirst()
                .orElseThrow(()-> new CustomLogicException(ExceptionCode._USER_ROLE_IS_NULL));
    }

}
