package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.entity.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 @Repository
public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> {
}
