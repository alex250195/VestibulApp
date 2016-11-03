package com.example.alexalves.vestibulapp.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.alexalves.vestibulapp.Entidades.Curso;
import com.example.alexalves.vestibulapp.Inscricao_CursosActivity;
import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.Service;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Desenvolvedor on 17/10/2016.
 */

public class CursoSelectAllThread extends AsyncTask<Object, Object, String> {

    private static final String SOAP_ACTION = "urn:server.selectAllCurso#selectAllCurso";
    private static final String METHOD_NAME = "selectAllCurso";
    private static final String NAMESPACE = "urn:server.selectAllCurso";
    private String URL = Constants.HOST + "Curso/SelectAll.php";

    private Inscricao_CursosActivity contextInscricao;
    private Context context;
    private SoapPrimitive resp;

    private SoapObject soap;
    private SoapSerializationEnvelope envelope;
    private HttpTransportSE transportSE;

    public CursoSelectAllThread(Inscricao_CursosActivity _context){

        contextInscricao = _context;
        context = _context;

    }

    public CursoSelectAllThread(Context _context){

        context = _context;

    }

    @Override
    protected String doInBackground(Object... params) {

        if(Service.isOnline(context)){ //verifica se tem conexao com a internet

            try{

                soap = new SoapObject(NAMESPACE, METHOD_NAME);

                envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                //envelope.dotNet = true;
                envelope.setOutputSoapObject(soap);

                transportSE = new HttpTransportSE(URL);
                //transportSE.setTimeout(Constants.TimeOut);

                Log.e("ENVELOPE", envelope.toString());

                try {

                    transportSE.debug = true;
                    transportSE.call(SOAP_ACTION, envelope);

                    Vector<SoapObject> response = (Vector<SoapObject>) envelope.getResponse();

                    Curso.setCursos(new ArrayList<Curso>());

                    for (int i = 0; i < response.size(); i++) {
                        SoapObject tempObject = response.get(i);
                        if (tempObject != null) {
                            Curso temp = new Curso();

                            if(tempObject.hasProperty("id") && tempObject.getProperty("id") != null){temp.setId(Integer.parseInt(tempObject.getProperty("id").toString()));}
                            if(tempObject.hasProperty("id_instituicao") && tempObject.getProperty("id_instituicao") != null){ temp.setIdInstituicao(Integer.parseInt(tempObject.getProperty("id_instituicao").toString()));}
                            if(tempObject.hasProperty("nome") && tempObject.getProperty("nome") != null){temp.setNome(tempObject.getProperty("nome").toString());}
                            if(tempObject.hasProperty("descricao") && tempObject.getProperty("descricao") != null){temp.setDescricao((tempObject.getProperty("descricao").toString()));}

                            Curso.getCursos().add(temp);
                        }
                    }


                } catch (Exception e) {

                    Log.e("ERRO1", e.toString());
                    Log.e("ERRO1", e.getMessage());
                }
            }catch (Exception e){

                Log.e("ERRO2", e.toString());
            }

        }

        return null;
    }

    @Override
    protected void onPostExecute (String result){

        if(contextInscricao != null){

            contextInscricao.listaCursos();

        }

    }
}
