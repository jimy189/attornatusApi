package com.br.attornatusapi.service;

import com.br.attornatusapi.dto.EnderecoDTO;
import com.br.attornatusapi.entity.Endereco;
import com.br.attornatusapi.entity.Pessoa;
import com.br.attornatusapi.repository.EnderecoRepository;
import com.br.attornatusapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Endereco criarEndereco(EnderecoDTO form) {
        return enderecoRepository.save(new Endereco(form));
    }

    public List<Endereco> consultarEnderecoPessoa(long idPessoa) {
        List<Endereco> enderecos = enderecoRepository.findAllByPessoa(idPessoa);
        return enderecos;
    }

    public void adicionarEnderecoPrincipal(long idPessoa, long idEndereco) {
        Optional<Endereco> endereco = enderecoRepository.findById(idEndereco);
        endereco.get().setEnderecoPrincipal(true);
        Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);
        endereco.get().setPessoa(pessoa.get());
        enderecoRepository.save(endereco.get());
    }

    public List<Endereco> listarEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos;
    }
}
