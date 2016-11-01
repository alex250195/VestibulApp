package com.example.alexalves.vestibulapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alexalves.vestibulapp.Entidades.Candidato;

public class Portal_InformacaoPessoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal__informacao_pessoal);

        carregarInformacoes();

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

    private void carregarInformacoes(){

        if(Candidato.getCandidato() != null){


        }
    }
}
