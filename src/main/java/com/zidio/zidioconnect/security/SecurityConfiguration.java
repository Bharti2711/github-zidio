package com.zidio.zidioconnect.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> {}) // <-- enable CORS
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/auth/**",
                                "/students/**",
                                "/api/recruiters/**",
                                "/api/jobs/**",
                                "/api/applications/**",
                                "/api/admin/**",
                                "/api/notifications/**",
                                "/api/file/**",
                                "/api/file/cloud/**","/ap/payment/**","/api/subscription","/api/user_subscription_status/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }


}
