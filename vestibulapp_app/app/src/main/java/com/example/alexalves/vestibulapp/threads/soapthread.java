package com.example.alexalves.vestibulapp.threads;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by Desenvolvedor on 13/09/2016.
 */
public class soapthread extends AsyncTask<Object, Object, String> {

    private String NAMESPACE = "http://www.oorsprong.org/websamples.countryinfo";
    private String METHOD_NAME = "CountryName";
    private String URL = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
    private String SOAP_ACTION = "http://webservices.oorsprong.org/websamples.countryinfo/CountryName";
    private int TimeOut = 30000;
    SoapPrimitive resp;

    private SoapObject soap;
    private SoapSerializationEnvelope envelope;
    private HttpTransportSE transportSE;
    TextView txt;

    public soapthread(TextView _txt){

        txt = _txt;

    }

    @Override
    protected String doInBackground(Object... objects) {

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
            transportSE.setTimeout(TimeOut);

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
        return null;
    }

    @Override
    protected void onPostExecute (String result){

        if(resp != null){
            txt.setText(resp.toString());
        }
    }
}
