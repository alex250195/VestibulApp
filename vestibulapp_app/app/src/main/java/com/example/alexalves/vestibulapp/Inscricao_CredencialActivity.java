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

public class Inscricao_CredencialActivity extends AppCompatActivity {
    private Candidato candidato;
    private Validacao validacao = new Validacao();

    private Button proximo;

    private EditText senha;
    private EditText confirmaSenha;
    private EditText pergunta;
    private EditText resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__credencial);

        RecuperarDados();

        senha = (EditText) findViewById(R.id.txtSenha);
        confirmaSenha = (EditText) findViewById(R.id.txtConfirmaSenha);
        pergunta = (EditText) findViewById(R.id.txtPergunta);
        resposta = (EditText) findViewById(R.id.txtResposta);

        proximo = (Button) findViewById(R.id.btnProsseguir);

        Teste(senha, confirmaSenha, pergunta, resposta);

        final ArrayList<String> dados = new ArrayList<String>();
        dados.add(senha.getText().toString());
        dados.add(confirmaSenha.getText().toString());
        dados.add(pergunta.getText().toString());
        dados.add(resposta.getText().toString());

        proximo.setOnClickListener(new View.OnClickListener() {
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

    public void Teste(EditText senha, EditText confirmaSenha, EditText perguta, EditText resposta){
        senha.setText("123456");
        confirmaSenha.setText("123456");
        perguta.setText("Idade Namorada");
        resposta.setText("20 anos");
    }

    public void RecuperarDados(){
        Intent intent = getIntent();
        this.candidato = (Candidato) intent.getSerializableExtra("candidato");
    }

    public void Proximo(ArrayList<String> dados){
        if(VerificarCampos(dados)){
            try {
                this.candidato.getSeguranca().setSenha(dados.get(0));
                this.candidato.getSeguranca().setPergunta(dados.get(2));
                this.candidato.getSeguranca().setResposta(dados.get(3));

                Intent quartaEtapa = new Intent(this, Inscricao_AtendEspecializadoActivity.class);
                quartaEtapa.putExtra("candidato", this.candidato);
                startActivity(quartaEtapa);
            } catch (Exception ex) {
                Toast.makeText(this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Erro", ex.getMessage());
            }
        }
    }

    public boolean VerificarCampos(ArrayList<String> dados){
        for (String var : dados){
            if(!validacao.ChecarCampo(var)){
                return false;
            }
        }

        if(!dados.get(0).contains(dados.get(1))) return false;

        return true;
    }
}
