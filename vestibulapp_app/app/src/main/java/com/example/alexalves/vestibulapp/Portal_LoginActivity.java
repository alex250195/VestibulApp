package com.example.alexalves.vestibulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alexalves.vestibulapp.Util.Dialog;
import com.example.alexalves.vestibulapp.threads.LoginThread;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

public class Portal_LoginActivity extends AppCompatActivity {

    private Button btnAcessar;
    private EditText txtCpf, txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal__login);

        btnAcessar = (Button) findViewById(R.id.btnProsseguir);

        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Acessar();
            }
        });

        txtCpf = (EditText) findViewById(R.id.edtCpf);
        txtSenha = (EditText) findViewById(R.id.edtSenha);

        Formatacao(txtCpf);

    }

    public void Acessar(){

        String erro = null;
        String cpf = txtCpf.getText().toString();
        String senha = txtSenha.getText().toString();

        //verifica os campos antes de chamar a thread de login
        if(cpf.equals("")){
            erro = "Informe seu número de cpf para continuar.";
        }else if(senha.equals("")){
            erro = "Informe sua senha.";
        }

        if(erro == null) {
            new LoginThread(this, cpf, senha ).execute();
        }else{
            Dialog.Show(this, erro, "Login");
        }
    }

    public void resultLogin(Boolean _result){

        if(_result){

            Intent acessar = new Intent(this, Portal_AreaParticipanteActivity.class);
            startActivity(acessar);

            finish();

        }else{
            Dialog.Show(this, "Login inválido", "Login");
        }
    }

    public void Formatacao(EditText cpf){
        MaskEditTextChangedListener maskCPF = new MaskEditTextChangedListener("###.###.###-##", cpf);

        cpf.addTextChangedListener(maskCPF);
    }
}
