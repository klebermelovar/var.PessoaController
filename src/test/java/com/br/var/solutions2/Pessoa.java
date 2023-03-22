package com.br.var.solutions2;

public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    float peso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}

