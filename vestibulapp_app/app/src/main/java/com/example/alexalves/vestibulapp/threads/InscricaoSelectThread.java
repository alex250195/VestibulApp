package com.example.alexalves.vestibulapp.threads;

import android.os.AsyncTask;

import com.example.alexalves.vestibulapp.Inscricao_CursosActivity;
import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.Service;

/**
 * Created by Desenvolvedor on 20/10/2016.
 */

public class InscricaoSelectThread extends AsyncTask<Object, Object, String> {

    private static final String SOAP_ACTION = "urn:server.selectBySpecificationInscricao#selectBySpecificationInscricao";
    private static final String METHOD_NAME = "selectBySpecificationInscricao";
    private static final String NAMESPACE = "urn:server.selectBySpecificationInscricao";
    private String URL = Constants.HOST + "Inscricao/SelectBySpecification.php";

    private Inscricao_CursosActivity context;

    public InscricaoSelectThread(Inscricao_CursosActivity _context){

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
