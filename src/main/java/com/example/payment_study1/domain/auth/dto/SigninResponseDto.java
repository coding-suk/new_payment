package com.example.payment_study1.domain.auth.dto;

import lombok.Getter;

@Getter
public class SigninResponseDto {

    // 로그인 반환 값
    private final String bearerToken;

    public SigninResponseDto(String bearerToken) {
        this.bearerToken = bearerToken;
    }

}
