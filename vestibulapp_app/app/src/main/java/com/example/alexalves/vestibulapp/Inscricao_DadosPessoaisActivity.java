package com.example.alexalves.vestibulapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.alexalves.vestibulapp.Controles.Validacao;
import com.example.alexalves.vestibulapp.Entidades.Candidato;

import java.util.ArrayList;

public class Inscricao_DadosPessoaisActivity extends AppCompatActivity {
    private Candidato candidato;
    private Validacao validacao = new Validacao();

    private Spinner raca;
    private Spinner ufIdentidade;
    private Spinner estadoCivil;

    private EditText cpf;
    private EditText nascimento;
    private EditText nome;
    private EditText mae;
    private EditText identidade;
    private EditText orgaoUf;
    private EditText nascionalidade;

    private RadioButton masculino;
    private RadioButton feminino;

    private String sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__dados_pessoais);

        RecuperarDados();

        raca = (Spinner) findViewById(R.id.txtCor);
        ufIdentidade = (Spinner) findViewById(R.id.txtUfIdentidade);
        estadoCivil = (Spinner) findViewById(R.id.txtEstadoCivil);

        cpf = (EditText) findViewById(R.id.txtCpf);
        nascimento = (EditText) findViewById(R.id.txtNascimento);
        nome = (EditText) findViewById(R.id.txtNome);
        mae = (EditText) findViewById(R.id.txtMae);
        identidade = (EditText) findViewById(R.id.txtIdentidade);
        orgaoUf = (EditText) findViewById(R.id.txtOrgaoUf);
        nascionalidade = (EditText) findViewById(R.id.txtNascionalidade);

        masculino = (RadioButton) findViewById(R.id.rbMasc);
        feminino = (RadioButton) findViewById(R.id.rbFem);

        if(masculino.isChecked()) sexo = "Masculino";
        else sexo = "Feminino";

        Formatacao(raca, ufIdentidade, estadoCivil, cpf, nascimento);

        Teste(nome, mae, identidade, orgaoUf, nascionalidade);

        final ArrayList<String> dadosPessoais = new ArrayList<String>();
        dadosPessoais.add(cpf.getText().toString());
        dadosPessoais.add(nome.getText().toString());
        dadosPessoais.add(nascimento.getText().toString());
        dadosPessoais.add(mae.getText().toString());
        dadosPessoais.add(raca.getSelectedItem().toString());
        dadosPessoais.add(identidade.getText().toString());
        dadosPessoais.add(orgaoUf.getText().toString());
        dadosPessoais.add(ufIdentidade.getSelectedItem().toString());
        dadosPessoais.add(estadoCivil.getSelectedItem().toString());
        dadosPessoais.add(nascionalidade.getText().toString());
        dadosPessoais.add(sexo);

        Button btnProximo = (Button) findViewById(R.id.btnProsseguir);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proximo(dadosPessoais);
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    public void Teste(EditText nome, EditText mae, EditText identidade, EditText orgaoUf, EditText nascionalidade){
        nome.setText("");
        mae.setText("");
        identidade.setText("");
        orgaoUf.setText("");
        nascionalidade.setText("");
    }

    public void Formatacao(Spinner raca, Spinner ufIdentidade, Spinner estadoCivil, EditText cpf, EditText nascimento){
        cpf.setText(String.valueOf(this.candidato.getCpf()));
        nascimento.setText(String.valueOf(this.candidato.getNascimento()));

        cpf.setEnabled(false);
        nascimento.setEnabled(false);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.raca, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raca.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.uf, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ufIdentidade.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.estadoCivil, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estadoCivil.setAdapter(adapter2);
    }

    public void RecuperarDados(){
        Intent intent = getIntent();
        this.candidato = (Candidato) intent.getSerializableExtra("candidato");
    }

    public void Proximo(ArrayList<String> dadosPessoais){
        if(VerificarCampos(dadosPessoais)){
            try {
                this.candidato.setCpf(dadosPessoais.get(0));
                this.candidato.setNome(dadosPessoais.get(1));
                this.candidato.setNascimento(dadosPessoais.get(2));
                this.candidato.setMae(dadosPessoais.get(3));
                this.candidato.setRaca(dadosPessoais.get(4));
                this.candidato.setIdentidade(dadosPessoais.get(5));
                this.candidato.setOrgaoExpedidor(dadosPessoais.get(6));
                this.candidato.setUfIdentidade(dadosPessoais.get(7));
                this.candidato.setEstadoCivil(dadosPessoais.get(8));
                this.candidato.setNascionalidade(dadosPessoais.get(9));
                this.candidato.setSexo(dadosPessoais.get(10));

                Intent endereco = new Intent(this, Inscricao_EnderecoActivity.class);
                endereco.putExtra("candidato", this.candidato);
                startActivity(endereco);

            }catch (Exception ex){
                Toast.makeText(this,"Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this, "Alguns campos não estão preenchidos ou são inválidos!", Toast.LENGTH_LONG).show();
        }
    }

    public boolean VerificarCampos(ArrayList<String> dadosPessoais){
        for (String var : dadosPessoais){
            if(!validacao.ChecarCampo(var)){
                return false;
            }
        }
        return true;
    }
}
