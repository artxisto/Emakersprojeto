package com.artxisto.biblioteca_api.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.artxisto.biblioteca_api.model.Pessoa;

@Service
public class JwtService {

    private final JwtEncoder jwtEncoder;

    @Value("${jwt.expiration}")
    private long expiration;

    public JwtService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String generateToken(Pessoa pessoa) {

        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("biblioteca-api")
                .issuedAt(now)
                .expiresAt(now.plusMillis(expiration))
                .subject(pessoa.getEmail())
                .claim("nome", pessoa.getNome())
                .build();

        return jwtEncoder
                .encode(JwtEncoderParameters.from(claims))
                .getTokenValue();
    }
}