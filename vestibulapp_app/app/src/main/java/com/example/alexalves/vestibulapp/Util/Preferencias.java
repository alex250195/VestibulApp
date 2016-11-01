package com.example.alexalves.vestibulapp.Util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by araújo on 09/06/2015.
 */
public class Preferencias {

    private SharedPreferences.Editor mEditor = null;
    private SharedPreferences mPreferences = null;

    //Contexto e nome do app
    public Preferencias(Context _activity, String _app){

        if(_activity != null){

            mPreferences = _activity.getSharedPreferences(_app, Context.MODE_PRIVATE);
            mEditor = mPreferences.edit();

        }
    }

    public Preferencias begin(){

        mEditor = mPreferences.edit();
        return this;

    }

    public void end(){

        mEditor.commit();

    }

    public Preferencias remove(String _chave){

        mEditor.remove(_chave);
        return this;

    }

    public boolean getBoolean(String _chave, boolean _valorPadrao){

        try{

            return mPreferences.getBoolean(_chave,  _valorPadrao);

        }catch (ClassCastException e){

            return _valorPadrao;

        }
    }

    public Integer getInteger(String _chave, Integer _valorPadrao){

        try{

            return mPreferences.getInt(_chave,  _valorPadrao);

        }catch (ClassCastException e){

            return _valorPadrao;

        }
    }

    public String getString(String _chave, String _valorPadrao){

        try{

            return mPreferences.getString(_chave,  _valorPadrao);

        }catch (ClassCastException e){

            return _valorPadrao;

        }
    }

    public Long getLong(String _chave){

        try{

            return mPreferences.getLong(_chave, 0);

        }catch (ClassCastException e){

            return 0L;

        }
    }

    public Float getFloat(String _chave, Float _valorPadrao){

        try{

            return mPreferences.getFloat(_chave, _valorPadrao);

        }catch (ClassCastException e){

            return _valorPadrao;

        }
    }

    public Double getDouble(String _chave){

        try{

            return Double.longBitsToDouble(getLong(_chave));

        }catch (ClassCastException e){

            return 0D;

        }
    }

    public Preferencias putDouble(String _chave, Double _valor){

        mEditor.putLong(_chave, Double.doubleToLongBits(_valor));
        return this;

    }

    public Preferencias putBoolean(String _chave, boolean _valor){

        mEditor.putBoolean(_chave, _valor);
        return this;

    }

    public Preferencias putLong(String _chave, Long _valor){

        mEditor.putLong(_chave, _valor);
        return this;

    }

    public Preferencias putString(String _chave, String _valor){

        mEditor.putString(_chave, _valor);
        return this;

    }

    public Preferencias putFloat(String _chave, Float _valor){

        mEditor.putFloat(_chave, _valor);
        return this;

    }

    public Preferencias putInteger(String _chave, Integer _valor){

        mEditor.putInt(_chave, _valor);
        return this;

    }

}
