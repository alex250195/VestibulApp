package com.example.alexalves.vestibulapp.Entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Alex Alves on 14/09/2016.
 */
public class AtendimentoEspecializado implements Serializable {
    private String opcao;
    private ArrayList<String> deficiencia;
    private String acordo;

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public ArrayList<String> getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(ArrayList<String> deficiencia) {
        this.deficiencia = deficiencia;
    }

    public String getAcordo() {
        return acordo;
    }

    public void setAcordo(String acordo) {
        this.acordo = acordo;
    }
}
