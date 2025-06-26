package com.zidio.zidioconnect.service;


import com.zidio.zidioconnect.DTO.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService{


    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(EmailRequest request){
        SimpleMailMessage message = new SimpleMailMessage();


        message.setTo(request.getTo());
        message.setSubject(request.getSubject());
        message.setText(request.getMessage());
        message.setFrom("Your-email@gmail.com");
        mailSender.send(message);

        return "Email sent Successfully";
    }
}
