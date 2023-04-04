package com.br.var.solutions2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")

public class PessoaControllerTeste {
@GetMapping
    public ResponseEntity<Object>get(){
PessoaRequest pessoaRequest1 = new PessoaRequest();
pessoaRequest1.setNome("kleber");
pessoaRequest1.setSobrenome("henrique");
pessoaRequest1.setIdade(22);
pessoaRequest1.setPeso(110);
    return ResponseEntity.ok(pessoaRequest1);
    }
}
