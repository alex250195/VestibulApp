package com.example.alexalves.vestibulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.alexalves.vestibulapp.Controles.Validacao;
import com.example.alexalves.vestibulapp.Entidades.Candidato;

import java.util.ArrayList;

public class Inscricao_EscolaridadeActivity extends AppCompatActivity {

    private Validacao validacao = new Validacao();

    private Spinner grau;
    private EditText instituicao;

    private Button proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__escolaridade);


        grau = (Spinner) findViewById(R.id.txtGrau);
        instituicao = (EditText) findViewById(R.id.txtInstituicaoEnsino);

        proximo = (Button) findViewById(R.id.btnProsseguir);

        Formatacao();



        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ArrayList<String> dados = new ArrayList<String>();
                dados.add(grau.getSelectedItem().toString());
                dados.add(instituicao.getText().toString());

                Proximo(dados);
            }
        });

        RecuperarDados();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    public void RecuperarDados(){

        if(Candidato.getCandidato() != null  && Candidato.getCandidato().getEscolaridade() != null){

            //grau.setSelection(Candidato.getCandidato().getEscolaridade());
            instituicao.setText(Candidato.getCandidato().getEscolaridade().getInstituicao());

        }
    }


    public void Formatacao(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.escolaridade, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        grau.setAdapter(adapter);
    }

    public void Proximo(ArrayList<String> dados){
        if(VerificarCampos(dados)) {

            try{

                Candidato.getCandidato().getEscolaridade().setGrau(dados.get(0));
                Candidato.getCandidato().getEscolaridade().setInstituicao(dados.get(1));

                Intent proximo = new Intent(this, Inscricao_LinguaActivity.class);
                startActivity(proximo);

            }catch (Exception ex){
                Toast.makeText(this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    public boolean VerificarCampos(ArrayList<String> dadosPessoais){
        for (String var : dadosPessoais){
            if(!validacao.ChecarCampo(var)){
                return false;
            }
        }
        return true;
    }
}
