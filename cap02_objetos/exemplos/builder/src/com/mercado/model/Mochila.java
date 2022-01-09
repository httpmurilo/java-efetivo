package com.mercado.model;

public class Mochila {

    public Mochila(String marca, String cor, String modelo, String estilo, String bolsos, String alças, String tamanho, String zipers, String chaveiros, String capacidade, String detalhes, String usadaEm, Integer cabeQtsCadernos, Integer aguentaQtsQuilos) {
        Marca = marca;
        Cor = cor;
        Modelo = modelo;
        Estilo = estilo;
        Bolsos = bolsos;
        Alças = alças;
        Tamanho = tamanho;
        Zipers = zipers;
        Chaveiros = chaveiros;
        Capacidade = capacidade;
        Detalhes = detalhes;
        UsadaEm = usadaEm;
        CabeQtsCadernos = cabeQtsCadernos;
        AguentaQtsQuilos = aguentaQtsQuilos;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String cor) {
        Cor = cor;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getEstilo() {
        return Estilo;
    }

    public void setEstilo(String estilo) {
        Estilo = estilo;
    }

    public String getBolsos() {
        return Bolsos;
    }

    public void setBolsos(String bolsos) {
        Bolsos = bolsos;
    }

    public String getAlças() {
        return Alças;
    }

    public void setAlças(String alças) {
        Alças = alças;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String tamanho) {
        Tamanho = tamanho;
    }

    public String getZipers() {
        return Zipers;
    }

    public void setZipers(String zipers) {
        Zipers = zipers;
    }

    public String getChaveiros() {
        return Chaveiros;
    }

    public void setChaveiros(String chaveiros) {
        Chaveiros = chaveiros;
    }

    public String getCapacidade() {
        return Capacidade;
    }

    public void setCapacidade(String capacidade) {
        Capacidade = capacidade;
    }

    public String getDetalhes() {
        return Detalhes;
    }

    public void setDetalhes(String detalhes) {
        Detalhes = detalhes;
    }

    public String getUsadaEm() {
        return UsadaEm;
    }

    public void setUsadaEm(String usadaEm) {
        UsadaEm = usadaEm;
    }

    public Integer getCabeQtsCadernos() {
        return CabeQtsCadernos;
    }

    public void setCabeQtsCadernos(Integer cabeQtsCadernos) {
        CabeQtsCadernos = cabeQtsCadernos;
    }

    public Integer getAguentaQtsQuilos() {
        return AguentaQtsQuilos;
    }

    public void setAguentaQtsQuilos(Integer aguentaQtsQuilos) {
        AguentaQtsQuilos = aguentaQtsQuilos;
    }

    private String Marca;
    private String Cor;
    private String Modelo;
    private String Estilo;
    private String Bolsos;
    private String Alças;
    private String Tamanho;
    private String Zipers;
    private String Chaveiros;
    private String Capacidade;
    private String Detalhes;
    private String UsadaEm;
    private Integer CabeQtsCadernos;
    private Integer AguentaQtsQuilos;
}
