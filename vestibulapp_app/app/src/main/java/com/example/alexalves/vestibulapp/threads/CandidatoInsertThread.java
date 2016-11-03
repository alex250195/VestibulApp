package com.example.alexalves.vestibulapp.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.alexalves.vestibulapp.Entidades.Candidato;
import com.example.alexalves.vestibulapp.Inscricao_CursosActivity;
import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.Service;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by Desenvolvedor on 27/10/2016.
 */

public class CandidatoInsertThread extends AsyncTask<Object, Object, String> {

    private static final String SOAP_ACTION = "urn:server.insertCandidato#insertCandidato";
    private static final String METHOD_NAME = "insertCandidato";
    private static final String NAMESPACE = "urn:server.insertCandidato";
    private String URL = Constants.HOST + "Candidato/Insert.php";
    private String idCandidato;

    private Inscricao_CursosActivity contextInscricao;
    private Context context;
    private Boolean resultado = false;

    private SoapPrimitive resp;

    private SoapObject soap;
    private SoapSerializationEnvelope envelope;
    private HttpTransportSE transportSE;

    public CandidatoInsertThread(Inscricao_CursosActivity _context){

        contextInscricao = _context;
        context = contextInscricao;

    }

    public CandidatoInsertThread(Context _context){

        context = _context;

    }

    @Override
    protected String doInBackground(Object... params) {

        if(Service.isOnline(context)){ //verifica se tem conexao com a internet

            try{

                soap = new SoapObject(NAMESPACE, METHOD_NAME);

                //soap.addProperty("nome", "NomeTeste");

                Candidato.getCandidato().getParametros(soap);

                envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                //envelope.dotNet = true;
                envelope.setOutputSoapObject(soap);

                transportSE = new HttpTransportSE(URL);
                //transportSE.setTimeout(Constants.TimeOut);

                Log.e("ENVELOPE", envelope.toString());

                try {

                    transportSE.call(SOAP_ACTION, envelope);

                    String response = envelope.getResponse().toString();
                    if(response != null && !response.equals("false")) {
                        idCandidato = response.split(":")[1].trim();
                        resultado = true;
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

        if(contextInscricao != null && resultado){

            if(idCandidato != null && !idCandidato.equals("")){
                Candidato.getCandidato().setId(Integer.parseInt(idCandidato));
                //salva o endereço do candidato
                new CandidatoEnderecoInsertThread(contextInscricao).execute();
            }

        }else{
            contextInscricao.Resultado(resultado);
        }

    }
}
