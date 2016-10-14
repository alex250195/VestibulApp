package com.example.alexalves.vestibulapp.Controles;

import android.util.Log;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Alex Alves on 14/09/2016.
 */
public class Validacao {
    public boolean ChecarCampo(String campo){
        if(campo.isEmpty()) return false;
        if(campo.startsWith(" ")) return false;
        if(campo.equals("")) return false;
        return true;
    }

    public boolean ChecarData(String data){
        Calendar cal = new GregorianCalendar();
        int anoAtual = cal.get(Calendar.YEAR);

        if(!ChecarCampo(data)) return false;
        if(data.length() != 10) return false;
        if(data.contains("/")) return true;

        String[] subData = data.split("/");

        if(Integer.parseInt(subData[0]) < 1 || Integer.parseInt(subData[0]) > 31) return false;
        if(Integer.parseInt(subData[1]) < 1 || Integer.parseInt(subData[1]) > 12) return false;
        if(Integer.parseInt(subData[2]) < 1900 || Integer.parseInt(subData[1]) > anoAtual) return false;

        return true;
    }

    public boolean ChecarCpf(String cpf){
        if(!ChecarCampo(cpf)) return false;

        String subCpf = cpf.replace(".", "");
        subCpf = subCpf.replace("-", "");

        Log.d("CPF", subCpf);

        if(subCpf.length() != 11) return false;

        int primeiroDigito = Integer.parseInt(subCpf.substring(0,1)) * 10 +
                Integer.parseInt(subCpf.substring(1,2)) * 9  +
                Integer.parseInt(subCpf.substring(2,3)) * 8  +
                Integer.parseInt(subCpf.substring(3,4)) * 7  +
                Integer.parseInt(subCpf.substring(4,5)) * 6  +
                Integer.parseInt(subCpf.substring(5,6)) * 5  +
                Integer.parseInt(subCpf.substring(6,7)) * 4  +
                Integer.parseInt(subCpf.substring(7,8)) * 3  +
                Integer.parseInt(subCpf.substring(8,9)) * 2;

        primeiroDigito = (primeiroDigito * 10) % 11;

        if(primeiroDigito != Integer.parseInt(subCpf.substring(9,10))) return false;

        int segundoDigito = Integer.parseInt(subCpf.substring(0,1)) * 11 +
                Integer.parseInt(subCpf.substring(1,2)) * 10 +
                Integer.parseInt(subCpf.substring(2,3)) * 9  +
                Integer.parseInt(subCpf.substring(3,4)) * 8  +
                Integer.parseInt(subCpf.substring(4,5)) * 7  +
                Integer.parseInt(subCpf.substring(5,6)) * 6  +
                Integer.parseInt(subCpf.substring(6,7)) * 5  +
                Integer.parseInt(subCpf.substring(7,8)) * 4  +
                Integer.parseInt(subCpf.substring(8,9)) * 3  +
                Integer.parseInt(subCpf.substring(9,10)) * 2;

        segundoDigito = (segundoDigito * 10) % 11;

        if(segundoDigito != Integer.parseInt(subCpf.substring(10)));

        return true;
    }
}
