package com.br.attornatusapi.vo;

import com.br.attornatusapi.entity.Endereco;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class PessoaVO {

    private String nome;
    private Date dataNascimento;
    private List<Endereco> enderecos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
