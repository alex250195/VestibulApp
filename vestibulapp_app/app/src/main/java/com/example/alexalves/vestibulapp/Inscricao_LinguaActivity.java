package com.example.alexalves.vestibulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.alexalves.vestibulapp.Entidades.Candidato;

public class Inscricao_LinguaActivity extends AppCompatActivity {

    private RadioButton ingles;
    private RadioButton espanhol;

    private Button proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__lingua);

        ingles = (RadioButton) findViewById(R.id.rbIngles);
        espanhol = (RadioButton) findViewById(R.id.rbEspanhol);

        proximo = (Button) findViewById(R.id.btnProsseguir);

        RecuperarDados();

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

        if(Candidato.getCandidato() != null){


        }
    }

    public void Proximo(){
        if (VerificarCampos()){
            try {
                if(ingles.isChecked())
                    Candidato.getCandidato().getProva().setLinguaEstrangeira("Inglês");
                else
                    Candidato.getCandidato().getProva().setLinguaEstrangeira("Espanhol");

                Intent proximo = new Intent(this, Inscricao_CursosActivity.class);
                startActivity(proximo);

            }catch (Exception ex){
                Toast.makeText(this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    public boolean VerificarCampos(){
        if(!ingles.isChecked() && !espanhol.isChecked())
            return false;
        return  true;
    }
}
