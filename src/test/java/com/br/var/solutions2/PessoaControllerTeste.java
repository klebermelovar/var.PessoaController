package com.br.var.solutions2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")

public class PessoaControllerTeste {
@GetMapping
    public ResponseEntity<Object>get(){
Pessoa pessoa1 = new Pessoa();
pessoa1.setNome("kleber");
pessoa1.setSobrenome("henrique");
pessoa1.setIdade(22);
pessoa1.setPeso(110);
    return ResponseEntity.ok(pessoa1);
    }
}
