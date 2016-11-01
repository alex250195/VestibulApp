package com.example.alexalves.vestibulapp.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.alexalves.vestibulapp.Portal_LoginActivity;
import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.Service;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by Desenvolvedor on 20/10/2016.
 */

public class LoginThread extends AsyncTask<Object, Object, String> {

    private static final String SOAP_ACTION = "urn:server.selectVerifyCandidato#selectVerifyCandidato";
    private static final String METHOD_NAME = "selectVerifyCandidato";
    private static final String NAMESPACE = "urn:server.selectVerifyCandidato";
    private String URL = Constants.HOST + "Candidato/SelectVerify.php";

    private Portal_LoginActivity context;
    private SoapPrimitive resp;

    private SoapObject soap;
    private SoapSerializationEnvelope envelope;
    private HttpTransportSE transportSE;

    private String cpf, senha;
    private Boolean resultado = false;

    public LoginThread(Portal_LoginActivity _context, String _cpf, String _senha){

        context = _context;
        cpf = _cpf;
        senha = _senha;

    }

    @Override
    protected String doInBackground(Object... params) {

        if(Service.isOnline(context)){ //verifica se tem conexao com a internet

            try{

                soap = new SoapObject(NAMESPACE, METHOD_NAME);

                PropertyInfo parametros = new PropertyInfo();
                parametros.setName("cpf");
                parametros.setValue(cpf.replace(".","").replace("-",""));
                parametros.setType(String.class);
                soap.addProperty(parametros);

                parametros = new PropertyInfo();
                parametros.setName("senha");
                parametros.setValue(senha);
                parametros.setType(String.class);
                soap.addProperty(parametros);
                //

                envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                //envelope.dotNet = true;
                envelope.setOutputSoapObject(soap);

                transportSE = new HttpTransportSE(URL);
                //transportSE.setTimeout(Constants.TimeOut);

                Log.e("ENVELOPE", envelope.toString());

                try {

                    transportSE.call(SOAP_ACTION, envelope);

                    String response = envelope.getResponse().toString();
                    if(response != null && response.equals("1")) {
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

        if(context != null){

            context.resultLogin(resultado);

        }

    }
}
