package com.example.alexalves.vestibulapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexalves.vestibulapp.Entidades.Candidato;
import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.Dialog;
import com.example.alexalves.vestibulapp.Util.Preferencias;
import com.example.alexalves.vestibulapp.Util.Service;
import com.example.alexalves.vestibulapp.threads.CandidatoUpdateSenhaThread;

public class Portal_SenhaActivity extends AppCompatActivity {

    Button btnProsseguir;
    EditText txtSenhaAtual, txtSenhaNova, txtSenhaNovaConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal__senha);

        btnProsseguir = (Button) findViewById(R.id.btnProsseguir);

        txtSenhaAtual = (EditText) findViewById(R.id.txtSenhaAtual);
        txtSenhaNova = (EditText) findViewById(R.id.txtSenhaNova);
        txtSenhaNovaConfirmar = (EditText) findViewById(R.id.txtSenhaNovaConfirmar);

        btnProsseguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                salvar();

            }
        });
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

    public void salvar(){

        String senhaAtual = txtSenhaAtual.getText().toString();
        String senhaNova = txtSenhaNova.getText().toString();
        String senhaNovaConfirmar = txtSenhaNovaConfirmar.getText().toString();

        if(senhaAtual.equals(Candidato.getCandidato().getSenha())){
            if(senhaNova.equals(senhaNovaConfirmar)){
                if(Service.isOnline(this)){

                    new CandidatoUpdateSenhaThread(this, Candidato.getCandidato().getCpf(), senhaNova).execute();

                }
            }else{
                Dialog.Show(this, "A nova senha não confere.", "Senha errada");
            }
        }else{
            Dialog.Show(this, "A senha atual não confere.", "Senha errada");
        }
    }

    public void result(String _novaSenha){

        if(_novaSenha != null){

            Toast.makeText(this, "Senha atualizada com sucesso", Toast.LENGTH_SHORT).show();

            Candidato.getCandidato().setSenha(_novaSenha);

            //atualiza a senha no aplicativo
            //salva o cpf e senha para fazer o login automatico na proxima execucao
            Preferencias preferencias = new Preferencias(this, Constants.appName);

            preferencias.begin();
            preferencias.putString(Constants.prefSenha, _novaSenha);
            preferencias.end();

            finish();
        }
    }
}
