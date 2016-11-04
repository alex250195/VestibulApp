package com.example.alexalves.vestibulapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.alexalves.vestibulapp.Entidades.Candidato;
import com.example.alexalves.vestibulapp.Entidades.Vestibular;
import com.example.alexalves.vestibulapp.Util.DateCustom;
import com.example.alexalves.vestibulapp.threads.VestibularCandidatoThread;

import org.w3c.dom.Text;

public class Portal_AcompanharInscricaoActivity extends AppCompatActivity {

    TextView txtData, txtGabarito, txtClassificacao;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal__acompanhar_inscricao);

        txtData = (TextView) findViewById(R.id.txtProcessoDataProva);
        txtGabarito = (TextView) findViewById(R.id.txtProcessoGabarito);
        txtClassificacao = (TextView) findViewById(R.id.txtProcessoClassificacao);

        showProgressDialog("Carregando...");

        if(Vestibular.getVestibular() == null && Candidato.getCandidato() != null && Candidato.getCandidato().getInscricao() != null){ //verifica se os modelos contem dados
            new VestibularCandidatoThread(this, Candidato.getCandidato().getInscricao().getIdVestibular()).execute(); //recupera as informaçõe sobre o vestibular
        }else{
            result();
        }

    }

    @Override
    protected void onDestroy(){
        finish();

        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        finish();

        super.onBackPressed();
    }

    public void result(){

        if(Vestibular.getVestibular() != null){

            if(Vestibular.getVestibular().getDataProva() != null){
                txtData.setText(DateCustom.ToString(Vestibular.getVestibular().dataProva));
            }

            if(Vestibular.getVestibular().getGabarito() != null){
                txtGabarito.setText(Vestibular.getVestibular().getGabarito());
            }

            if(Vestibular.getVestibular().getResultadoClassificacao() != null){
                txtClassificacao.setText(Vestibular.getVestibular().getResultadoClassificacao());
            }
        }

        if(progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    private void showProgressDialog(String _mensagem){

        if(progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(_mensagem);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);

            progressDialog.show();
        }
    }
}
