package com.senac.vitor.model;

public class Aluno {
    private String nome;
    private Double nota1;
    private Double nota2;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public void setNota1(String nota1) {
        try {
            this.nota1 = Double.parseDouble(nota1);
        } catch(Exception e){
            this.nota1 = null;
        }
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public void setNota2(String nota2) {
        try {
            this.nota2 = Double.parseDouble(nota2);
        } catch(Exception e){
            this.nota2 = null;
        }
    }

    public Aluno() {
    }

    public Aluno(String nome, Double nota1, Double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }



}
