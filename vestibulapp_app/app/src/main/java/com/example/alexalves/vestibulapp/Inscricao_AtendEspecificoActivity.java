package com.example.alexalves.vestibulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.alexalves.vestibulapp.Entidades.Candidato;

public class Inscricao_AtendEspecificoActivity extends AppCompatActivity {
    private Candidato candidato;

    private RadioButton sim;
    private RadioButton nao;

    private Button proximo;

    private int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__atend_especifico);

        RecuperarDados();

        CheckNao();

        sim = (RadioButton) findViewById(R.id.rbSim);
        nao = (RadioButton) findViewById(R.id.rbNao);

        proximo  = (Button) findViewById(R.id.btnProsseguir);

        sim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckSim();
            }
        });

        nao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckNao();
            }
        });

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proximo();
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    public void RecuperarDados(){
        Intent intent = getIntent();
        this.candidato = (Candidato) intent.getSerializableExtra("candidato");
    }

    public void CheckNao(){
        this.flag = 1;
    }

    public void CheckSim(){
        this.flag = 0;
    }

    public void Proximo(){
        if(this.flag == 0){
            try{
                this.candidato.getAtendimentoEspecifico().setOpcao("Sim");

                Intent especifico = new Intent(this, Inscricao_TipoAtendEspecificoActivity.class);
                especifico.putExtra("candidato", this.candidato);
                startActivity(especifico);
            } catch (Exception ex){
                Toast.makeText(this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Erro", ex.getMessage());
            }
        }
        else{
            try{
                this.candidato.getAtendimentoEspecifico().setOpcao("Não");

                Intent proximo = new Intent(this, Inscricao_ConfirmarDadoActivity.class);
                proximo.putExtra("candidato", this.candidato);
                startActivity(proximo);
            } catch (Exception ex){
                Toast.makeText(this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Erro", ex.getMessage());
            }
        }
    }
}
