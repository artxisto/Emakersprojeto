package com.artxisto.biblioteca_api.controller;

import com.artxisto.biblioteca_api.dto.LoginRequest;
import com.artxisto.biblioteca_api.model.Pessoa;
import com.artxisto.biblioteca_api.repository.PessoaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.artxisto.biblioteca_api.service.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação", description = "Operações relacionadas à autenticação de usuários")
public class AuthController {

    private final PessoaRepository pessoaRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(PessoaRepository pessoaRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.pessoaRepository = pessoaRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Operation(summary = "Realizar login")
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {

        Pessoa pessoa = pessoaRepository
                .findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(loginRequest.getSenha(), pessoa.getSenha())){
                throw new RuntimeException("Senha inválida");
        }
        return jwtService.generateToken(pessoa);
    }
}