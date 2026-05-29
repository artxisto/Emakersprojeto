package com.artxisto.biblioteca_api.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @Column(length = 100)
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Column(length = 11, unique = true)
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @Column(length = 9)
    private String cep;

    @Column(length = 150)
    private String logradouro;

    @Column(length = 100)
    private String bairro;

    @Column(length = 100)
    private String cidade;

    @Column(length = 2)
    private String uf;

    @Column(length = 100, unique = true)
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @Column(length = 100)
    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
    private String senha;
    
    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
    return cep;
    }

    public void setCep(String cep) {
    this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogradouro() {
    return logradouro;
    }

    public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
    }

    public String getBairro() {
    return bairro;
    }

    public void setBairro(String bairro) {
    this.bairro = bairro;
    }

    public String getCidade() {
    return cidade;
    }

    public void setCidade(String cidade) {
    this.cidade = cidade;
    }

    public String getUf() {
    return uf;
    }

    public void setUf(String uf) {
    this.uf = uf;
    }


}