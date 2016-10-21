package com.example.alexalves.vestibulapp.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.alexalves.vestibulapp.Inscricao_CursosActivity;
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

public class CursoSelectAllThread extends AsyncTask<Object, Object, String> {

    private static final String SOAP_ACTION = "urn:server.selectAllCurso#selectAllCurso";
    private static final String METHOD_NAME = "selectAllCurso";
    private static final String NAMESPACE = "urn:server.selectAllCurso";
    private String URL = Constants.HOST + "Curso/SelectAll.php";

    private Context context;
    private SoapPrimitive resp;

    private SoapObject soap;
    private SoapSerializationEnvelope envelope;
    private HttpTransportSE transportSE;

    public CursoSelectAllThread(Context _context){

        context = _context;

    }

    @Override
    protected String doInBackground(Object... params) {

        if(Service.isOnline(context)){ //verifica se tem conexao com a internet

            try{

                soap = new SoapObject(NAMESPACE, METHOD_NAME);

                //PropertyInfo p1 = new PropertyInfo();
                //p1.setName("sCountryISOCode");
                //p1.setValue("AF");
                //p1.setType(String.class);
                //soap.addProperty(p1);

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


        }

    }
}
