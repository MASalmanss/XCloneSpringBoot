package com.XCloneAppSpring.XCloneApp.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.websocket.Decoder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;

@RequiredArgsConstructor
@Service
public class JwtService {


    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private Long expirationTime;


    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String , Object> extraClaims, UserDetails userDetails){
        return buildJwt(extraClaims , userDetails);
    }

    private String buildJwt(Map<String , Object> extraClaims , UserDetails userDetails){
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .addClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .signWith(getSignKey() , SignatureAlgorithm.HS256)
                .compact();

    }

    private Key getSignKey(){
        byte[] codes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(codes);
    }
}
