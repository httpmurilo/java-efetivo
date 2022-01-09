package com.escola.dominio.entidade;

public class AlunoSM {

    public static AlunoSM criarComNotaDeCorteDivisaoPadrao(String nome, Integer idade, String cidade){
        return new AlunoSM(nome,idade,cidade,7.0,4);
    }
    //tradicional
    private AlunoSM(String nome, Integer idade, String cidade, double notaDeCorte, Integer dividirPor) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.notaDeCorte = notaDeCorte;
        this.dividirPor = dividirPor;
    }
    //getters e setters
    private String nome;
    private Integer idade;
    private String cidade;
    private double notaDeCorte;
    private Integer dividirPor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getNotaDeCorte() {
        return notaDeCorte;
    }

    public void setNotaDeCorte(double notaDeCorte) {
        this.notaDeCorte = notaDeCorte;
    }

    public Integer getDividirPor() {
        return dividirPor;
    }

    public void setDividirPor(Integer dividirPor) {
        this.dividirPor = dividirPor;
    }
}
