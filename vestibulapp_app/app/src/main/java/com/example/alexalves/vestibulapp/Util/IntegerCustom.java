package com.example.alexalves.vestibulapp.Util;

/**
 * Created by Desenvolvedor on 24/06/2016.
 */
public class IntegerCustom {

    public static Boolean IsInteger(String _int){

        if(_int != null && !_int.equals("")){

            try{
                Integer c = Integer.parseInt(_int);
                if(c > 0){
                    return true;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;

    }

    public static  Integer toInteger(String _int){

        if(_int != null && !_int.equals("")){

            try{
                return Integer.parseInt(_int);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return 0;
    }
}
