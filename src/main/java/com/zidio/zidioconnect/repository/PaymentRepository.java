package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.DTO.PaymentRequest;
import com.zidio.zidioconnect.DTO.PaymentResponse;
import com.zidio.zidioconnect.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
