package com.example.alexalves.vestibulapp.Entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Alex Alves on 14/09/2016.
 */
public class AtendimentoEspecifico implements Serializable {
    private String opcao;
    private ArrayList<String> atendimento;
    private String acordo;

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public ArrayList<String> getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(ArrayList<String> atendimento) {
        this.atendimento = atendimento;
    }

    public String getAcordo() {
        return acordo;
    }

    public void setAcordo(String acordo) {
        this.acordo = acordo;
    }
}
