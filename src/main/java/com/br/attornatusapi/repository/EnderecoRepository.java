package com.br.attornatusapi.repository;

import com.br.attornatusapi.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query(value = "SELECT e FROM Endereco e WHERE e.pessoa.id= :idPessoa ")
    List<Endereco> findAllByPessoa(Long idPessoa);

;


}
