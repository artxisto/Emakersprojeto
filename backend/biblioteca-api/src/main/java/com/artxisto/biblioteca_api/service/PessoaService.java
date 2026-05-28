package com.artxisto.biblioteca_api.service;

import com.artxisto.biblioteca_api.model.Pessoa;
import com.artxisto.biblioteca_api.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {

        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow();

        pessoa.setNome(pessoaAtualizada.getNome());
        pessoa.setCpf(pessoaAtualizada.getCpf());
        pessoa.setCep(pessoaAtualizada.getCep());
        pessoa.setEmail(pessoaAtualizada.getEmail());
        pessoa.setSenha(pessoaAtualizada.getSenha());

        return pessoaRepository.save(pessoa);
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}