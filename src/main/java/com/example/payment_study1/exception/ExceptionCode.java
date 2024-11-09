package com.example.payment_study1.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    MEMBER_NOT_FOUND("Member not Found"),
    INVALID_PAYMENT_AMOUNT("Invalid payment amount");

    private final String message;

}
