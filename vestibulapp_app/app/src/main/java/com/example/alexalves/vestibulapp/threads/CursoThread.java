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

public class CursoThread extends AsyncTask<Object, Object, String> {

    private String NAMESPACE = Constants.HOST + "Curso/urn:server.selectAllCurso";
    private String METHOD_NAME = "selectAllCurso";
    private String URL = Constants.HOST + "Curso/SelectAll.php";
    private String SOAP_ACTION = Constants.HOST + "Curso/urn:server.selectAllCurso#selectAllCurso";

    private Context context;
    private SoapPrimitive resp;

    private SoapObject soap;
    private SoapSerializationEnvelope envelope;
    private HttpTransportSE transportSE;

    public CursoThread(Context _context){

        context = _context;

    }

    @Override
    protected String doInBackground(Object... params) {

        if(Service.isOnline(context)){ //verifica se tem conexao com a internet

            try{

                soap = new SoapObject(NAMESPACE, METHOD_NAME);

                PropertyInfo p1 = new PropertyInfo();
                p1.setName("sCountryISOCode");
                p1.setValue("AF");
                p1.setType(String.class);
                soap.addProperty(p1);

                envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(soap);

                transportSE = new HttpTransportSE(URL);
                transportSE.setTimeout(Constants.TimeOut);

                Log.e("ENVELOPE", envelope.toString());

                try {

                    transportSE.call(SOAP_ACTION, envelope);

                    resp = (SoapPrimitive) envelope.getResponse();
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
