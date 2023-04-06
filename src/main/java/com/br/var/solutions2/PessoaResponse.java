package com.br.var.solutions2;

public class PessoaResponse {
    public int AnoNascimento;
    public  String imc;
    public String IR;

    public int getAnoNascimento() {
        return AnoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.AnoNascimento = anoNascimento;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String salario;
    public int altura;
    public  String saldo;
}
