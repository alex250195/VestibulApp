package com.example.alexalves.vestibulapp;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.alexalves.vestibulapp.Entidades.Candidato;

public class Inscricao_CursosActivity extends AppCompatActivity {
    private Candidato candidato;

    private AlertDialog alerta;

    private RadioButton computacao;
    private RadioButton engenhariaCivil;
    private RadioButton engenhariaMecanica;
    private RadioButton engenhariaProducao;

    private RadioButton direitoDiurno;
    private RadioButton direitoNoturno;
    private RadioButton administracao;
    private RadioButton contablilidade;
    private RadioButton gestaoComercial;
    private RadioButton arquitetura;

    private RadioButton medicina;
    private RadioButton odontologia;
    private RadioButton enfermagem;
    private RadioButton fisioterapia;

    private RadioButton biologia;
    private RadioButton quimica;
    private RadioButton pedagogia;

    private Button proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__cursos);

        engenhariaCivil = (RadioButton) findViewById(R.id.rbEngCivil);
        direitoNoturno = (RadioButton) findViewById(R.id.rbDireitoNoturno);
        administracao = (RadioButton) findViewById(R.id.rbAdministracao);
        computacao = (RadioButton) findViewById(R.id.rbComputacao);

        proximo = (Button) findViewById(R.id.btnProsseguir);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proximo();
            }
        });
    }

    public void Proximo(){

        //aqui finaliza a inscriçao e envia os dados para o portal

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("VestibulApp");
        builder.setMessage("Inscrição efetuada com sucesso!");
        alerta = builder.create();
        alerta.show();

        //Intent finalizar = new Intent(this, IndexActivity.class);
        //startActivity(finalizar);
        //finish();
    }
}