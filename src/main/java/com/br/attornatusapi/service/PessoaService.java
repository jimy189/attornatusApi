package com.br.attornatusapi.service;

import com.br.attornatusapi.dto.PessoaDTO;
import com.br.attornatusapi.entity.Pessoa;
import com.br.attornatusapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;


    public void criarPessoa(PessoaDTO form) {
       pessoaRepository.save(new Pessoa(form));
    }

    public void editarPessoa(long idPessoa, PessoaDTO form) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);
        pessoa.get().setNome(form.getNome());
        pessoa.get().setDataNascimento(form.getDataNascimento());
        pessoaRepository.save(pessoa.get());
    }

    public Pessoa consultarPessoa(long idPessoa) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);
        return pessoa.get();
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }


}
