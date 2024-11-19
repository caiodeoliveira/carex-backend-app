package com.carex.backend.enums;

public enum PaymentTypeEnum {
    HEALTH_INSURANCE("Convênio"),
    PRIVATE("Particular");

    private String paymentType;

    private PaymentTypeEnum(String paymentType) {
        this.paymentType = paymentType;
    };

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
