package com.br.var.solutions2;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
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
        PessoaRequest pessoaRequest1 = new PessoaRequest();
        pessoaRequest1.setEndereco("Rua juliana, numero 32, parque dos carmargos, barueri");
        pessoaRequest1.setNome("kleber");
        pessoaRequest1.setSobrenome("henrique");
        pessoaRequest1.setIdade(22);
        pessoaRequest1.setPeso(182);
        return ResponseEntity.ok(pessoaRequest1);
    }

    @GetMapping("/resumo")
    public ResponseEntity<Object> getPessoa(@RequestBody PessoaRequest pessoinha) {
        String imc = null;
        int anoNascimento = 0;
        String ImpostoRenda = null;
        String validaMundial = null;
        String SaldoEmDolar = null;
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

            if (Objects.nonNull(pessoinha.getSaldo())) {
                log.info("Convertendo saldo em dolar");
                SaldoEmDolar  =  converteSaldoEmDolar(pessoinha.getSaldo());
            }

            log.info("Montando Objeto de retorno para o front-end.");
            PessoaResponse resumo = complementarRespostaFrontEnd(pessoinha ,imc, anoNascimento, validaMundial, ImpostoRenda,SaldoEmDolar);

            return ResponseEntity.ok(resumo);
        }


        return ResponseEntity.badRequest().body("Erro na solicitação");

    }

    private PessoaResponse complementarRespostaFrontEnd(PessoaRequest Pessoa,String imc, int anoNascimento, String validaMundial, String impostoRenda, String saldoEmDolar){

        PessoaResponse response = new PessoaResponse();

        response.setNome(Pessoa.getNome());//talvez nao funciona tem um get and setter criado no campo pessoa request
        response.setSalario(impostoRenda);
        response.setAnoNascimento(AnoNascimento);
        return response;
    } //Resposta do front end.

    //Calculo do de converçao do imposto de renda

    private String converteSaldoEmDolar(double saldo){
        return String.valueOf(saldo / 5.11);
    }

    private String calculaMundial(String time) {
        String mundial = "Palmeiras";
        String calculamundial;
        if (time.equalsIgnoreCase(mundial)) {
            calculamundial = "O time " + time + " tem mundial";
        } else {
            calculamundial = "O time " + time + " chora bebe";
        }
        return calculamundial;
    }// O Palmeiras tem mundial


    private String calculaFaixaImpostoRenda(double salario) {
        if (salario <= 1903) {
            return "Isento de imposto de renda";
        } else if (salario <= 2826) {
            return "Alíquota de 7,5%";
        } else if (salario <= 3751) {
            return "Alíquota de 15%";
        } else if (salario <= 4664) {
            return "Alíquota de 22,5%";
        } else {
            return "Alíquota de 27,5%";
        }
    }//metodo para cacular a faixa de imposto

    private int calculaAnoNascimento(int idade) {
        int anoAtual = 2023;
        int anoNascimento = anoAtual - idade;
        return anoNascimento;
    } // metodo para calcular ano de nascimento


    private String calculaImc( int peso, int altura) {
    double imc = peso / (altura*altura);

        if(imc < 18.5){
           return " O IMC calculado é:"+ imc + "e voce é magro!";
         }else if (imc > 18.5 && imc <= 29.9) {
            return "o imc caclculado é:" + imc + " e voce esta no peso ideal";
        }else if (imc > 24.9 && imc <= 29.9 ){
           return "o imc caclculado é:" + imc + " e voce esta gordo";
        } else if (imc > 29.9 && imc <= 34.9) {
            return "o imc caclculado é:" + imc + " e voce esta gordo nivel 2 ";
        } else if (imc > 34.9 && imc < 39.9) {
            return "o imc caclculado é:" + imc + " e voce esta gordo  nivel 3";
        } else{
            return "o imc caclculado é:" + imc + " e voce esta gordo  nivel 4";
        }
    }
}



