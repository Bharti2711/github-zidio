package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.DTO.LoginRequest;
import com.zidio.zidioconnect.DTO.RegisterRequest;
import com.zidio.zidioconnect.entity.Users;
import com.zidio.zidioconnect.exception.DuplicationEmailException;
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

    public String register(RegisterRequest request) throws DuplicationEmailException {

        if (usersRepository.findByEmail(request.getEmail()).isPresent()) { // ✅ using getter
            throw new DuplicationEmailException(request.getEmail());
        }

        Users users = new Users();
        users.setEmail(request.getEmail()); // ✅ using getter
        users.setPassword(new BCryptPasswordEncoder().encode(request.getPassword())); // ✅ getter
        users.setRole(request.getRole()); // ✅ getter
        users.setName(request.getName()); // ✅ getter

        usersRepository.save(users);
        return "User Registered Successfully";
    }

    public String login(LoginRequest request) {

        Users users = usersRepository.findByEmail(request.getEmail()) // ✅ getter
                .orElseThrow(() -> new RuntimeException("User not Found"));

        if (!new BCryptPasswordEncoder().matches(request.getPassword(), users.getPassword())) { // ✅ getter
            throw new RuntimeException("Invalid Password");
        }

        return jwtUtility.generateToken(users.getEmail());
    }
}
