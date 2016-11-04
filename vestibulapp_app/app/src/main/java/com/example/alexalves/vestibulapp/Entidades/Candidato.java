package com.example.alexalves.vestibulapp.Entidades;

import com.example.alexalves.vestibulapp.Util.DateCustom;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.io.Serializable;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by Alex Alves on 14/09/2016.
 */
public class Candidato implements Serializable, KvmSerializable {

    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public SoapObject getParametros(String namspace, String metodo){

        SoapObject soap = new SoapObject(namspace, metodo);
        PropertyInfo parametros;

        parametros = new PropertyInfo();
        parametros.setName("etnia");
        parametros.setValue(raca != null ? raca.replace(" ", "").toString(): "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("estadoCivil");
        parametros.setValue(estadoCivil != null ? estadoCivil.replace(" ", "").toString() : "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("sexo");
        parametros.setValue(sexo != null ? sexo.replace(" ", "").toString() : "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("cpf");
        parametros.setValue(cpf != null ? cpf.replace("-","").replace(".","").replace(" ", "").toString() : "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("identidade");
        parametros.setValue(identidade != null ? identidade.replace(" ", "").toString() : "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("orgaoExpedidor");
        parametros.setValue(orgaoExpedidor != null ? orgaoExpedidor.replace(" ", "").toString() : "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("ufIdentidade");
        parametros.setValue(ufIdentidade != null ? ufIdentidade.replace(" ", "").toString() : "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("nome");
        parametros.setValue(nome != null ? nome.replace(" ", "").toString() : "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("nomeMae");
        parametros.setValue(mae != null ? mae.replace(" ", "").toString() : "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);


        //recupera a string de data
        Date datacerta = DateCustom.ConvertDate(nascimento !=null ? nascimento.replace(" ", "").toString() : "null");
        if(datacerta != null){

            parametros = new PropertyInfo();
            parametros.setName("nascimento");
            parametros.setValue(DateCustom.ToString(datacerta, "yyyy-MM-dd").toString()); //data e altera o formato para yyyy-mm-dd
            parametros.setType(String.class);
            soap.addProperty(parametros);
        }

        parametros = new PropertyInfo();
        parametros.setName("nascionalidade");
        parametros.setValue(nascionalidade != null ? nascionalidade.replace(" ", "").toString(): "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("ufNasicmento");
        parametros.setValue(endereco != null && endereco.getUf() != null ? endereco.getUf().replace(" ", "").toString() : "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("municipioNascimento");
        parametros.setValue(endereco != null && endereco.getMunicipio() != null ? endereco.getMunicipio().replace(" ", "").toString(): "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("escolaridade");
        parametros.setValue(escolaridade != null && escolaridade.getGrau() != null ? escolaridade.getGrau().replace(" ", "").toString(): "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("senha");
        parametros.setValue(senha != null ? senha.replace(" ", "").toString(): "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        parametros = new PropertyInfo();
        parametros.setName("curso");
        parametros.setValue(curso != null ? curso.replace(" ", "").toString(): "null");
        parametros.setType(String.class);
        soap.addProperty(parametros);

        return soap;

    }

    @Override
    public Object getProperty(int i) {

        switch (i) {
            case 0:
                return this.id;

            case 1:
                return this.cpf;

            case 2:
                return this.nascimento;

            case 3:
                return this.nome;

            case 4:
                return this.mae;

            case 5:
                return this.raca;

            case 6:
                return this.identidade;

            case 7:
                return this.orgaoExpedidor;

            case 8:
                return this.ufIdentidade;

            case 9:
                return this.estadoCivil;

            case 10:
                return this.nascionalidade;

            case 11:
                return this.sexo;

            case 12:
                return this.senha;

            case 13:
                return this.curso;

            default:
                break;

        }

        return null;
    }

    @Override
    public int getPropertyCount() {
        return 14;
    }

    @Override
    public void setProperty(int i, Object value) {

        switch (i) {
            case 0:
                this.id = Integer.parseInt(value.toString());
                break;
            case 1:
                this.cpf = value.toString();
                break;
            case 2:
                this.nascimento = value.toString();
                break;
            case 3:
                this.nome = value.toString();
                break;
            case 4:
                this.mae = value.toString();
                break;
            case 5:
                this.raca = value.toString();
                break;
            case 6:
                this.identidade = value.toString();
                break;
            case 7:
                this.orgaoExpedidor = value.toString();
                break;
            case 8:
                this.ufIdentidade = value.toString();
                break;
            case 9:
                this.estadoCivil = estadoCivil.toString();
                break;
            case 10:
                this.nascionalidade = nascionalidade.toString();
                break;
            case 11:
                this.sexo = sexo.toString();
                break;
            case 12:
                this.senha = senha.toString();
                break;
            case 13:
                this.curso = curso.toLowerCase();
                break;

        }
    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo info) {

        switch (i) {

            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "id";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "cpf";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nascimento";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nome";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "mae";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "raca";

                break;
            case 6:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "identidade";
                break;
            case 7:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "orgaoExpedidor";
                break;
            case 8:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "ufIdentidade";
                break;
            case 9:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "estadoCivil";
                break;
            case 10:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nascionalidade";
                break;
            case 11:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "sexo";
                break;
            case 12:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "senha";
                break;
            case 13:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "curso";
                break;
        }
    }


}
