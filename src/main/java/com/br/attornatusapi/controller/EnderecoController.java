package com.br.attornatusapi.controller;

import com.br.attornatusapi.dto.EnderecoDTO;
import com.br.attornatusapi.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;
    @PostMapping("/criar")
    public ResponseEntity<?> create(@Valid @RequestBody EnderecoDTO form) throws Exception {
        enderecoService.criarEndereco(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/consultarEnderecoPorPessoa")
    public ResponseEntity<?> consultarEnderecoPessoa(@RequestParam(value = "idPessoa" , required = true) long idPessoa) {
        return ResponseEntity.ok(enderecoService.consultarEnderecoPessoa(idPessoa));
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarPessoa(@RequestParam(value = "idPessoa" , required = true) long idPessoa,
                                          @RequestParam(value = "idEndereco" , required = true) long idEndereco) {

        enderecoService.adicionarEnderecoPrincipal(idPessoa,idEndereco);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/adicionarEnderecoPrincipal")
    public ResponseEntity<?> adicionarEnderecoPrincipal(@RequestParam(value = "idPessoa" , required = true) long idPessoa,
                                          @RequestParam(value = "idEndereco" , required = true) long idEndereco) {
        enderecoService.adicionarEnderecoPrincipal(idPessoa,idEndereco);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/listarEnderecos")
    public ResponseEntity<?> listarEnderecos() {
        return ResponseEntity.ok(enderecoService.listarEnderecos());
    }
}
