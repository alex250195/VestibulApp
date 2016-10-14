package com.example.alexalves.vestibulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexalves.vestibulapp.Controles.Validacao;
import com.example.alexalves.vestibulapp.Entidades.Candidato;

import java.util.ArrayList;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

public class Inscricao_InicioActivity extends AppCompatActivity {
    private Candidato candidato;
    private Validacao validacao = new Validacao();

    private EditText cpf;
    private EditText nascimento;

    private Button proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__inicio);

        RecuperarDados();

        cpf = (EditText) findViewById(R.id.txtCpf);
        nascimento = (EditText) findViewById(R.id.txtNascimento);

        proximo = (Button) findViewById(R.id.btnProsseguir);

        Formatacao(cpf, nascimento);

        Teste(cpf, nascimento);

        final ArrayList<String> dados = new ArrayList<String>();
        dados.add(cpf.getText().toString());
        dados.add(nascimento.getText().toString());

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proximo(dados);
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        finish();
    }

    public void Teste(EditText cpf, EditText nascimento){
        cpf.setText("012.621.296-13");
        nascimento.setText("25/01/1995");
    }

    public void Formatacao(EditText cpf, EditText nascimento){
        MaskEditTextChangedListener maskCPF = new MaskEditTextChangedListener("###.###.###-##", cpf);
        MaskEditTextChangedListener maskData = new MaskEditTextChangedListener("##/##/####", nascimento);

        cpf.addTextChangedListener(maskCPF);
        nascimento.addTextChangedListener(maskData);
    }

    public void RecuperarDados(){
        Intent intent = getIntent();
        this.candidato = (Candidato) intent.getSerializableExtra("candidato");
    }

    public void Proximo(ArrayList<String> dados){
        if(validacao.ChecarCpf(dados.get(0)) && validacao.ChecarData(dados.get(1))) {
            try {
                this.candidato.setCpf(dados.get(0));
                this.candidato.setNascimento(dados.get(1));

                Intent segundaEtapa = new Intent(this, Inscricao_DadosPessoaisActivity.class);
                segundaEtapa.putExtra("candidato", this.candidato);
                startActivity(segundaEtapa);
            }catch (Exception ex){
                Toast.makeText(this,"Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"Alguns campos não estão preenchidos ou são inválidos!", Toast.LENGTH_LONG).show();
        }
    }
}
