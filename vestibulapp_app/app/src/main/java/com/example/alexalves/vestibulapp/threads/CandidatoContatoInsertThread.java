package com.example.alexalves.vestibulapp.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.alexalves.vestibulapp.Entidades.Candidato;
import com.example.alexalves.vestibulapp.Entidades.Contato;
import com.example.alexalves.vestibulapp.Inscricao_CursosActivity;
import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.Service;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by Desenvolvedor on 02/11/2016.
 */

public class CandidatoContatoInsertThread extends AsyncTask<Object, Object, String> {

    private static final String SOAP_ACTION = "urn:server.insertContato#insertContato";
    private static final String METHOD_NAME = "insertContato";
    private static final String NAMESPACE = "urn:server.insertContato";
    private String URL = Constants.HOST + "Contato/Insert.php";

    private Inscricao_CursosActivity contextInscricao;
    private Context context;
    private Boolean resultado = false;

    private SoapPrimitive resp;

    private SoapObject soap;
    private SoapSerializationEnvelope envelope;
    private HttpTransportSE transportSE;

    public CandidatoContatoInsertThread(Inscricao_CursosActivity _context){

        contextInscricao = _context;
        context = contextInscricao;

    }

    public CandidatoContatoInsertThread(Context _context){

        context = _context;

    }

    @Override
    protected String doInBackground(Object... params) {

        if(Service.isOnline(context)){ //verifica se tem conexao com a internet

            try{

                soap = new SoapObject(NAMESPACE, METHOD_NAME);

                //soap.addProperty("nome", "NomeTeste");

                Contato contatoSalvar = Candidato.getCandidato().getContato();
                if(contatoSalvar.getIdCandidato() == 0) {
                    contatoSalvar.setIdCandidato(Candidato.getCandidato().getId());
                }
                contatoSalvar.getParametros(soap);

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

        if(resultado ) {

            //chama a ultima thread que salva a inscricao
            new InscricaoInsertThread(contextInscricao).execute();

        }else{

            contextInscricao.Resultado(resultado);

        }

    }
}
