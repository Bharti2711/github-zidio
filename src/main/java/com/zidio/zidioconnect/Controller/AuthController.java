package com.zidio.zidioconnect.Controller;

import com.zidio.zidioconnect.DTO.LoginRequest;
import com.zidio.zidioconnect.DTO.RegisterRequest;
import com.zidio.zidioconnect.security.JwtUtility;
import com.zidio.zidioconnect.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@Component
public class AuthController {
    @Autowired
    private AuthService authService;
    private JwtUtility jwtUtility;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> register(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));

    }
     @GetMapping("/validate")
    public ResponseEntity<String> validate(@RequestParam String token){
        boolean isValid = jwtUtility.validateToken(token);
        return isValid? ResponseEntity.ok("Valid Token"):ResponseEntity.status(401).body("Invalid Token");
    }
}
