package com.artxisto.biblioteca_api.controller;

import com.artxisto.biblioteca_api.model.Pessoa;
import com.artxisto.biblioteca_api.service.PessoaService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @PostMapping
    public Pessoa criarPessoa(@Valid @RequestBody Pessoa pessoa) {
        return pessoaService.salvarPessoa(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {

        return pessoaService.atualizarPessoa(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
    }
}