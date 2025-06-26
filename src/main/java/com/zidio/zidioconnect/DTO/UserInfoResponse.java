package com.zidio.zidioconnect.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoResponse {
    private String email;
    private String role;
    private boolean isActive;
}
