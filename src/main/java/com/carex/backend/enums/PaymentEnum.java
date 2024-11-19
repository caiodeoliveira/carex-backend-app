package com.carex.backend.enums;

public enum PaymentEnum {
    PIX("PIX"),
    CREDIT_CARD("Crédito"),
    DEBIT_CARD("Débito");

    private String payment;

    private PaymentEnum(String payment) {
        this.payment = payment;
    };

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
