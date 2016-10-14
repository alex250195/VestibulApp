package com.example.alexalves.vestibulapp.Entidades;

import java.io.Serializable;

/**
 * Created by Alex Alves on 14/09/2016.
 */
public class Contato implements Serializable {
    private String telefone;
    private String celular;
    private String email;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
