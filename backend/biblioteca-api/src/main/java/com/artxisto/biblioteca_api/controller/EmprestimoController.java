package com.artxisto.biblioteca_api.controller;

import com.artxisto.biblioteca_api.model.Emprestimo;
import com.artxisto.biblioteca_api.service.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
@Tag(name = "Emprestimo", description = "Operações relacionadas aos empréstimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @Operation(summary = "Listar todos os empréstimos")
    @GetMapping
    public List<Emprestimo> listarEmprestimos() {
        return emprestimoService.listarEmprestimos();
    }

    @Operation(summary = "Cadastrar um empréstimo")
    @PostMapping
    public Emprestimo criarEmprestimo(@Valid @RequestBody Emprestimo emprestimo) {
        return emprestimoService.salvarEmprestimo(emprestimo);
    }

    @Operation(summary = "Deletar um empréstimo")
    @DeleteMapping("/{id}")
    public void deletarEmprestimo(@PathVariable Long id) {
        emprestimoService.deletarEmprestimo(id);
    }

    @Operation(summary = "Devolver um livro")
    @PutMapping("/{id}/devolver")
    public Emprestimo devolverLivro(@PathVariable Long id) {
        return emprestimoService.devolverLivro(id);
}
}