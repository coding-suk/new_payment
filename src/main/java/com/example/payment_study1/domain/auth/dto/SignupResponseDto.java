package com.example.payment_study1.domain.auth.dto;
import lombok.Getter;

@Getter
public class SignupResponseDto {

    // 회원가입 반환 값
    private final String bearerToken;

    public SignupResponseDto(String bearerToken) {
        this.bearerToken = bearerToken;
    }

}

