package com.example.alexalves.vestibulapp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.alexalves.vestibulapp.Entidades.Candidato;
import com.example.alexalves.vestibulapp.Entidades.Curso;
import com.example.alexalves.vestibulapp.threads.CandidatoInsertThread;
import com.example.alexalves.vestibulapp.threads.CursoSelectAllThread;
import com.example.alexalves.vestibulapp.threads.InscricaoInsertThread;

public class Inscricao_CursosActivity extends AppCompatActivity {

    private AlertDialog alerta;
    private Button proximo;
    private ProgressDialog progressDialog;
    private RadioGroup cursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__cursos);

        proximo = (Button) findViewById(R.id.btnProsseguir);
        cursos = (RadioGroup) findViewById(R.id.radioGroupCursos);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proximo();
            }
        });

        showProgressDialog("Carregando cursos, aguarde.");
        //chama a thread para carregar os cursos
        new CursoSelectAllThread(this).execute();

    }

    public void Proximo(){

        new CandidatoInsertThread(this).execute();

    }

    public void Resultado(Boolean _value){

        if(_value){
            com.example.alexalves.vestibulapp.Util.Dialog.Show(this, "Inscrição efetuada com sucesso!", "VestibulApp");
        }else{
            com.example.alexalves.vestibulapp.Util.Dialog.Show(this, "Não foi possível efetuar sua inscrição.", "VestibulApp");
        }
    }

    public void listaCursos(){

        if(Curso.getCursos() != null && Curso.getCursos().size() > 0){

            for(Curso c: Curso.getCursos()){

                RadioButton curso = new RadioButton(this);
                curso.setText(c.getNome());

                cursos.addView(curso);
            }
        }
    }

    private void showProgressDialog(String _mensagem){

        if(progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(_mensagem);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);

            progressDialog.show();
        }
    }
}