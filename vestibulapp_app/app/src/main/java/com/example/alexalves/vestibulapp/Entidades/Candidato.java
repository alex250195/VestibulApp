package com.example.alexalves.vestibulapp.Entidades;

import java.io.Serializable;

/**
 * Created by Alex Alves on 14/09/2016.
 */
public class Candidato implements Serializable {
    private String cpf;
    private String nascimento;
    private String nome;
    private String mae;
    private String raca;
    private String identidade;
    private String orgaoExpedidor;
    private String ufIdentidade;
    private String estadoCivil;
    private String nascionalidade;
    private String sexo;

    private Endereco endereco;
    private Contato contato;
    private AtendimentoEspecializado atendimentoEspecializado;
    private AtendimentoEspecifico atendimentoEspecifico;
    private Seguranca seguranca;
    private Escolaridade escolaridade;
    private Prova prova;

    public Candidato(){
        this.endereco = new Endereco();
        this.contato = new Contato();
        this.atendimentoEspecializado = new AtendimentoEspecializado();
        this.atendimentoEspecifico = new AtendimentoEspecifico();
        this.seguranca = new Seguranca();
        this.escolaridade = new Escolaridade();
        this.prova = new Prova();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public String getUfIdentidade() {
        return ufIdentidade;
    }

    public void setUfIdentidade(String ufIdentidade) {
        this.ufIdentidade = ufIdentidade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNascionalidade() {
        return nascionalidade;
    }

    public void setNascionalidade(String nascionalidade) {
        this.nascionalidade = nascionalidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public AtendimentoEspecializado getAtendimentoEspecializado() {
        return atendimentoEspecializado;
    }

    public AtendimentoEspecifico getAtendimentoEspecifico() {
        return atendimentoEspecifico;
    }

    public Seguranca getSeguranca() {
        return seguranca;
    }

    public Escolaridade getEscolaridade(){ return escolaridade; }

    public Prova getProva(){ return prova; }
}
