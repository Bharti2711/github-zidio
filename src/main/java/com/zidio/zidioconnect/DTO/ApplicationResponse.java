package com.zidio.zidioconnect.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationResponse {
    private Long id;
    private String studentEmail;
    private Long jobId;
    private String status;
}
