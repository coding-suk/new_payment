package com.example.payment_study1.domain.payment.repository;

import com.example.payment_study1.domain.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
