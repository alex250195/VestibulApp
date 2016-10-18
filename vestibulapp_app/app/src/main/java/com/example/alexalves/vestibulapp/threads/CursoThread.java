package com.example.alexalves.vestibulapp.threads;

import android.os.AsyncTask;

import com.example.alexalves.vestibulapp.Inscricao_CursosActivity;
import com.example.alexalves.vestibulapp.Util.Service;

/**
 * Created by Desenvolvedor on 17/10/2016.
 */

public class CursoThread extends AsyncTask<Object, Object, String> {

    private Inscricao_CursosActivity context;

    public CursoThread(Inscricao_CursosActivity _context){

        context = _context;

    }

    @Override
    protected String doInBackground(Object... params) {

        if(Service.isOnline(context)){ //verifica se tem conexao com a internet


        }

        return null;
    }

    @Override
    protected void onPostExecute (String result){

        if(context != null){


        }

    }
}
