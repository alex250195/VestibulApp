package com.example.alexalves.vestibulapp.Entidades;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.io.Serializable;

/**
 * Created by Alex Alves on 14/09/2016.
 */
public class Endereco implements Serializable {
    private String cep;
    private String endereco;
    private String complemento;
    private String numero;
    private String bairro;
    private String municipio;
    private String uf;

    private int id;
    private int idCandidato;

    public Endereco(){}

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void getParametros(SoapObject _soap){

        PropertyInfo parametros;

        parametros = new PropertyInfo();
        parametros.setName("idInstituicao");
        parametros.setValue(0);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("idCandidato");
        parametros.setValue(idCandidato);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("cep");
        parametros.setValue(cep);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("logradouro");
        parametros.setValue(endereco);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("domicilio");
        parametros.setValue("");
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("numero");
        parametros.setValue(numero);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("complemento");
        parametros.setValue(complemento);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("bairro");
        parametros.setValue(bairro);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("municipio");
        parametros.setValue(municipio);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("uf");
        parametros.setValue(uf);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

    }
}
