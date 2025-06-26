package com.zidio.zidioconnect.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.sql.RowSet;
import java.util.Date;

@Component
public class JwtUtility {

    private final String SECRET_KEY= "secret_key";

    public String generateToken(String email){

        return Jwts.builder().
                setSubject(email).
                setIssuedAt(new Date()).
                setExpiration(new Date(System.currentTimeMillis()+2000000)).
                signWith(SignatureAlgorithm.HS256,SECRET_KEY).
                compact();
    }
    @Autowired
    private UserDetailsService userDetailsService;

    public boolean validateToken(String token) {
        String email = extractEmail(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return email.equals(userDetails.getUsername());
    }


    public String extractEmail(String token){

        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).
                getBody().getSubject();
    }
}