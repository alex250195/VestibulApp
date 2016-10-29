package com.example.alexalves.vestibulapp.Entidades;

import com.example.alexalves.vestibulapp.Util.DateCustom;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.io.Serializable;
import java.util.Date;

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
    private String senha;
    private String curso;

    private Endereco endereco;
    private Contato contato;
    private AtendimentoEspecializado atendimentoEspecializado;
    private AtendimentoEspecifico atendimentoEspecifico;
    private Seguranca seguranca;
    private Escolaridade escolaridade;
    private Prova prova;

    private static Candidato holder;

    public Candidato(){
        this.endereco = new Endereco();
        this.contato = new Contato();
        this.atendimentoEspecializado = new AtendimentoEspecializado();
        this.atendimentoEspecifico = new AtendimentoEspecifico();
        this.seguranca = new Seguranca();
        this.escolaridade = new Escolaridade();
        this.prova = new Prova();
    }

    public static void setCandidato(Candidato _value){
        holder = _value;
    }

    public static Candidato getCandidato(){
        return holder;
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

    public String getSenha(){ return senha; }

    public void setSenha(String _value){ this.senha = _value; }

    public String getCurso(){ return  this.curso; }

    public void setCurso(String _value){ this.curso= _value; }

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

    public void setEndereco(Endereco _value){
        this.endereco = _value;
    }

    public void setProva(Prova _value){
        this.prova = _value;
    }

    public void setContato(Contato _value){
        this.contato = _value;
    }

    public void setSeguranca(Seguranca _value){
        this.seguranca = _value;
    }

    public void setAtendimentoEspecializado(AtendimentoEspecializado _value){
        this.atendimentoEspecializado = _value;
    }

    public void setAtendimentoEspecifico(AtendimentoEspecifico _value){
        this.atendimentoEspecifico = _value;
    }

    public void setEscolaridade(Escolaridade _value){
        this.escolaridade = _value;
    }

    public void getParametros(SoapObject _soap){

        PropertyInfo parametros;

        parametros = new PropertyInfo();
        parametros.setName("etnia");
        parametros.setValue(raca);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("estadoCivil");
        parametros.setValue(estadoCivil);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("sexo");
        parametros.setValue(sexo);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("cpf");
        parametros.setValue(cpf.replace("-","").replace(".",""));
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("identidade");
        parametros.setValue(identidade);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("orgaoExpedidor");
        parametros.setValue(orgaoExpedidor);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("ufIdentidade");
        parametros.setValue(ufIdentidade);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("nome");
        parametros.setValue(nome);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("nomeMae");
        parametros.setValue(mae);
        parametros.setType(String.class);
        _soap.addProperty(parametros);


        //recupera a string de data
        Date datacerta = DateCustom.ConvertDate(nascimento);
        if(datacerta != null){

            parametros = new PropertyInfo();
            parametros.setName("nascimento");
            parametros.setValue(DateCustom.ToString(datacerta, "yyyy-MM-dd")); //data e altera o formato para yyyy-mm-dd
            parametros.setType(String.class);
            _soap.addProperty(parametros);
        }

        parametros = new PropertyInfo();
        parametros.setName("nascionalidade");
        parametros.setValue(nascionalidade);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("ufNasicmento");
        parametros.setValue(endereco.getUf());
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("municipioNascimento");
        parametros.setValue("Cidade");
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("escolaridade");
        parametros.setValue(escolaridade.getGrau());
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("senha");
        parametros.setValue(senha);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("curso");
        parametros.setValue(curso);
        parametros.setType(String.class);
        _soap.addProperty(parametros);

    }
}
