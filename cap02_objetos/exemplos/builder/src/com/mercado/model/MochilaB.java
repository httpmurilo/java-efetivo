package com.mercado.model;

public class MochilaB {

    private String marca;
    private String cor;
    private String modelo;
    private String estilo;
    private String bolsos;
    private String alças;
    private String tamanho;
    private String zipers;
    private String chaveiros;
    private String capacidade;
    private String detalhes;
    private String usadaem;
    private Integer cabeQtsCadernos;
    private Integer aguentaQtsQuilos;
    private MochilaB() {
    }

    public static class MochilaBuilder {
        private String marca;
        private String cor;
        private String modelo;
        private String estilo;
        private String bolsos;
        private String alças;
        private String tamanho;
        private String zipers;
        private String chaveiros;
        private String capacidade;
        private String detalhes;
        private String usadaem;
        private Integer cabeQtsCadernos;
        private Integer aguentaQtsQuilos;

        public MochilaBuilder incluirMarca(String marca) {
            this.marca = marca;
            return this;
        }

        public MochilaBuilder incluirCor(String cor) {
            this.cor = cor;
            return this;
        }

        public MochilaBuilder incluirModelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public MochilaBuilder incluirEstilo(String estilo) {
            this.estilo = estilo;
            return this;
        }

        public MochilaBuilder incluirBolsos(String bolsos) {
            this.bolsos = bolsos;
            return this;
        }

        public MochilaBuilder incluirAlças(String alças) {
            this.alças = alças;
            return this;
        }

        public MochilaBuilder incluirTamanho(String tamanho) {
            this.tamanho = tamanho;
            return this;
        }

        public MochilaBuilder incluirZipers(String zipers) {
            this.zipers = zipers;
            return this;
        }

        public MochilaBuilder incluirChaveiros(String chaveiros) {
            this.chaveiros = chaveiros;
            return this;
        }

        public MochilaBuilder incluirCapacidade(String capacidade) {
            this.capacidade = capacidade;
            return this;
        }

        public MochilaBuilder incluirDetalhes(String detalhes) {
            this.capacidade = capacidade;
            return this;
        }

        public MochilaBuilder incluirUsadaEm(String usadaem) {
            this.usadaem = usadaem;
            return this;
        }

        public MochilaBuilder incluirQtdCadernos(Integer cabeQtsCadernos) {
            this.cabeQtsCadernos = cabeQtsCadernos;
            return this;
        }

        public MochilaBuilder incluirQuantidadeQuilos(Integer aguentaQtsQuilos) {
            this.aguentaQtsQuilos = aguentaQtsQuilos;
            return this;
        }

        public MochilaB build() {
            MochilaB mochilaB = new MochilaB();
            mochilaB.marca = this.marca;
            mochilaB.cor = this.cor;
            mochilaB.modelo = this.modelo;
            mochilaB.estilo = this.estilo;
            mochilaB.bolsos = this.bolsos;
            mochilaB.alças = this.alças;
            mochilaB.tamanho = this.tamanho;
            mochilaB.zipers = this.zipers;
            mochilaB.chaveiros = this.chaveiros;
            mochilaB.capacidade = this.capacidade;
            mochilaB.detalhes = this.detalhes;
            mochilaB.usadaem = this.usadaem;
            mochilaB.cabeQtsCadernos = this.cabeQtsCadernos;
            mochilaB.aguentaQtsQuilos = this.aguentaQtsQuilos;

            return mochilaB;
        }
    }
}
