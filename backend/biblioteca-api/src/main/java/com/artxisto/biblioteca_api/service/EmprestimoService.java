package com.artxisto.biblioteca_api.service;

import com.artxisto.biblioteca_api.model.Emprestimo;
import com.artxisto.biblioteca_api.model.Livro;
import com.artxisto.biblioteca_api.model.Pessoa;
import com.artxisto.biblioteca_api.repository.EmprestimoRepository;
import com.artxisto.biblioteca_api.repository.LivroRepository;
import com.artxisto.biblioteca_api.repository.PessoaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final PessoaRepository pessoaRepository;
    private final LivroRepository livroRepository;

    public EmprestimoService(
        EmprestimoRepository emprestimoRepository,
        PessoaRepository pessoaRepository,
        
        LivroRepository livroRepository) {
           this.emprestimoRepository = emprestimoRepository;
           this.pessoaRepository = pessoaRepository;
           this.livroRepository = livroRepository;
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {

        Pessoa pessoa = emprestimo.getPessoa();
        Livro livro = emprestimo.getLivro();

        if (!pessoaRepository.existsById(pessoa.getId())) {
            throw new RuntimeException("Pessoa não encontrada");
        }

        if (!livroRepository.existsById(livro.getId())) {
            throw new RuntimeException("Livro não encontrado");
        }

        if (emprestimoRepository.existsByLivroIdAndDevolvidoFalse(livro.getId())) {
            throw new RuntimeException("Livro já emprestado");
        }

        emprestimo.setDevolvido(false);

        return emprestimoRepository.save(emprestimo);
    }

    public void deletarEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }

    public Emprestimo devolverLivro(Long id) {

        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
        emprestimo.setDevolvido(true);
        return emprestimoRepository.save(emprestimo);
}
}