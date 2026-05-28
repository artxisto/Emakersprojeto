package com.artxisto.biblioteca_api.repository;

import com.artxisto.biblioteca_api.model.Emprestimo;
import com.artxisto.biblioteca_api.model.Livro;
import com.artxisto.biblioteca_api.model.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    boolean existsByPessoaAndLivro(Pessoa pessoa, Livro livro);

    boolean existsByLivroId(Long livroId);
}