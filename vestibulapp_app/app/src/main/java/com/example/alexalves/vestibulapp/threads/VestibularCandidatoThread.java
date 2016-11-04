package com.example.alexalves.vestibulapp.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.alexalves.vestibulapp.Entidades.Candidato;
import com.example.alexalves.vestibulapp.Entidades.Vestibular;
import com.example.alexalves.vestibulapp.Portal_AcompanharInscricaoActivity;
import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.DateCustom;
import com.example.alexalves.vestibulapp.Util.Service;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.Vector;

/**
 * Created by Desenvolvedor on 04/11/2016.
 */

public class VestibularCandidatoThread extends AsyncTask<Object, Object, String> {

    private static final String SOAP_ACTION = "urn:server.selectByIdVestibular#selectByIdVestibular";
    private static final String METHOD_NAME = "selectByIdVestibular";
    private static final String NAMESPACE = "urn:server.selectByIdVestibular";
    private String URL = Constants.HOST + "Vestibular/SelectById.php";

    private Portal_AcompanharInscricaoActivity contextActivity;
    private Context context;
    private SoapPrimitive resp;

    private SoapObject soap;
    private SoapSerializationEnvelope envelope;
    private HttpTransportSE transportSE;

    private int idVestibular;
    private Boolean resultado = false;

    public VestibularCandidatoThread(Portal_AcompanharInscricaoActivity _context, int _idVestibular){

        contextActivity = _context;
        context = _context;
        idVestibular = _idVestibular;

    }

    @Override
    protected String doInBackground(Object... params) {

        if(Service.isOnline(context)){ //verifica se tem conexao com a internet

            try{

                soap = new SoapObject(NAMESPACE, METHOD_NAME);

                PropertyInfo parametros = new PropertyInfo();
                parametros.setName("id");
                parametros.setValue(idVestibular);
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

                    Vector<SoapObject> response = (Vector<SoapObject>) envelope.getResponse();

                    if(response.size() == 1) {

                        SoapObject tempObject = response.get(0);

                        if (tempObject != null) {

                            //Candidato.setCandidato(new ArrayList<Candidato>());

                            if (tempObject != null) {
                                Vestibular temp = new Vestibular();

                                if (tempObject.hasProperty("id_vestibular") && tempObject.getProperty("id_vestibular") != null) {
                                    temp.setIdVestibular(Integer.parseInt(tempObject.getProperty("id_vestibular").toString()));
                                }
                                if (tempObject.hasProperty("id_instituicao") && tempObject.getProperty("id_instituicao") != null) {
                                    temp.setIdInstituicao(Integer.parseInt(tempObject.getProperty("id_instituicao").toString()));
                                }
                                if (tempObject.hasProperty("status") && tempObject.getProperty("status") != null) {
                                    temp.setStatus(tempObject.getProperty("status").toString());
                                }
                                if (tempObject.hasProperty("data_prova") &&  tempObject.getProperty("data_prova") != null) {
                                    temp.setDataProva(DateCustom.ConvertDate(tempObject.getProperty("data_prova").toString()));
                                }
                                if (tempObject.hasProperty("data_inscricao") && tempObject.getProperty("data_inscricao") != null) {
                                    temp.setDataInscricao(DateCustom.ConvertDate(tempObject.getProperty("data_inscricao").toString()));
                                }
                                if (tempObject.hasProperty("data_encerramento_inscricao") && tempObject.getProperty("data_encerramento_inscricao") != null) {
                                    temp.setDataEncerramentoInscricao(DateCustom.ConvertDate(tempObject.getProperty("data_encerramento_inscricao").toString()));
                                }
                                if (tempObject.hasProperty("data_resultado_gabarito") && tempObject.getProperty("data_resultado_gabarito") != null) {
                                    temp.setDataResultadoGabarito(DateCustom.ConvertDate(tempObject.getProperty("data_resultado_gabarito").toString()));
                                }
                                //if(tempObject.hasProperty("municipio_nascimento")){temp.setm((tempObject.getProperty("municipio_nascimento").toString()));}
                                if (tempObject.hasProperty("data_resultado_oficial") && tempObject.getProperty("data_resultado_oficial") != null) {
                                    temp.setDataResultadoOficial(DateCustom.ConvertDate(tempObject.getProperty("data_resultado_oficial").toString()));
                                }
                                //if(tempObject.hasProperty("escolaridade")){temp.setEscolaridade((tempObject.getProperty("escolaridade").toString()));}
                                if (tempObject.hasProperty("edital") && tempObject.getProperty("edital") != null) {
                                    temp.setEdital((tempObject.getProperty("edital").toString()));
                                }
                                if (tempObject.hasProperty("resultado_classificacao") && tempObject.getProperty("resultado_classificacao") != null) {
                                    temp.setResultadoClassificacao((tempObject.getProperty("resultado_classificacao").toString()));
                                }


                                Vestibular.setVestibular(temp);
                            }


                            //String response = envelope.getResponse().toString();
                            if (response != null && Candidato.getCandidato().getId() != 0) {
                                resultado = true;
                            }
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

        if(contextActivity != null){

            contextActivity.result();

        }

    }
}
