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
import com.example.alexalves.vestibulapp.threads.InscricaoInsertThread;

public class Inscricao_CursosActivity extends AppCompatActivity {

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

        new InscricaoInsertThread(this).execute();

    }

    public void Resultado(Boolean _value){

        if(_value){
            com.example.alexalves.vestibulapp.Util.Dialog.Show(this, "Inscrição efetuada com sucesso!", "VestibulApp");
        }else{
            com.example.alexalves.vestibulapp.Util.Dialog.Show(this, "Não foi possível efetuar sua inscrição.", "VestibulApp");
        }
    }
}