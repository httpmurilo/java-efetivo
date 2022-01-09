package com.mercado;

import com.google.common.base.Stopwatch;
import com.mercado.model.Mochila;
import com.mercado.model.MochilaB;


public class Main {

    public static void main(String[] args) {
        defaultExample();
        builderExample();

    }

    private static void builderExample() {
        Stopwatch timer = Stopwatch.createStarted();
        MochilaB mochilaBuilder = new MochilaB
                                    .MochilaBuilder()
                                    .incluirMarca("adidas")
                                    .incluirCor("azul")
                                    .incluirModelo("profissional")
                                    .incluirEstilo("casual")
                                    .incluirBolsos("4")
                                    .incluirAlças("2")
                                    .incluirTamanho("Grande")
                                    .incluirZipers("4")
                                    .incluirChaveiros("2")
                                    .incluirDetalhes("disponivel em varios modelos")
                                    .incluirUsadaEm("ambientes casuais")
                                    .incluirQuantidadeQuilos(30)
                                    .incluirQtdCadernos(10)
                                    .build();

        timer.stop();
        System.out.println(String.format("Tempo de encerramento total padrão builder : %s", timer));
    }

    private static void defaultExample() {
        Stopwatch timer = Stopwatch.createStarted();
        Mochila mochila = new Mochila("Adidas","Verde","Escolar","Escolar","1","2",
                "20","2","1","10 kilos","sem","na ecola",2,2);
        timer.stop();
        System.out.println(String.format("Tempo de encerramento total : %s", timer));
    }

}
