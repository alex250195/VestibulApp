package com.example.alexalves.vestibulapp.Entidades;

import java.io.Serializable;

/**
 * Created by Alex Alves on 14/09/2016.
 */
public class Escolaridade implements Serializable {
    private String grau;
    private String instituicao;

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
}
