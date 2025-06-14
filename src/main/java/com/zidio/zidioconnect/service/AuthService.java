package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.DTO.LoginRequest;
import com.zidio.zidioconnect.DTO.RegisterRequest;
import com.zidio.zidioconnect.entity.Users;
import com.zidio.zidioconnect.repository.UsersRepository;
import com.zidio.zidioconnect.security.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JwtUtility jwtUtility;

    public String register (RegisterRequest request){
        Users users = new Users();
        users.setEmail(request.email);
        users.setPassword(new BCryptPasswordEncoder().encode(request.password));
        users.setRole(request.role);
        users.setName(request.name);
        usersRepository.save(users);
        return "User Registered Successfully";
    }

    public String login(LoginRequest request){

        Users users = (Users) usersRepository.findByEmail(request.email).orElseThrow(() -> new RuntimeException("User not Found"));


        if(!new BCryptPasswordEncoder().matches(request.password,users.getPassword())){

            throw new RuntimeException("Invalid Password");
        }

        return jwtUtility.generateToken(users.getEmail());
    }
}
