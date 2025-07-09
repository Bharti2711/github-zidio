/*package com.zidio.zidioconnect.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

// @Entity
// @Table(name="user_payment_status")
public class UserPaymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long planId; // Which plan the user bought (SubscriptionPlan.id)
    private Long userId; // Who bought the subscription
    private LocalDate subscriptionStart;
    private LocalDate subscriptionEnd;
    private boolean isActive;

    public UserPaymentStatus(Long id, Long planId, Long userId, LocalDate subscriptionStart, LocalDate subscriptionEnd, boolean isActive) {
        this.id = id;
        this.planId = planId;
        this.userId = userId;
        this.subscriptionStart = subscriptionStart;
        this.subscriptionEnd = subscriptionEnd;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getSubscriptionStart() {
        return subscriptionStart;
    }

    public void setSubscriptionStart(LocalDate subscriptionStart) {
        this.subscriptionStart = subscriptionStart;
    }

    public LocalDate getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public void setSubscriptionEnd(LocalDate subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}*/
