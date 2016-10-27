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

public class Inscricao_AtendEspecializadoActivity extends AppCompatActivity {

    private RadioButton sim;
    private RadioButton nao;

    private Button proximo;

    private int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__atend_especializado);


        CheckNao();

        sim = (RadioButton) findViewById(R.id.rbSim);
        nao = (RadioButton) findViewById(R.id.rbNao);

        proximo = (Button) findViewById(R.id.btnProsseguir);

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

        RecuperarDados();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    public void RecuperarDados(){
        if(Candidato.getCandidato() != null){

            if(Candidato.getCandidato().getAtendimentoEspecializado() != null){
                if(Candidato.getCandidato().getAtendimentoEspecializado().getOpcao() != null && Candidato.getCandidato().getAtendimentoEspecializado().getOpcao().toLowerCase().equals("sim")){
                    sim.setSelected(true);
                }else{
                    nao.setSelected(true);
                }
            }
        }
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

                Candidato.getCandidato().getAtendimentoEspecializado().setOpcao("Sim");

                Intent especializado = new Intent(this, Inscricao_TipoAtendEspecializadoActivity.class);
                startActivity(especializado);

            } catch (Exception ex){
                Toast.makeText(this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Erro", ex.getMessage());
            }
        }
        else{
            try{

                Candidato.getCandidato().getAtendimentoEspecializado().setOpcao("Não");

                Intent proximo = new Intent(this, Inscricao_AtendEspecificoActivity.class);
                startActivity(proximo);

            } catch (Exception ex){
                Toast.makeText(this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Erro", ex.getMessage());
            }
        }
    }
}
