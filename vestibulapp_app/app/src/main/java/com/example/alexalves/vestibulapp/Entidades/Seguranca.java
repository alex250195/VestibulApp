package com.example.alexalves.vestibulapp.Entidades;

import java.io.Serializable;

/**
 * Created by Alex Alves on 14/09/2016.
 */
public class Seguranca implements Serializable {
    private String senha;
    private String pergunta;
    private String resposta;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
