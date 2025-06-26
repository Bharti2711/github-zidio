package com.zidio.zidioconnect.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserStatusUpdateRequest {
    private String email;
    private boolean isActive;
}
