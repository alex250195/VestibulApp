package com.example.alexalves.vestibulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.alexalves.vestibulapp.Entidades.Candidato;

import java.util.ArrayList;

public class Inscricao_TipoAtendEspecificoActivity extends AppCompatActivity {
    private Candidato candidato;

    private Button btnProximo;

    private CheckBox gestante;
    private CheckBox lactante;
    private CheckBox hospitalar;
    private CheckBox sabado;

    private ArrayList<String> dados = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__tipo_atend_especifico);

        RecuperarDados();

        btnProximo = (Button) findViewById(R.id.btnProsseguir);

        btnProximo.setOnClickListener(new View.OnClickListener() {
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

    public void Proximo(){
        if(VerificaCampos()){
            try {
                this.candidato.getAtendimentoEspecifico().setAcordo("Aceito");
                this.candidato.getAtendimentoEspecifico().setAtendimento(dados);

                Intent proximo = new Intent(this, Inscricao_ConfirmarDadoActivity.class);
                proximo.putExtra("candidato", this.candidato);
                startActivity(proximo);
            } catch (Exception ex) {
                Toast.makeText(this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Erro", ex.getMessage());
            }
        }
    }

    public boolean VerificaCampos(){
        gestante = (CheckBox) findViewById(R.id.checkBox);
        lactante = (CheckBox) findViewById(R.id.checkBox1);
        hospitalar = (CheckBox) findViewById(R.id.checkBox2);
        sabado = (CheckBox) findViewById(R.id.checkBox3);

        dados.clear();

        if(gestante.isChecked()) dados.add("Gestante");
        if(lactante.isChecked()) dados.add("Lactante");
        if(hospitalar.isChecked()) dados.add("Estudante em situação de classe hospitalar");
        if(sabado.isChecked()) dados.add("Guardador de sábado por convicção religiosa");

        if(dados.size() == 0) return false;

        return true;
    }
}
