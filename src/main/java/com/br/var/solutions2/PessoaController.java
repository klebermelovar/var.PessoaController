package com.br.var.solutions2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*")
public class PessoaController {
    @GetMapping
    public ResponseEntity<Object>get(){
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setEndereco("Rua juliana, numero 32, parque dos carmargos, barueri");
        pessoa1.setNome("kleber");
        pessoa1.setSobrenome("henrique");
        pessoa1.setIdade(22);
        pessoa1.setPeso(182);
        return ResponseEntity.ok(pessoa1);
    }
    @GetMapping("/resumo")
    public ResponseEntity<Pessoa> getPessoa(@RequestBody Pessoa pessoinha){
     log.info("Iniciando o Processo de resumo da pessoinha",pessoinha);

     log.info("iniciando o calculo do IMC");
        String imc = calculaImc(pessoinha.getPeso(),pessoinha.getAltura());

        log.info("Iniciando calculo de idade");
        int anoNascimento = calculaAnoNascimento(pessoinha.getIdade());

        log.info("Iniciando o calculo de imposto de renda");
        String ImpostoRenda = calculaFaixaImpostoRenda(pessoinha.getSalario());

        log.info("Time de coraçao");
        String validaMundial =
        return ResponseEntity.ok(pessoinha);
    }

    private String calculaFaixaImpostoRenda(double salario) {
    }

    private int calculaAnoNascimento(int idade) {
    }

    private String calculaImc( int peso, int altura) {
        float alturaEmMetros = altura / 100; // converte altura to metros
        float imc = peso / (alturaEmMetros * alturaEmMetros);
        return String.valueOf(imc);
    }

}



