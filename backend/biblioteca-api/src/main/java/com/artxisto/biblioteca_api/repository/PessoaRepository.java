package com.artxisto.biblioteca_api.repository;

import com.artxisto.biblioteca_api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findByEmail(String email);

}