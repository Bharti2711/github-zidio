package com.zidio.zidioconnect.service;


import java.util.List;
import java.util.stream.Collectors;

import com.zidio.zidioconnect.DTO.SubscriptionPlanDTO;
import com.zidio.zidioconnect.entity.SubscriptionPlan;
import com.zidio.zidioconnect.repository.SubscriptionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;


    public List<SubscriptionPlanDTO> getAllSubscriptionPlan(){
        return subscriptionPlanRepository.findAll().stream().map(sub ->{
            SubscriptionPlanDTO dto = new SubscriptionPlanDTO();
            dto.id=sub.getId();
            dto.name=sub.getName();
            dto.price=sub.getPrice();
            dto.description=sub.getDescription();
            dto.durationInDays=sub.getDurationInDays();
            return dto;
        }).collect(Collectors.toList());
    }

    public SubscriptionPlanDTO createSubscription(SubscriptionPlanDTO dto) {
        SubscriptionPlan subscription= new SubscriptionPlan();
        subscription.setName(dto.name);
        subscription.setId(dto.id);
        subscription.setPrice(dto.price);
        subscription.setDescription(dto.description);
        subscription.setDurationInDays(dto.durationInDays);

        SubscriptionPlan saved = subscriptionPlanRepository.save(subscription);
        dto.id= saved.getId();
        return dto;
    }
}
