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
    @Autowired
    private JwtUtility jwtUtility;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));

    }

     @GetMapping("/validate") // The request path is /api/auth/validate?token=YOUR_TOKEN_HERE.
    public ResponseEntity<String> validate(@RequestParam String token){
        boolean isValid = jwtUtility.validateToken(token);
        return isValid? ResponseEntity.ok("Valid Token"):ResponseEntity.status(401).body("Invalid Token");
    }

}
// @RequestParam = Take the value of the token query parameter from the URL and assign it to the token variable