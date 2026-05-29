package com.artxisto.biblioteca_api.service;

import com.artxisto.biblioteca_api.model.Pessoa;
import com.artxisto.biblioteca_api.repository.PessoaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.artxisto.biblioteca_api.dto.ViaCepResponse;
import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;

    public PessoaService(PessoaRepository pessoaRepository, RestTemplate restTemplate, PasswordEncoder passwordEncoder) {
        this.pessoaRepository = pessoaRepository;
        this.restTemplate = restTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    private void preencherEnderecoPorCep(Pessoa pessoa) {

        String url = "https://viacep.com.br/ws/"
                + pessoa.getCep().replace("-", "")
                + "/json/";

        ViaCepResponse endereco =
                restTemplate.getForObject(url, ViaCepResponse.class);

        if (endereco != null) {
            pessoa.setLogradouro(endereco.getLogradouro());
            pessoa.setBairro(endereco.getBairro());
            pessoa.setCidade(endereco.getLocalidade());
            pessoa.setUf(endereco.getUf());
        }
    }

    public Pessoa salvarPessoa(Pessoa pessoa) {

        pessoa.setSenha(passwordEncoder.encode(pessoa.getSenha()));
        preencherEnderecoPorCep(pessoa);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {

        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();

        pessoa.setNome(pessoaAtualizada.getNome());
        pessoa.setCpf(pessoaAtualizada.getCpf());
        pessoa.setCep(pessoaAtualizada.getCep());
        pessoa.setEmail(pessoaAtualizada.getEmail());
        pessoa.setSenha(passwordEncoder.encode(pessoaAtualizada.getSenha()));

        preencherEnderecoPorCep(pessoa);

        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas() {
    return pessoaRepository.findAll();
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}