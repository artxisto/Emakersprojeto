package com.artxisto.biblioteca_api.controller;

import com.artxisto.biblioteca_api.model.Emprestimo;
import com.artxisto.biblioteca_api.service.EmprestimoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping
    public List<Emprestimo> listarEmprestimos() {
        return emprestimoService.listarEmprestimos();
    }

    @PostMapping
    public Emprestimo criarEmprestimo(@RequestBody Emprestimo emprestimo) {
        return emprestimoService.salvarEmprestimo(emprestimo);
    }

    @DeleteMapping("/{id}")
    public void deletarEmprestimo(@PathVariable Long id) {
        emprestimoService.deletarEmprestimo(id);
    }

    @PutMapping("/{id}/devolver")
    public Emprestimo devolverLivro(@PathVariable Long id) {
        return emprestimoService.devolverLivro(id);
}
}