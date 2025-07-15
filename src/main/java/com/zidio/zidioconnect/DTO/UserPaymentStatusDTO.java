package com.zidio.zidioconnect.DTO;

import com.zidio.zidioconnect.entity.PaymentStatus;

import java.time.LocalDate;

public class UserPaymentStatusDTO {

    public Long id;
    public Long planId;
    public Long userId;
    public LocalDate subscriptionStart;
    public LocalDate subscriptionEnd;
    public PaymentStatus status;


    public UserPaymentStatusDTO() {}
    public UserPaymentStatusDTO(Long id,Long planId,Long userId,LocalDate subscriptionStart,LocalDate subscriptionEnd,PaymentStatus status) {
        this.id=id;
        this.planId=planId;
        this.userId=userId;
        this.subscriptionStart=subscriptionStart;
        this.subscriptionEnd=subscriptionEnd;
        this.status=status;

    }

}