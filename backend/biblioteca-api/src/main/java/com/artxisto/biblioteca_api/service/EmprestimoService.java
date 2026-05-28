package com.artxisto.biblioteca_api.service;

import com.artxisto.biblioteca_api.model.Emprestimo;
import com.artxisto.biblioteca_api.model.Livro;
import com.artxisto.biblioteca_api.model.Pessoa;
import com.artxisto.biblioteca_api.repository.EmprestimoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {

        Pessoa pessoa = emprestimo.getPessoa();
        Livro livro = emprestimo.getLivro();

        if (emprestimoRepository.existsByPessoaAndLivro(pessoa, livro)) {
            throw new RuntimeException("Esse empréstimo já existe");
        }

        return emprestimoRepository.save(emprestimo);
    }

    public void deletarEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }
}