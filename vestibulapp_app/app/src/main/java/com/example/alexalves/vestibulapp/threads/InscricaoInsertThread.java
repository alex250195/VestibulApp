package com.example.alexalves.vestibulapp.threads;

import android.os.AsyncTask;

import com.example.alexalves.vestibulapp.Inscricao_CursosActivity;
import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.Service;

/**
 * Created by Desenvolvedor on 17/10/2016.
 */

public class InscricaoInsertThread extends AsyncTask<Object, Object, String> {

    private static final String SOAP_ACTION = "urn:server.insertInscricao#insertInscricao";
    private static final String METHOD_NAME = "insertInscricao";
    private static final String NAMESPACE = "urn:server.insertInscricao";
    private String URL = Constants.HOST + "Inscricao/Insert.php";

    private Inscricao_CursosActivity context;

    public InscricaoInsertThread(Inscricao_CursosActivity _context){

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
