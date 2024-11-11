package com.example.payment_study1.domain.payment.dto;

import com.example.payment_study1.domain.payment.entity.PayType;
import com.example.payment_study1.domain.payment.entity.Payment;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDto {

    @NonNull
    private PayType payType; // 결제 타입

    @NonNull
    private Long amount; // 가격 정보

    @NonNull
    private String orderName;

    private String yourSuccessUrl; // 성공 시 리다이렉트 될 URL
    private String yourFailUrl; // 실패 시 리다이렉트 될 URL

    public Payment toEntity() {
        return Payment.builder()
                .payType(payType)
                .amount(amount)
                .orderName(orderName)
                .orderId(UUID.randomUUID().toString())
                .paySuccessYN(false)
                .build();
    }

}
