package com.example.alexalves.vestibulapp.Entidades;

import java.util.Date;

/**
 * Created by Desenvolvedor on 04/11/2016.
 */

public class Vestibular {

    public int idVestibular;
    public int idInstituicao;
    public String status;
    public Date dataProva;
    public Date dataInscricao;
    public Date dataEncerramentoInscricao;
    public Date dataResultadoGabarito;
    public Date dataResultadoOficial;
    public String edital;
    public String gabarito;
    public String resultadoClassificacao;

    private static Vestibular holder;

    public Vestibular(){

    }

    public static Vestibular getVestibular(){
        return holder;
    }

    public static void setVestibular(Vestibular _value){
        holder = _value;
    }

    public int getIdVestibular() {
        return idVestibular;
    }

    public void setIdVestibular(int idVestibular) {
        this.idVestibular = idVestibular;
    }

    public int getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public Date getDataEncerramentoInscricao() {
        return dataEncerramentoInscricao;
    }

    public void setDataEncerramentoInscricao(Date dataEncerramentoInscricao) {
        this.dataEncerramentoInscricao = dataEncerramentoInscricao;
    }

    public Date getDataResultadoGabarito() {
        return dataResultadoGabarito;
    }

    public void setDataResultadoGabarito(Date dataResultadoGabarito) {
        this.dataResultadoGabarito = dataResultadoGabarito;
    }

    public Date getDataResultadoOficial() {
        return dataResultadoOficial;
    }

    public void setDataResultadoOficial(Date dataResultadoOficial) {
        this.dataResultadoOficial = dataResultadoOficial;
    }

    public String getEdital() {
        return edital;
    }

    public void setEdital(String edital) {
        this.edital = edital;
    }

    public String getGabarito() {
        return gabarito;
    }

    public void setGabarito(String gabarito) {
        this.gabarito = gabarito;
    }

    public String getResultadoClassificacao() {
        return resultadoClassificacao;
    }

    public void setResultadoClassificacao(String resultadoClassificacao) {
        this.resultadoClassificacao = resultadoClassificacao;
    }
}
