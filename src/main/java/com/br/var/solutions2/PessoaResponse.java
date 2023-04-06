package com.br.var.solutions2;

public class PessoaResponse {
    public  String imc;
    public String IR;
    public String classificacaoIMC;
    public String aliquota;
    public  String SaldoEmDolar;
    public String  time;
    public  String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
        this.imc = imc;
    }

    public String getIR() {
        return IR;
    }

    public void setIR(String IR) {
        this.IR = IR;
    }

    public String getClassificacaoIMC() {
        return classificacaoIMC;
    }

    public void setClassificacaoIMC(String classificacaoIMC) {
        this.classificacaoIMC = classificacaoIMC;
    }

    public String getAliquota() {
        return aliquota;
    }

    public void setAliquota(String aliquota) {
        this.aliquota = aliquota;
    }

    public String getSaldoEmDolar() {
        return SaldoEmDolar;
    }

    public void setSaldoEmDolar(String saldoEmDolar) {
        SaldoEmDolar = saldoEmDolar;
    }

    public String nome;
    public String sobrenome;
    public int idade;
    public int peso;
    public double salario;
    public int altura;
    public  double saldo;
}
