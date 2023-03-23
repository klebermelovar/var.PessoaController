package com.br.var.solutions2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*")
public class PessoaController {
    @GetMapping
    public ResponseEntity<Object> get() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setEndereco("Rua juliana, numero 32, parque dos carmargos, barueri");
        pessoa1.setNome("kleber");
        pessoa1.setSobrenome("henrique");
        pessoa1.setIdade(22);
        pessoa1.setPeso(182);
        return ResponseEntity.ok(pessoa1);
    }

    @GetMapping("/resumo")
    public ResponseEntity<Object> getPessoa(@RequestBody Pessoa pessoinha) {
        String imc = null;
        int anoNascimento = 0;
        String ImpostoRenda = null;
        String validaMundial = null;

        if (!pessoinha.getNome().isEmpty()){


            log.info("Iniciando o Processo de resumo da pessoinha", pessoinha);

            if (Objects.nonNull(pessoinha.getPeso())&&Objects.nonNull(pessoinha.getAltura())) {
                log.info("iniciando o calculo do IMC");
               imc  = calculaImc(pessoinha.getPeso(), pessoinha.getAltura());
            }

            if(Objects.nonNull(pessoinha.getIdade())) {
                log.info("Iniciando calculo de idade");
                 anoNascimento = calculaAnoNascimento(pessoinha.getIdade());
            }

            if (Objects.nonNull(pessoinha.getSalario())) {
                log.info("Iniciando o calculo de imposto de renda");
                 ImpostoRenda = calculaFaixaImpostoRenda(pessoinha.getSalario());
            }
            if (Objects.nonNull(pessoinha.getTime())) {
                log.info("Time de coraçao");
                 validaMundial = calculaMundial(pessoinha.getTime());
            }

            log.info("Montando Objeto de retorno para o front-end.");
            Object resumo = complementarRespostaFrontEnd(imc, anoNascimento, validaMundial, ImpostoRenda);

            return ResponseEntity.ok(resumo);
        }


        return ResponseEntity.badRequest().body("Erro na solicitação");

    }

    private String calculaMundial(String time) {
        String mundial = "Palmeiras";
        String calculamundial;
        if (time.equals(mundial)) {
            calculamundial = "O time " + time + " tem mundial";
        } else {
            calculamundial = "O time " + time + " não tem mundial";
        }
        return calculamundial;
    }


    private String calculaFaixaImpostoRenda(double salario) {
        if (salario <= 1903.98) {
            return "Isento de imposto de renda";
        } else if (salario <= 2826.65) {
            return "Alíquota de 7,5%";
        } else if (salario <= 3751.05) {
            return "Alíquota de 15%";
        } else if (salario <= 4664.68) {
            return "Alíquota de 22,5%";
        } else {
            return "Alíquota de 27,5%";
        }
    }

    private int calculaAnoNascimento(int idade) {
        int anoAtual = 2023;
        int anoNascimento = anoAtual - idade;
        return anoNascimento;
    }

    private String calculaImc( int peso, int altura) {
        float alturaEmMetros = altura / 100; // converte altura to metros
        float imc = peso / (alturaEmMetros * alturaEmMetros);
        return String.valueOf(imc);
    }

}



