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
 * Created by Desenvolvedor on 17/10/2016.
 */

public class LoginThread extends AsyncTask<Object, Object, String> {

    private static final String SOAP_ACTION = "urn:server.selectBySpecificationUsuario#selectBySpecificationUsuario";
    private static final String METHOD_NAME = "selectBySpecificationUsuario";
    private static final String NAMESPACE = "urn:server.selectBySpecificationUsuario";
    private String URL = Constants.HOST + "Usuario/SelectBySpecification.php";

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

                //region parametros de entrada
                PropertyInfo parametros = new PropertyInfo();

                parametros.setName("cpf");
                parametros.setValue(cpf);
                parametros.setType(String.class);

                soap.addProperty(parametros);

                parametros.setName("senha");
                parametros.setValue(senha);
                parametros.setType(String.class);

                soap.addProperty(parametros);
                //endregion

                envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                //envelope.dotNet = true;
                envelope.setOutputSoapObject(soap);

                transportSE = new HttpTransportSE(URL);
                //transportSE.setTimeout(Constants.TimeOut);

                Log.e("ENVELOPE", envelope.toString());

                try {

                    transportSE.call(SOAP_ACTION, envelope);

                    Object response = envelope.getResponse();
                    if(response != null) {
                        resp = (SoapPrimitive) envelope.getResponse();
                    }
                    //SoapObject resp = (SoapObject) envelope.bodyIn;


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
