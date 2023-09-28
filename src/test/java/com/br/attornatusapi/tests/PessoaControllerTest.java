package com.br.attornatusapi.tests;


import com.br.attornatusapi.controller.PessoaController;
import com.br.attornatusapi.dto.PessoaDTO;
import com.br.attornatusapi.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.CREATED;

@ExtendWith(MockitoExtension.class)
public class PessoaControllerTest {
    @InjectMocks
    private PessoaController pessoaController;

    @Mock
    private PessoaService pessoaService;

    private PessoaDTO form;

    @BeforeEach
    void setup() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse("18/04/2001");
        form= new PessoaDTO("Renato", data);
        
    }

    @Test
    void deveSalvarPessoa() throws Exception {

        var response = assertDoesNotThrow(() -> pessoaController.create(form));
        assertEquals(ResponseEntity.status(CREATED).build(), response);
    }


}
