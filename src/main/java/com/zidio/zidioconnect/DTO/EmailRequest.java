package com.zidio.zidioconnect.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailRequest {

    private String to; // Recipient email address
    private String subject; // Email subject line
    private String message; // Email body content
}
