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
import com.example.alexalves.vestibulapp.Entidades.Endereco;
import com.example.alexalves.vestibulapp.Entidades.Escolaridade;
import com.example.alexalves.vestibulapp.threads.CandidatoInsertThread;
import com.example.alexalves.vestibulapp.threads.CursoSelectAllThread;
import com.example.alexalves.vestibulapp.threads.InscricaoInsertThread;

import java.util.ArrayList;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

public class Inscricao_InicioActivity extends AppCompatActivity {

    private Validacao validacao = new Validacao();

    private EditText cpf;
    private EditText nascimento;

    private Button proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__inicio);


        cpf = (EditText) findViewById(R.id.txtCpf);
        nascimento = (EditText) findViewById(R.id.txtNascimento);

        proximo = (Button) findViewById(R.id.btnProsseguir);

        Formatacao(cpf, nascimento);

        RecuperarDados();
        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Proximo();
                teste3();
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        finish();
    }

    public void Formatacao(EditText cpf, EditText nascimento){
        MaskEditTextChangedListener maskCPF = new MaskEditTextChangedListener("###.###.###-##", cpf);
        MaskEditTextChangedListener maskData = new MaskEditTextChangedListener("##/##/####", nascimento);

        cpf.addTextChangedListener(maskCPF);
        nascimento.addTextChangedListener(maskData);
    }

    private void RecuperarDados(){

        if(Candidato.getCandidato() != null){
            cpf.setText(Candidato.getCandidato().getCpf());
            nascimento.setText(Candidato.getCandidato().getNascimento());
        }
    }

    public void Proximo(){

        if(Candidato.getCandidato() == null){
            Candidato.setCandidato(new Candidato());
        }

        Candidato.getCandidato().setCpf(cpf.getText().toString());
        Candidato.getCandidato().setNascimento(nascimento.getText().toString());

        if(validacao.ChecarCpf(Candidato.getCandidato().getCpf()) && validacao.ChecarData(Candidato.getCandidato().getNascimento())) {
            try {

                Intent segundaEtapa = new Intent(this, Inscricao_DadosPessoaisActivity.class);
                startActivity(segundaEtapa);


            }catch (Exception ex){
                Toast.makeText(this,"Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"Alguns campos não estão preenchidos ou são inválidos!", Toast.LENGTH_LONG).show();
        }

    }

    private void teste(){

        Candidato.getCandidato().setRaca("vvemelho");
        Candidato.getCandidato().setNascionalidade("brasileira");
        Candidato.getCandidato().setMae("Maria");
        Candidato.getCandidato().setNome("Gt");
        Candidato.getCandidato().setCurso("Engenharia");
        Candidato.getCandidato().setSenha("12345");
        Candidato.getCandidato().setEstadoCivil("Solteiro");
        Candidato.getCandidato().setIdentidade("34343434343");
        Candidato.getCandidato().setUfIdentidade("MG");
        Candidato.getCandidato().setSexo("Masculino");
        Candidato.getCandidato().setOrgaoExpedidor("ssp");
        Candidato.getCandidato().setNascionalidade("Brasil");
        Endereco end = new Endereco();
        end.setUf("MG");
        Escolaridade esc = new Escolaridade();
        esc.setGrau("2 grau");

        Candidato.getCandidato().setEndereco(end);
        Candidato.getCandidato().setEscolaridade(esc);

        new CandidatoInsertThread(this).execute();

    }

    private void teste2(){

        new CursoSelectAllThread(this).execute();

    }

    private void teste3(){
        Intent segundaEtapa = new Intent(this, Inscricao_CursosActivity.class);
        startActivity(segundaEtapa);
    }
}
