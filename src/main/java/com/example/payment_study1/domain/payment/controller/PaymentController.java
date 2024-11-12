package com.example.payment_study1.domain.payment.controller;

import com.example.payment_study1.domain.config.PaymentsConfig;
import com.example.payment_study1.domain.payment.dto.PaymentRequestDto;
import com.example.payment_study1.domain.payment.dto.PaymentResponseDto;
import com.example.payment_study1.domain.payment.service.PaymentService;
import com.example.payment_study1.domain.user.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v2/standard")
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentsConfig paymentsConfig;

    @PostMapping("/toss")
    public ResponseEntity requestTossPayment(@AuthenticationPrincipal User principal,
                                             @RequestBody @Valid PaymentRequestDto requestDto) {
        PaymentResponseDto paymentResponseDto = paymentService.requestTossPayment(requestDto.toEntity(),
                principal.getName()).toPaymentResponseDto();

        paymentResponseDto.setSuccessUrl(requestDto.getYourSuccessUrl() == null ? paymentsConfig.getSuccessUrl() : requestDto.getYourSuccessUrl());
        paymentResponseDto.setFailUrl(requestDto.getYourFailUrl() == null ? paymentsConfig.getFailUrl() : requestDto.getYourFailUrl());

        return ResponseEntity.ok(paymentResponseDto);
    }

}
