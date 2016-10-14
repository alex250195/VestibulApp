package com.example.alexalves.vestibulapp.Entidades;

import java.io.Serializable;

/**
 * Created by Alex Alves on 14/09/2016.
 */
public class Prova implements Serializable {
    private String linguaEstrangeira;
    private String curso;
    private String descricao;

    public String getLinguaEstrangeira() {
        return linguaEstrangeira;
    }

    public void setLinguaEstrangeira(String linguaEstrangeira) {
        this.linguaEstrangeira = linguaEstrangeira;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
