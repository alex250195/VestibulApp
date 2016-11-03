package com.example.alexalves.vestibulapp.Entidades;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.io.Serializable;

/**
 * Created by Alex Alves on 14/09/2016.
 */
public class Contato implements Serializable {

    private int id;
    private int idCandidato;
    private String telefone;
    private String celular;
    private String email;

    public Contato(){}

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public void getParametros(SoapObject _soap){

        PropertyInfo parametros;

        parametros = new PropertyInfo();
        parametros.setName("id_instituicao");
        parametros.setValue(0);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("id_candidato");
        parametros.setValue(idCandidato);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("celular");
        parametros.setValue(celular);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("fixo");
        parametros.setValue(telefone);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("email");
        parametros.setValue(email);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

    }
}
