package com.zidio.zidioconnect.Controller;


import java.util.Optional;

import com.zidio.zidioconnect.DTO.UserPaymentStatusDTO;
import com.zidio.zidioconnect.service.UserPaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user_subscription_status")
public class UserPaymentStatusController {

    @Autowired
    private UserPaymentStatusService userPaymentStatusService;


    @PostMapping
    public ResponseEntity<UserPaymentStatusDTO>assign(@RequestBody UserPaymentStatusDTO dto ){
        return ResponseEntity.ok(userPaymentStatusService.assignSubscriptionPlan(dto));
    }

    @GetMapping("{userId}")
    public ResponseEntity<Optional<UserPaymentStatusDTO>> getStatus(@PathVariable Long userId){
        return ResponseEntity.ok(userPaymentStatusService.getStatusByUserId(userId));
    }
}
