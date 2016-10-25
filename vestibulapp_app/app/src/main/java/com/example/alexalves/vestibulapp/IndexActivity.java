package com.example.alexalves.vestibulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alexalves.vestibulapp.Entidades.Candidato;
import com.example.alexalves.vestibulapp.threads.CursoSelectAllThread;

public class IndexActivity extends AppCompatActivity {
    private Candidato candidato;

    private Button btnOrientacao;
    private Button btnInscricao;
    private Button btnParticipante;
    private Button btnUit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        btnOrientacao = (Button) findViewById(R.id.btnOrientacao);
        btnInscricao = (Button) findViewById(R.id.btnInscricao);
        btnParticipante = (Button) findViewById(R.id.btnParticipante);
        btnUit = (Button) findViewById(R.id.btnUIT);

        btnOrientacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Orientacao();
            }
        });

        btnInscricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inscricao();
            }
        });

        btnParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Participante();
            }
        });

        btnUit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIT();
            }
        });

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        finish();
    }

    public void Orientacao(){
        Intent orientacao = new Intent(this, OrientacaoActivity.class);
        startActivity(orientacao);
    }

    public void Inscricao(){
        this.candidato = new Candidato();
        Intent inscricao = new Intent(this, Inscricao_InicioActivity.class);
        inscricao.putExtra("candidato", candidato);
        startActivity(inscricao);
    }

    public void Participante(){
        Intent login = new Intent(this, Portal_LoginActivity.class);
        startActivity(login);
    }

    public void UIT(){

    }
}
