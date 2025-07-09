package com.zidio.zidioconnect.DTO;

public class PaymentRequest {
    private Long userID;
    private Long subscriptionID;
    private String paymentType;

    public PaymentRequest() {} // Required for deserialization

    public PaymentRequest(Long userID, Long subscriptionID, String paymentType) {
        this.userID = userID;
        this.subscriptionID = subscriptionID;
        this.paymentType = paymentType;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(Long subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}

