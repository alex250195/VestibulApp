package com.example.alexalves.vestibulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alexalves.vestibulapp.Controles.Validacao;
import com.example.alexalves.vestibulapp.Entidades.Candidato;

import java.util.ArrayList;

public class Inscricao_ConfirmarDadoActivity extends AppCompatActivity {
    private Candidato candidato;
    private Validacao validacao = new Validacao();

    private Button proximo;

    private TextView cpf;
    private TextView nome;
    private TextView nascimento;
    private TextView mae;
    private TextView sexo;
    private TextView raca;
    private TextView identidade;
    private TextView orgaoExpedidor;
    private TextView ufIdentidade;
    private TextView estadoCivil;
    private TextView nascionalidade;
    private TextView uf;
    private TextView municipio;

    private TextView cepEndereco;
    private TextView enderecoEndereco;
    private TextView numeroEndereco;
    private TextView complementoEndereco;
    private TextView bairroEndereco;
    private TextView ufEndereco;
    private TextView municipioEndereco;

    private TextView telefoneContato;
    private TextView celularContato;
    private TextView emailContato;

    private TextView especifico;
    private TextView especializado;

    private ListView listaEspecifico;
    private ListView listaEspecializado;

    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao__confirmar_dado);

        ArrayList<String> ltEspecializado = new ArrayList<String>();
        ArrayList<String> ltEspecifico = new ArrayList<String>();
        String temp1 = "", temp2 = "";

        RecuperarDados();

        cpf = (TextView) findViewById(R.id.textView4);
        nome = (TextView) findViewById(R.id.textView6);
        nascimento = (TextView) findViewById(R.id.textView8);
        mae = (TextView) findViewById(R.id.textView10);
        sexo = (TextView) findViewById(R.id.textView12);
        raca = (TextView) findViewById(R.id.textView14);
        identidade = (TextView) findViewById(R.id.textView16);
        orgaoExpedidor = (TextView) findViewById(R.id.textView18);
        ufIdentidade = (TextView) findViewById(R.id.textView20);
        estadoCivil = (TextView) findViewById(R.id.textView22);
        nascionalidade = (TextView) findViewById(R.id.textView24);
        uf = (TextView) findViewById(R.id.textView26);
        municipio = (TextView) findViewById(R.id.textView28);

        cepEndereco = (TextView) findViewById(R.id.textView31);
        enderecoEndereco = (TextView) findViewById(R.id.textView33);
        numeroEndereco = (TextView) findViewById(R.id.textView35);
        complementoEndereco = (TextView) findViewById(R.id.textView37);
        bairroEndereco = (TextView) findViewById(R.id.textView39);
        ufEndereco = (TextView) findViewById(R.id.textView41);
        municipioEndereco = (TextView) findViewById(R.id.textView43);

        telefoneContato = (TextView) findViewById(R.id.textView46);
        celularContato = (TextView) findViewById(R.id.textView48);
        emailContato = (TextView) findViewById(R.id.textView50);

        especifico = (TextView) findViewById(R.id.textView56);
        especializado = (TextView) findViewById(R.id.textView53);

        listaEspecifico = (ListView) findViewById(R.id.lvEspecifico);
        listaEspecializado = (ListView) findViewById(R.id.lvEspecializado);

        ExibeDados();

        if(candidato.getAtendimentoEspecializado().getOpcao().contains("Sim")){
            for(String var : candidato.getAtendimentoEspecializado().getDeficiencia()){
                temp1 += var + "\n";
            }
            ltEspecializado.add(temp1);
            adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ltEspecializado);
            listaEspecializado.setAdapter(adapter1);
        }

        if(candidato.getAtendimentoEspecifico().getOpcao().contains("Sim")){
            for(String var : candidato.getAtendimentoEspecifico().getAtendimento()){
                temp2 += var + "\n";
            }
            ltEspecifico.add(temp2);
            adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ltEspecifico);
            listaEspecifico.setAdapter(adapter2);
        }

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

    public void ExibeDados(){
        cpf.setText(candidato.getCpf());
        nome.setText(candidato.getNome());
        nascimento.setText(candidato.getNascimento());
        mae.setText(candidato.getMae());
        sexo.setText(candidato.getSexo());
        raca.setText(candidato.getRaca());
        identidade.setText(candidato.getIdentidade());
        orgaoExpedidor.setText(candidato.getOrgaoExpedidor());
        ufIdentidade.setText(candidato.getUfIdentidade());
        estadoCivil.setText(candidato.getEstadoCivil());
        nascionalidade.setText(candidato.getNascionalidade());
        uf.setText(candidato.getEndereco().getUf());
        municipio.setText(candidato.getEndereco().getMunicipio());

        cepEndereco.setText(candidato.getEndereco().getCep());
        enderecoEndereco.setText(candidato.getEndereco().getEndereco());
        numeroEndereco.setText(candidato.getEndereco().getNumero());
        complementoEndereco.setText(candidato.getEndereco().getComplemento());
        bairroEndereco.setText(candidato.getEndereco().getBairro());
        ufEndereco.setText(candidato.getEndereco().getUf());
        municipioEndereco.setText(candidato.getEndereco().getMunicipio());

        telefoneContato.setText(candidato.getContato().getTelefone());
        celularContato.setText(candidato.getContato().getCelular());
        emailContato.setText(candidato.getContato().getEmail());

        especifico.setText(candidato.getAtendimentoEspecializado().getOpcao());
        especializado.setText(candidato.getAtendimentoEspecifico().getOpcao());
    }

    public void Proximo(){
        Intent proximo = new Intent(this, Inscricao_EscolaridadeActivity.class);
        proximo.putExtra("candidato", this.candidato);
        startActivity(proximo);
    }
}
