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
import com.example.alexalves.vestibulapp.Entidades.Contato;
import com.example.alexalves.vestibulapp.Entidades.Endereco;
import com.example.alexalves.vestibulapp.Entidades.Escolaridade;
import com.example.alexalves.vestibulapp.threads.CandidatoContatoInsertThread;
import com.example.alexalves.vestibulapp.threads.CandidatoEnderecoInsertThread;
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
                Proximo();
                //teste6();
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

    private void teste5(){

        Endereco end = new Endereco();

        end.setEndereco("rua do outro");
        end.setNumero("33");
        end.setComplemento("Casa");
        end.setBairro("Centro");
        end.setMunicipio("Itauna");
        end.setUf("MG");
        end.setIdCandidato(23);

        Candidato c = new Candidato();
        c.setEndereco(end);

        Candidato.setCandidato(c);

        new CandidatoEnderecoInsertThread(this).execute();

    }

    private void teste6(){

        Contato contato = new Contato();

        contato.setEmail("teste@teste.com");
        contato.setCelular("37888292929");
        contato.setTelefone("3788892829");
        contato.setIdCandidato(23);

        Candidato c = new Candidato();
        c.setContato(contato);

        Candidato.setCandidato(c);

        new CandidatoContatoInsertThread(this).execute();

    }
}
