package com.example.alexalves.vestibulapp.Util;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Desenvolvedor on 18/10/2016.
 */

public class Constants {

    public static String HOST = "http://vestibulapp.esy.es/vestibulapp_service/VestibulApp.Service/";

    public static int TimeOut = 30000;

    public static LatLng getPosicaoUniversidade(){
        return new LatLng(-20.055901, -44.571345);
    }

    public static String AtendimentoEspecial = "/AtendimentoEspecial";
    public static String AtendimentoEspecifico = "/AtendimentoEspecifico";
    public static String Candidato = "/Candidato";
    public static String Contato = "/Contato";
    public static String Curso = "/Curso";
    public static String Endereco = "/Endereco";
    public static String Instituicao = "/Instituicao";
    public static String Usuario = "/Usuario";
    public static String Vestibular = "/Vestibular";
    public static String VestibularCurso = "/VestibularCurso";

    public static String appName = "VestibularApp";
    public static String prefCpf = "CFP";
    public static String prefSenha = "SENHA";

}
