package com.zidio.zidioconnect.DTO;

import com.zidio.zidioconnect.entity.Users;

public class RegisterRequest {
    public String name;
    public String email;
    public String password;
    public Users.Role role;
}
