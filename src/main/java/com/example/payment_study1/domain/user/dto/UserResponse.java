package com.example.payment_study1.domain.user.dto;

import lombok.Getter;

@Getter
public class UserResponse {

    private Long userId;

    public UserResponse(Long userId) {
        this.userId = userId;
    }

}
