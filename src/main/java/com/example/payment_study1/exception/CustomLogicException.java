package com.example.payment_study1.exception;

import lombok.Getter;

public class CustomLogicException extends RuntimeException{

    @Getter
    private final ExceptionCode exceptionCode;

    public CustomLogicException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }

}
