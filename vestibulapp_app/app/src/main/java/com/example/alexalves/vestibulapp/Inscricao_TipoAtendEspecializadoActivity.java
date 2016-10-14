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

public class Inscricao_TipoAtendEspecializadoActivity extends AppCompatActivity {
    private Candidato candidato;

    private Button proximo;

    private CheckBox surdocegueira;
    private CheckBox auditiva;
    private CheckBox visao;
    private CheckBox fisica;
    private CheckBox autismo;
    private CheckBox discalculia;
    private CheckBox cegueira;
    private CheckBox surdez;
    private CheckBox monocular;
    private CheckBox intelectual;
    private CheckBox dislexia;
    private CheckBox defict;
    private CheckBox outra;
    private CheckBox acordo;

    private ArrayList<String> dados = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__tipo_atend_especializado);

        RecuperarDados();

        proximo = (Button) findViewById(R.id.btnProsseguir);

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

    public void Proximo(){
        if(VerificaCampos()){
            try {
                this.candidato.getAtendimentoEspecializado().setAcordo("Aceito");
                this.candidato.getAtendimentoEspecializado().setDeficiencia(dados);

                Intent proximo = new Intent(this, Inscricao_AtendEspecificoActivity.class);
                proximo.putExtra("candidato", this.candidato);
                startActivity(proximo);
            } catch (Exception ex) {
                Toast.makeText(this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Erro", ex.getMessage());
            }
        }
    }

    public boolean VerificaCampos(){
        surdocegueira = (CheckBox) findViewById(R.id.checkBox);
        auditiva = (CheckBox) findViewById(R.id.checkBox1);
        visao = (CheckBox) findViewById(R.id.checkBox2);
        fisica = (CheckBox) findViewById(R.id.checkBox3);
        autismo = (CheckBox) findViewById(R.id.checkBox4);
        discalculia = (CheckBox) findViewById(R.id.checkBox5);
        cegueira = (CheckBox) findViewById(R.id.checkBox7);
        surdez = (CheckBox) findViewById(R.id.checkBox8);
        monocular = (CheckBox) findViewById(R.id.checkBox9);
        intelectual = (CheckBox) findViewById(R.id.checkBox10);
        dislexia = (CheckBox) findViewById(R.id.checkBox11);
        defict = (CheckBox) findViewById(R.id.checkBox12);
        outra = (CheckBox) findViewById(R.id.checkBox6);
        acordo = (CheckBox) findViewById(R.id.checkBox13);

        dados.clear();

        if(surdocegueira.isChecked()) dados.add("Surdocegueira");
        if(auditiva.isChecked()) dados.add("Deficiência Auditiva");
        if(visao.isChecked()) dados.add("Baixa Visão");
        if(fisica.isChecked()) dados.add("Deficiência Física");
        if(autismo.isChecked()) dados.add("Autismo");
        if(discalculia.isChecked()) dados.add("Discalculia");
        if(cegueira.isChecked()) dados.add("Cegueira");
        if(surdez.isChecked()) dados.add("Surdez");
        if(monocular.isChecked()) dados.add("Visão Monocular");
        if(intelectual.isChecked()) dados.add("Deficiência Intelectual (Mental)");
        if(dislexia.isChecked()) dados.add("Dislexia");
        if(defict.isChecked()) dados.add("Déficit de Atenção");
        if(outra.isChecked()) dados.add("Outra deficiência ou condição especial");

        if(dados.size() == 0) return false;
        if(!acordo.isChecked()) return false;

        return true;
    }
}
