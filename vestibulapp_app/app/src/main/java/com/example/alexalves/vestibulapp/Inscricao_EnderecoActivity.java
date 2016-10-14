package com.example.alexalves.vestibulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.alexalves.vestibulapp.Controles.Validacao;
import com.example.alexalves.vestibulapp.Entidades.Candidato;

import java.util.ArrayList;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

public class Inscricao_EnderecoActivity extends AppCompatActivity {
    private Candidato candidato;
    private Validacao validacao = new Validacao();

    private Spinner uf;

    private EditText cep;
    private EditText endereco;
    private EditText complemento;
    private EditText numero;
    private EditText bairro;
    private EditText municipio;

    private Button proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__endereco);

        RecuperarDados();

        uf = (Spinner) findViewById(R.id.txtUf);

        cep = (EditText) findViewById(R.id.txtCep);
        endereco = (EditText) findViewById(R.id.txtEndereco);
        complemento = (EditText) findViewById(R.id.txtComplemento);
        numero = (EditText) findViewById(R.id.txtNumero);
        bairro = (EditText) findViewById(R.id.txtBairro);
        municipio = (EditText) findViewById(R.id.txtMunicipio);

        proximo = (Button) findViewById(R.id.btnProsseguir);

        Formatacao(uf, cep);
        Teste(cep, endereco, numero, complemento, bairro, municipio);

        final ArrayList<String> dados = new ArrayList<String>();
        dados.add(cep.getText().toString());
        dados.add(endereco.getText().toString());
        dados.add(complemento.getText().toString());
        dados.add(numero.getText().toString());
        dados.add(bairro.getText().toString());
        dados.add(municipio.getText().toString());
        dados.add(uf.getSelectedItem().toString());

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
    }

    public void RecuperarDados(){
        Intent intent = getIntent();
        this.candidato = (Candidato) intent.getSerializableExtra("candidato");
    }

    public void Teste(EditText cep, EditText endereco, EditText numero, EditText complemento, EditText bairro, EditText municipio){
        cep.setText("35.681-184");
        endereco.setText("Rua Doutor Alcides Gonçalves");
        numero.setText("1120");
        complemento.setText("Casa");
        bairro.setText("Santanense");
        municipio.setText("Itaúna");
    }

    public void Formatacao(Spinner uf, EditText cep){
        MaskEditTextChangedListener maskCEP = new MaskEditTextChangedListener("##.###-###", cep);
        cep.addTextChangedListener(maskCEP);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.uf, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        uf.setAdapter(adapter);
    }

    public void Proximo(ArrayList<String> dados){
        if(VerificarCampos(dados)) {
            try {
                this.candidato.getEndereco().setCep(dados.get(0));
                this.candidato.getEndereco().setEndereco(dados.get(1));
                this.candidato.getEndereco().setComplemento(dados.get(2));
                this.candidato.getEndereco().setNumero(dados.get(3));
                this.candidato.getEndereco().setBairro(dados.get(4));
                this.candidato.getEndereco().setMunicipio(dados.get(5));
                this.candidato.getEndereco().setUf(dados.get(6));

                Intent endereco = new Intent(this, Inscricao_ContatoActivity.class);
                endereco.putExtra("candidato", this.candidato);
                startActivity(endereco);
            } catch (Exception ex) {
                Toast.makeText(this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    public boolean VerificarCampos(ArrayList<String> endereco){
        for (String var : endereco){
            if(!validacao.ChecarCampo(var)){
                return false;
            }
        }
        if(endereco.get(0).length() != 10) return false;
        return true;
    }
}
