package com.example.alexalves.vestibulapp.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.alexalves.vestibulapp.Entidades.Candidato;
import com.example.alexalves.vestibulapp.Entidades.Curso;
import com.example.alexalves.vestibulapp.Entidades.Vestibular;
import com.example.alexalves.vestibulapp.Portal_AreaParticipanteActivity;
import com.example.alexalves.vestibulapp.Portal_LoginActivity;
import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.Service;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Desenvolvedor on 20/10/2016.
 */

public class CandidatoSelectBySpecificationThread extends AsyncTask<Object, Object, String> {

    private static final String SOAP_ACTION = "urn:server.selectBySpecificationCandidato#selectBySpecificationCandidato";
    private static final String METHOD_NAME = "selectBySpecificationCandidato";
    private static final String NAMESPACE = "urn:server.selectBySpecificationCandidato";
    private String URL = Constants.HOST + "Candidato/SelectBySpecification.php";

    private Portal_AreaParticipanteActivity context;
    private SoapPrimitive resp;

    private SoapObject soap;
    private SoapSerializationEnvelope envelope;
    private HttpTransportSE transportSE;

    private String cpf;
    private Boolean resultado = false;

    public CandidatoSelectBySpecificationThread(Portal_AreaParticipanteActivity _context, String _cpf){

        context = _context;
        cpf = _cpf;

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
                                Candidato temp = new Candidato();

                                if (tempObject.hasProperty("id_candidato")) {
                                    temp.setId(Integer.parseInt(tempObject.getProperty("id_candidato").toString()));
                                }
                                if (tempObject.hasProperty("nome")) {
                                    temp.setNome(tempObject.getProperty("nome").toString());
                                }
                                if (tempObject.hasProperty("cpf")) {
                                    temp.setCpf(tempObject.getProperty("cpf").toString());
                                }
                                if (tempObject.hasProperty("sexo")) {
                                    temp.setSexo((tempObject.getProperty("sexo").toString()));
                                }
                                if (tempObject.hasProperty("identidade")) {
                                    temp.setIdentidade((tempObject.getProperty("identidade").toString()));
                                }
                                if (tempObject.hasProperty("nascimento")) {
                                    temp.setNascimento((tempObject.getProperty("nascimento").toString()));
                                }
                                if (tempObject.hasProperty("nascionalidade")) {
                                    temp.setNascionalidade((tempObject.getProperty("nascionalidade").toString()));
                                }
                                //if(tempObject.hasProperty("municipio_nascimento")){temp.setm((tempObject.getProperty("municipio_nascimento").toString()));}
                                if (tempObject.hasProperty("uf_nascimento")) {
                                    temp.setUfIdentidade((tempObject.getProperty("uf_nascimento").toString()));
                                }
                                //if(tempObject.hasProperty("escolaridade")){temp.setEscolaridade((tempObject.getProperty("escolaridade").toString()));}
                                if (tempObject.hasProperty("senha")) {
                                    temp.setSenha((tempObject.getProperty("senha").toString()));
                                }

                                Candidato.setCandidato(temp);
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

        if(context != null){
            context.result();


            if(Vestibular.getVestibular() != null && Candidato.getCandidato() != null) {
                //chama a thread que recupera as informaçoes da inscricao
                new InscricaoSelectThread(context, Vestibular.getVestibular().getIdVestibular(), Candidato.getCandidato().getId()).execute();
            }

        }

    }
}
