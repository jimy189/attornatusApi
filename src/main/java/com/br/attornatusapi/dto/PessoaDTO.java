package com.br.attornatusapi.dto;

import com.br.attornatusapi.entity.Endereco;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("dataNascimento")
    private Date dataNascimento;





}
