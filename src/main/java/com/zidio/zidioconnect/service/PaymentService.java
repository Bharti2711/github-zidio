package com.zidio.zidioconnect.service;

import java.util.List;
import java.util.stream.Collectors;

import com.zidio.zidioconnect.DTO.PaymentDTO;
import com.zidio.zidioconnect.entity.Payment;
import com.zidio.zidioconnect.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentDTO makePayment(PaymentDTO dto) {
        Payment pay = toEntity(dto);
        Payment saved = paymentRepository.save(pay);
        return toDTO(saved);
    }

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private Payment toEntity(PaymentDTO dto) {
        Payment p = new Payment();
        p.setUserId(dto.getUserId());
        p.setPlanId(dto.getPlanId());
        p.setAmount(dto.getAmount());
        p.setCurrency(dto.getCurrency());
        p.setPaymentType(dto.getPaymentType());
        p.setPaymentStatus(dto.getPaymentStatus());
        p.setPaymentDate(dto.getPaymentDate());
        p.setTransactionId(dto.getTransactionId());
        return p;
    }

    private PaymentDTO toDTO(Payment p) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(p.getId());
        dto.setUserId(p.getUserId());
        dto.setPlanId(p.getPlanId());
        dto.setAmount(p.getAmount());
        dto.setCurrency(p.getCurrency());
        dto.setPaymentType(p.getPaymentType());
        dto.setPaymentStatus(p.getPaymentStatus());
        dto.setPaymentDate(p.getPaymentDate());
        dto.setTransactionId(p.getTransactionId());
        return dto;
    }
}

