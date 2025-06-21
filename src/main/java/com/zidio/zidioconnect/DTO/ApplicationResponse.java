package com.zidio.zidioconnect.DTO;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public class ApplicationResponse{
    public Long id;
    public String studentEmail;
    public Long jobId;
    public String status;
}