package com.example.alexalves.vestibulapp.Entidades;

/**
 * Created by Desenvolvedor on 04/11/2016.
 */

public class Inscricao {

    private int idInscricao;
    private int idCurso;
    private int idVestibular;
    private int idCandidato;
    private String lingua;

    public Inscricao(){

    }

    private static Inscricao holder;

    public int getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(int idInscricao) {
        this.idInscricao = idInscricao;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdVestibular() {
        return idVestibular;
    }

    public void setIdVestibular(int idVestibular) {
        this.idVestibular = idVestibular;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public static Inscricao getInscricao() {
        return holder;
    }

    public static void setInscricao(Inscricao holder) {
        Inscricao.holder = holder;
    }
}
