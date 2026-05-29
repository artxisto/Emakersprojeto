package com.artxisto.biblioteca_api.service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.artxisto.biblioteca_api.model.Pessoa;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(Pessoa pessoa) {

        Key key = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8));

        Date now = new Date();

        Date expiryDate = new Date(
                now.getTime() + expiration);

        return Jwts.builder()
                .subject(pessoa.getEmail())
                .claim("nome", pessoa.getNome())
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {

        Key key = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8));

        return Jwts.parser()
                    .verifyWith((javax.crypto.SecretKey) key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
    }

    public boolean isTokenValid(String token) {

        try {
            Key key = Keys.hmacShaKeyFor(
                    secret.getBytes(StandardCharsets.UTF_8));

            
            Jwts.parser()
                    .verifyWith((javax.crypto.SecretKey) key)
                    .build()
                    .parseSignedClaims(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}