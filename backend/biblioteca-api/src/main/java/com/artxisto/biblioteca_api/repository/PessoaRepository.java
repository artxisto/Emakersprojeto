package com.artxisto.biblioteca_api.repository;

import com.artxisto.biblioteca_api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}