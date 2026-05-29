package com.artxisto.biblioteca_api.controller;

import com.artxisto.biblioteca_api.model.Pessoa;
import com.artxisto.biblioteca_api.service.PessoaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
@Tag(name = "Pessoa", description = "Operações relacionadas às pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    @Operation(summary = "Listar todas as pessoas")
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @PostMapping
    @Operation(summary = "Cadastrar uma pessoa")
    public Pessoa criarPessoa(@Valid @RequestBody Pessoa pessoa) {
        return pessoaService.salvarPessoa(pessoa);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma pessoa")
    public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {

        return pessoaService.atualizarPessoa(id, pessoa);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma pessoa")
    public void deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
    }
}