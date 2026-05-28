package com.artxisto.biblioteca_api.controller;

import com.artxisto.biblioteca_api.model.Livro;
import com.artxisto.biblioteca_api.service.LivroService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    // LISTAR LIVROS
    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }

    // CRIAR LIVRO
    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroService.salvarLivro(livro);
    }

    // ATUALIZAR LIVRO
    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id,
                                @RequestBody Livro livro) {

        return livroService.atualizarLivro(id, livro);
    }

    // DELETAR LIVRO
    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
    }
}