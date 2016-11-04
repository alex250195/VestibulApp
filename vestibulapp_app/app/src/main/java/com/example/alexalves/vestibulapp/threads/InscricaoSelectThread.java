package com.example.alexalves.vestibulapp.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.alexalves.vestibulapp.Entidades.Candidato;
import com.example.alexalves.vestibulapp.Entidades.Inscricao;
import com.example.alexalves.vestibulapp.Inscricao_CursosActivity;
import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.Service;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.Vector;

/**
 * Created by Desenvolvedor on 20/10/2016.
 */

public class InscricaoSelectThread extends AsyncTask<Object, Object, String> {

    private static final String SOAP_ACTION = "urn:server.selectBySpecificationInscricao#selectBySpecificationInscricao";
    private static final String METHOD_NAME = "selectBySpecificationInscricao";
    private static final String NAMESPACE = "urn:server.selectBySpecificationInscricao";
    private String URL = Constants.HOST + "Inscricao/SelectBySpecification.php";

    private Inscricao_CursosActivity contextInscricao;
    private Context context;
    private SoapPrimitive resp;

    private SoapObject soap;
    private SoapSerializationEnvelope envelope;
    private HttpTransportSE transportSE;

    private Inscricao inscricaoResult;

    private int idVestibular, idCandidato;

    public InscricaoSelectThread(Inscricao_CursosActivity _context){

        contextInscricao = _context;
        context = _context;

    }

    public InscricaoSelectThread(Context _context, int _idVestibular, int _idCandidato){

        context = _context;

        idVestibular = _idVestibular;
        idCandidato = _idCandidato;

    }

    @Override
    protected String doInBackground(Object... params) {

        if(Service.isOnline(context)){ //verifica se tem conexao com a internet

            try{

                SoapObject soap = new SoapObject(NAMESPACE, METHOD_NAME);

                PropertyInfo parametros = new PropertyInfo();
                parametros.setName("id_candidato");
                parametros.setValue(idCandidato);
                parametros.setType(String.class);
                soap.addProperty(parametros);

                parametros = new PropertyInfo();
                parametros.setName("id_vestibular");
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

                                Inscricao temp = new Inscricao();

                                if (tempObject.hasProperty("id_inscricao") && tempObject.getProperty("id_inscricao") != null) {
                                    temp.setIdInscricao(Integer.parseInt(tempObject.getProperty("id_inscricao").toString()));
                                }

                                if (tempObject.hasProperty("id_vestibular") && tempObject.getProperty("id_vestibular") != null) {
                                    temp.setIdVestibular(Integer.parseInt(tempObject.getProperty("id_vestibular").toString()));
                                }

                                if (tempObject.hasProperty("id_curso") && tempObject.getProperty("id_curso") != null) {
                                    temp.setIdCurso(Integer.parseInt(tempObject.getProperty("id_curso").toString()));
                                }

                                if (tempObject.hasProperty("id_candidato") && tempObject.getProperty("id_candidato") != null) {
                                    temp.setIdCandidato(Integer.parseInt(tempObject.getProperty("id_candidato").toString()));
                                }

                                if (tempObject.hasProperty("lingua") && tempObject.getProperty("lingua") != null) {
                                    temp.setLingua((tempObject.getProperty("lingua").toString()));
                                }

                                Inscricao.setInscricao(temp);

                                if(Candidato.getCandidato() != null){
                                    Candidato.getCandidato().setInscricao(temp);
                                }
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


        }

    }
}
