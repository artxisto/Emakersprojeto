package com.artxisto.biblioteca_api.controller;

import com.artxisto.biblioteca_api.model.Livro;
import com.artxisto.biblioteca_api.service.LivroService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/livros")
@Tag(name = "Livro", description = "Operações relacionadas aos livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @Operation(summary = "Listar todos os livros")
    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }

    @Operation(summary = "Cadastrar um livro")
    @PostMapping
    public Livro criarLivro(@Valid @RequestBody Livro livro) {
        return livroService.salvarLivro(livro);
    }

    @Operation(summary = "Atualizar um livro")
    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id,
                                @RequestBody Livro livro) {

        return livroService.atualizarLivro(id, livro);
    }

    @Operation(summary = "Deletar um livro")
    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
    }
}