package com.senac.vitor.model;

import com.senac.vitor.helpers.Constantes;

public class AlunoBO {
    public static boolean validarNome(String nome){
        return nome!=null && !nome.equals("");
    }

    public static boolean validarNota(Double nota){
        return nota!=null && nota>=0 && nota<=10;
    }

    public static Double calcularMedia(Aluno aluno){
        return(aluno.getNota1()+aluno.getNota2())/2;
    }

    public static boolean verificarAprovacao(Aluno aluno){
        Double media = AlunoBO.calcularMedia(aluno);
        return media >= Constantes.MEDIA_APROVACAO;
    }
}
