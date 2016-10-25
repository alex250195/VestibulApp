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
import com.example.alexalves.vestibulapp.Entidades.AtendimentoEspecializado;
import com.example.alexalves.vestibulapp.Entidades.Candidato;
import com.example.alexalves.vestibulapp.Entidades.Contato;
import com.example.alexalves.vestibulapp.Entidades.Endereco;

import java.util.ArrayList;

public class Inscricao_ConfirmarDadoActivity extends AppCompatActivity {

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

        if(Candidato.getCandidato().getAtendimentoEspecializado().getOpcao().contains("Sim")){
            for(String var : Candidato.getCandidato().getAtendimentoEspecializado().getDeficiencia()){
                temp1 += var + "\n";
            }
            ltEspecializado.add(temp1);
            adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ltEspecializado);
            listaEspecializado.setAdapter(adapter1);
        }

        if(Candidato.getCandidato().getAtendimentoEspecifico().getOpcao().contains("Sim")){
            for(String var : Candidato.getCandidato().getAtendimentoEspecifico().getAtendimento()){
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

                Candidato.getCandidato().setCpf(cpf.getText().toString());
                Candidato.getCandidato().setNome(nome.getText().toString());
                Candidato.getCandidato().setNascimento(nascimento.getText().toString());
                Candidato.getCandidato().setMae(mae.getText().toString());
                Candidato.getCandidato().setSexo(sexo.getText().toString());
                Candidato.getCandidato().setRaca(raca.getText().toString());
                Candidato.getCandidato().setIdentidade(identidade.getText().toString());
                Candidato.getCandidato().setOrgaoExpedidor(orgaoExpedidor.getText().toString());
                Candidato.getCandidato().setUfIdentidade(ufIdentidade.getText().toString());
                Candidato.getCandidato().setEstadoCivil(estadoCivil.getText().toString());
                Candidato.getCandidato().setNascionalidade(nascionalidade.getText().toString());

                Candidato.getCandidato().setEndereco(new Endereco());
                Candidato.getCandidato().getEndereco().setUf(uf.getText().toString());
                Candidato.getCandidato().getEndereco().setMunicipio(municipio.getText().toString());
                Candidato.getCandidato().getEndereco().setCep(cepEndereco.getText().toString());
                Candidato.getCandidato().getEndereco().setEndereco(enderecoEndereco.getText().toString());
                Candidato.getCandidato().getEndereco().setNumero(numeroEndereco.getText().toString());
                Candidato.getCandidato().getEndereco().setComplemento(complementoEndereco.getText().toString());
                Candidato.getCandidato().getEndereco().setBairro(bairroEndereco.getText().toString());

                Candidato.getCandidato().setContato(new Contato());
                Candidato.getCandidato().getContato().setTelefone(telefoneContato.getText().toString());
                Candidato.getCandidato().getContato().setCelular(celularContato.getText().toString());
                Candidato.getCandidato().getContato().setEmail(emailContato.getText().toString());

                Candidato.getCandidato().setAtendimentoEspecializado(new AtendimentoEspecializado());
                Candidato.getCandidato().getAtendimentoEspecializado().setOpcao(especializado.getText().toString());
                Candidato.getCandidato().getAtendimentoEspecializado().setOpcao(especifico.getText().toString());

                Proximo();
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    public void ExibeDados(){

        cpf.setText(Candidato.getCandidato().getCpf());
        nome.setText(Candidato.getCandidato().getNome());
        nascimento.setText(Candidato.getCandidato().getNascimento());
        mae.setText(Candidato.getCandidato().getMae());
        sexo.setText(Candidato.getCandidato().getSexo());
        raca.setText(Candidato.getCandidato().getRaca());
        identidade.setText(Candidato.getCandidato().getIdentidade());
        orgaoExpedidor.setText(Candidato.getCandidato().getOrgaoExpedidor());
        ufIdentidade.setText(Candidato.getCandidato().getUfIdentidade());
        estadoCivil.setText(Candidato.getCandidato().getEstadoCivil());
        nascionalidade.setText(Candidato.getCandidato().getNascionalidade());
        uf.setText(Candidato.getCandidato().getEndereco().getUf());
        municipio.setText(Candidato.getCandidato().getEndereco().getMunicipio());

        cepEndereco.setText(Candidato.getCandidato().getEndereco().getCep());
        enderecoEndereco.setText(Candidato.getCandidato().getEndereco().getEndereco());
        numeroEndereco.setText(Candidato.getCandidato().getEndereco().getNumero());
        complementoEndereco.setText(Candidato.getCandidato().getEndereco().getComplemento());
        bairroEndereco.setText(Candidato.getCandidato().getEndereco().getBairro());
        ufEndereco.setText(Candidato.getCandidato().getEndereco().getUf());
        municipioEndereco.setText(Candidato.getCandidato().getEndereco().getMunicipio());

        telefoneContato.setText(Candidato.getCandidato().getContato().getTelefone());
        celularContato.setText(Candidato.getCandidato().getContato().getCelular());
        emailContato.setText(Candidato.getCandidato().getContato().getEmail());

        especifico.setText(Candidato.getCandidato().getAtendimentoEspecializado().getOpcao());
        especializado.setText(Candidato.getCandidato().getAtendimentoEspecifico().getOpcao());
    }

    public void Proximo(){
        Intent proximo = new Intent(this, Inscricao_EscolaridadeActivity.class);
        startActivity(proximo);
    }
}
