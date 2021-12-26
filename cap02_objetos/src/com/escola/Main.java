package com.escola;


import com.escola.dominio.entidade.Aluno;
import com.escola.dominio.entidade.AlunoSM;

public class Main {

    public static void main(String[] args) {

        //Exemplo Tradicional
        Aluno aluno = new Aluno("Marcos",10,"São Paulo", 7,4);
        Aluno aluno2 = new Aluno("Carol",10,"São Paulo", 7,4);
        Aluno aluno3 = new Aluno("João",12,"São Paulo", 7,4);

        //Exemplo com static method, promove a reutilização de código/construtor privado
        //Pontos positivos ; 1. Lógica fora do construtores, 2. Código mais limpo 3. Construtor mais coeso
        AlunoSM alunoSM = AlunoSM.criarComNotaDeCorteDivisaoPadrao("Antony",11,"Maranhão");
        AlunoSM alunoSM1 = AlunoSM.criarComNotaDeCorteDivisaoPadrao("Murilo", 14, "Itajai");

    }
}
