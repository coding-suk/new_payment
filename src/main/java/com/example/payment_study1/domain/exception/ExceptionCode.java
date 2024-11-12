package com.example.payment_study1.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    MEMBER_NOT_FOUND("Member not Found"),
    INVALID_PAYMENT_AMOUNT("Invalid payment amount"),

    _NOT_FOUND_TOKEN("Token not found"),

    _USER_ROLE_IS_NULL("_USER_ROLE_IS_NULL"),

    _NOT_FOUND_USER("_NOT_FOUND_USER"),
    _PASSWORD_NOT_MATCHES("_PASSWORD_NOT_MATCHES"),
    _DELETED_USER("_DELETED_USER"),
    _NOT_PERMITTED_USER("_NOT_PERMITTED_USER"),

    _BAD_REQUEST_INVALID_EMAIL("_BAD_REQUEST_INVALID_EMAIL"),
    _DUPLICATED_EMAIL("_DUPLICATED_EMAIL"),
    _INVALID_PASSWORD_FORM("_INVALID_PASSWORD_FORM"),
    _BAD_REQUEST_NOT_FOUND_USER("_BAD_REQUEST_NOT_FOUND_USER"),


    _UNAUTHORIZED_INVALID_TOKEN("_UNAUTHORIZED_INVALID_TOKEN"),
    _UNAUTHORIZED_EXPIRED_TOKEN("_UNAUTHORIZED_EXPIRED_TOKEN"),
    _BAD_REQUEST_UNSUPPORTED_TOKEN("_BAD_REQUEST_UNSUPPORTED_TOKEN");

    private final String message;

}
