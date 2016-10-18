package com.example.alexalves.vestibulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexalves.vestibulapp.Controles.Validacao;
import com.example.alexalves.vestibulapp.Entidades.Candidato;

import java.util.ArrayList;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

public class Inscricao_ContatoActivity extends AppCompatActivity {
    private Candidato candidato;
    private Validacao validacao = new Validacao();

    private EditText telefone;
    private EditText celular;
    private EditText confirmaCelular;
    private EditText email;
    private EditText confirmaEmail;

    private Button btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__contato);

        RecuperarDados();

        telefone = (EditText) findViewById(R.id.txtTelefone);
        celular = (EditText) findViewById(R.id.txtCelular);
        confirmaCelular = (EditText) findViewById(R.id.txtConfirmaCelular);
        email = (EditText) findViewById(R.id.txtEmail);
        confirmaEmail = (EditText) findViewById(R.id.txtConfirmaEmail);

        btnProximo = (Button) findViewById(R.id.btnProsseguir);

        Formatacao(telefone, celular, confirmaCelular);

        final ArrayList<String> dados = new ArrayList<String>();
        dados.add(telefone.getText().toString());
        dados.add(celular.getText().toString());
        dados.add(confirmaCelular.getText().toString());
        dados.add(email.getText().toString());
        dados.add(confirmaEmail.getText().toString());

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proximo(dados);
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    public void Formatacao(EditText telefone, EditText celular, EditText confirmaCelular){
        MaskEditTextChangedListener maskTEL = new MaskEditTextChangedListener("(##)####-####", telefone);
        telefone.addTextChangedListener(maskTEL);

        MaskEditTextChangedListener maskCEL = new MaskEditTextChangedListener("(##)#-####-####", celular);
        celular.addTextChangedListener(maskCEL);

        MaskEditTextChangedListener maskConfirmaCEL = new MaskEditTextChangedListener("(##)#-####-####", confirmaCelular);
        confirmaCelular.addTextChangedListener(maskConfirmaCEL);
    }

    public void RecuperarDados(){
        Intent intent = getIntent();
        this.candidato = (Candidato) intent.getSerializableExtra("candidato");
    }

    public void Proximo(ArrayList<String> dados){
        if(VerificarCampos(dados)){
            try{
                this.candidato.getContato().setTelefone(dados.get(0));
                this.candidato.getContato().setCelular(dados.get(1));
                this.candidato.getContato().setEmail(dados.get(3));

                Intent contato = new Intent(this, Inscricao_CredencialActivity.class);
                contato.putExtra("candidato", this.candidato);
                startActivity(contato);
            }catch (Exception ex){
                Toast.makeText(this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Erro", ex.getMessage());
            }
        }
    }

    public boolean VerificarCampos(ArrayList<String> contato){
        for (String var : contato){
            if(!validacao.ChecarCampo(var)){
                return false;
            }
        }

        if(!contato.get(1).contentEquals(contato.get(2))) return false;
        if(!contato.get(3).contentEquals(contato.get(4))) return false;

        return true;
    }
}
