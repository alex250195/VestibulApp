package com.example.alexalves.vestibulapp.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Desenvolvedor on 24/06/2016.
 */
public class DateCustom {

    public static Date ToDate(String _dataString){

        Date data = null;

        try{

            data = new SimpleDateFormat("yyyy-MM-dd").parse(_dataString);

        }catch (Exception e){
            e.printStackTrace();
        }

        return data; //retorna a data no formado yyyy-MM-dd
    }

    public static Date ToDate(String _dataString, String _format){

        Date data = null;

        try{

            SimpleDateFormat format = new SimpleDateFormat(_format);
            data = new java.sql.Date(format.parse(_dataString).getTime());

        }catch (Exception e){
            e.printStackTrace();
        }

        return data;
    }

    public static Date ConvertDate(String _date){

        Calendar cData = Calendar.getInstance();
        String separador = "";

        if(_date != null){
            if(_date.contains("/")){
                separador = "/";
            }else if(_date.contains("-")){
                separador = "-";
            }

            String ddate[] = _date.split(separador);

            if(ddate[0].length() == 2 && ddate[2].length() == 4){
                cData.set(IntegerCustom.toInteger(ddate[2]), (IntegerCustom.toInteger(ddate[1]) - 1), IntegerCustom.toInteger(ddate[0]));
            }else if(ddate[2].length() == 2 && ddate[0].length() == 4){
                cData.set(IntegerCustom.toInteger(ddate[0]), (IntegerCustom.toInteger(ddate[1]) - 1), IntegerCustom.toInteger(ddate[2]));
            }
        }

        return  cData.getTime();

    }

    public static Date FormatDate(Date _data, String _format){

        SimpleDateFormat dateFormat = new SimpleDateFormat(_format);
        return ToDate(dateFormat.format(_data), _format); //2013/10/15 16:16:39

    }

    public static Boolean IsValidDate(Date _dataString){

        return _dataString.after(new Date());
    }

    public static String ToString(Date _data){

        if(_data != null){

            try{

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                return format.format(_data);

            }catch (Exception e){
                e.printStackTrace();
            }

        }

        return "";
    }

    public static String ToString(Date _data, String _format){

        if(_data != null){

            try{

                SimpleDateFormat format = new SimpleDateFormat(_format);
                return format.format(_data);

            }catch (Exception e){
                e.printStackTrace();
            }

        }

        return "";
    }

    public static int getIdade(Date _day){

        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.setTime(_day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        return age;
    }

    public static String  getDiferencaMeses(Date _dateInitial, Date _dateFinal){

        Calendar dataInicial = Calendar.getInstance();
        Calendar dataFinal = Calendar.getInstance();

        dataInicial.setTime(_dateInitial);

        if(_dateFinal != null){
            dataFinal.setTime(_dateFinal);
        }

        int totalAnos = dataFinal.get(Calendar.YEAR) - dataInicial.get(Calendar.YEAR);
        int totalMeses = totalAnos * 12 + dataFinal.get(Calendar.MONTH) - dataInicial.get(Calendar.MONTH);

        int anos = totalMeses / 12;
        int meses = totalMeses - (anos * 12);

        String resultado = "";
        if(anos > 0){
            if(anos == 1) {
                resultado = anos + " ano ";
            }else{
                resultado = anos + " anos ";
            }
        }
        if(meses > 0){

            if(anos > 0){
                resultado += " e ";
            }

            if(meses == 1) {
                resultado += meses + " mês";
            }else{
                resultado += meses + " meses";
            }
        }
        return resultado;

    }

}
