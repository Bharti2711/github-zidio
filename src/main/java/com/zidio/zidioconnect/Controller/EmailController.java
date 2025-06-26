package com.zidio.zidioconnect.Controller;


import com.zidio.zidioconnect.DTO.EmailRequest;
import com.zidio.zidioconnect.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")


public class EmailController{

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody EmailRequest request){
        return ResponseEntity.ok(emailService.sendEmail(request));
    }
}