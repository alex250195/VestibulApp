package com.example.alexalves.vestibulapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alexalves.vestibulapp.Entidades.Candidato;
import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.Dialog;
import com.example.alexalves.vestibulapp.Util.Preferencias;
import com.example.alexalves.vestibulapp.Util.Service;
import com.example.alexalves.vestibulapp.threads.CandidatoSelectBySpecificationThread;
import com.example.alexalves.vestibulapp.threads.LoginThread;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

public class Portal_LoginActivity extends AppCompatActivity {

    private Button btnAcessar;
    private EditText txtCpf, txtSenha;
    private ProgressDialog progressDialog;
    private Preferencias preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal__login);

        btnAcessar = (Button) findViewById(R.id.btnProsseguir);

        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            showProgressDialog("Aguarde...");

            String cpf = txtCpf.getText().toString();
            String senha = txtSenha.getText().toString();

            Acessar(cpf, senha);


            }
        });

        txtCpf = (EditText) findViewById(R.id.edtCpf);
        txtSenha = (EditText) findViewById(R.id.edtSenha);

        Formatacao(txtCpf);

        loginAutomatico();

    }

    public void Acessar(String _cpf, String _senha){

        String erro = null;

        if(Service.isOnline(this)) {

            //verifica os campos antes de chamar a thread de login
            if (_cpf.equals("")) {
                erro = "Informe seu número de cpf para continuar.";
            } else if (_senha.equals("")) {
                erro = "Informe sua senha.";
            }

            if (erro == null) {
                new LoginThread(this, _cpf, _senha).execute();
            } else {
                Dialog.Show(this, erro, "Login");
            }

        }else{
            Dialog.Show(Portal_LoginActivity.this, "Sem conexão com a Internet", "Sem conexão");
        }
    }

    public void resultLogin(Boolean _result){

        if(_result){

            //salva o cpf e senha para fazer o login automatico na proxima execucao
            if(preferencias == null){
                preferencias = new Preferencias(this, Constants.appName);
            }

            preferencias.begin();
            preferencias.putString(Constants.prefCpf, txtCpf.getText().toString() );
            preferencias.putString(Constants.prefSenha, txtSenha.getText().toString());
            preferencias.end();

            Candidato candidatologin = new Candidato();
            candidatologin.setCpf(txtCpf.getText().toString().replace(".","").replace("-",""));

            Candidato.setCandidato(candidatologin);
            Intent acessar = new Intent(this, Portal_AreaParticipanteActivity.class);
            startActivity(acessar);

            finish();

        }else{
            Dialog.Show(this, "Login inválido", "Login");
        }

        if(progressDialog != null) {
            progressDialog.dismiss();
        }

    }

    public void Formatacao(EditText cpf){

        MaskEditTextChangedListener maskCPF = new MaskEditTextChangedListener("###.###.###-##", cpf);

        cpf.addTextChangedListener(maskCPF);
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

    private void loginAutomatico(){

        if(preferencias == null){
            preferencias = new Preferencias(this, Constants.appName);
        }

        String cpf = preferencias.getString(Constants.prefCpf, null);
        String senha = preferencias.getString(Constants.prefSenha, null);

        txtCpf.setText(cpf);
        txtSenha.setText(senha);

        if(cpf != null && senha != null && !cpf.equals("") && !senha.equals("")){
            Acessar(cpf, senha);
        }
    }
}
