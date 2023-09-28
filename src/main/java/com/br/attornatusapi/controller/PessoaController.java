package com.br.attornatusapi.controller;

import com.br.attornatusapi.dto.PessoaDTO;
import com.br.attornatusapi.repository.PessoaRepository;
import com.br.attornatusapi.service.PessoaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/criar")
    public ResponseEntity<?> create(@Valid @RequestBody PessoaDTO form) throws Exception {
        pessoaService.criarPessoa(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> editarPessoa(@RequestParam(value = "idPessoa" , required = true) long idPessoa, @Valid @RequestBody PessoaDTO form) {

        pessoaService.editarPessoa(idPessoa,form);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/listarPorPessoas")
    public ResponseEntity<?> consultarPessoa(@RequestParam(value = "idPessoa" , required = true) long idPessoa) {
        return ResponseEntity.ok(pessoaService.consultarPessoa(idPessoa));
    }

    @GetMapping("/listarPessoas")
    public ResponseEntity<?> listarPessoas() {
        return ResponseEntity.ok(pessoaService.listarPessoas());
    }




}
