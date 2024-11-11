package com.example.payment_study1.domain.payment.service;

import com.example.payment_study1.domain.exception.CustomLogicException;
import com.example.payment_study1.domain.exception.ExceptionCode;
import com.example.payment_study1.domain.member.entity.Member;

import com.example.payment_study1.domain.member.service.MemberService;
import com.example.payment_study1.domain.payment.entity.Payment;
import com.example.payment_study1.domain.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final MemberService memberService;

    public Payment requestTossPayment(Payment payment, String userEmail) {

        Member member = memberService.findMember(userEmail);
        if(payment.getAmount() < 1000) {
            throw new CustomLogicException(ExceptionCode.INVALID_PAYMENT_AMOUNT);
        }
        payment.setCustomer(member);
        return paymentRepository.save(payment);

    }

}
