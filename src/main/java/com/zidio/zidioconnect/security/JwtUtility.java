package com.zidio.zidioconnect.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
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
                setExpiration(new Date(System.currentTimeMillis()+2000)).
                signWith(SignatureAlgorithm.HS256,SECRET_KEY).
                compact();
    }
    public boolean validateToken(String token){

        String email= extractEmail(token);
        RowSet userDetails = null;
        return (email.equals(userDetails.getUsername()));
    }
    public String extractEmail(String token){

        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).
                getBody().getSubject();
    }
}