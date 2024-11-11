package com.example.payment_study1.domain.payment.entity;

public enum PayType {
    CREDIT_CARD("Credit Card"),
    PAYPAL("Paypal"),
    BANK_TRANSFER("Bank Transfer"),
    CASH("Cash"),
    OTHER("Other");

    private final String description;

    PayType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
