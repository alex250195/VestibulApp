package com.example.alexalves.vestibulapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.alexalves.vestibulapp.Entidades.Candidato;

public class Portal_InformacaoPessoalActivity extends AppCompatActivity {

    TextView txtCpf, txtNome, txtData, txtNomeMae, txtSexo, txtRaca, txtIdentidade, txtIdentidadeOrgao, txtNacionalidade, txtIdentidadeUf, txtIdentidadeCidade, txtEnderecoCep;
    TextView txtEnderecoRua, txtEnderecoNumero, txtEnderecoComplemento, txtEnderecoBairro, txtEnderecoUF, txtEnderecoMunicipio;
    TextView txtContatoTelefoneFixo, txtContatoTelefoneCelular, txtContatoEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal__informacao_pessoal);

        txtCpf = (TextView) findViewById(R.id.txtInfoCpf);
        txtNome = (TextView) findViewById(R.id.txtinfoNome);
        txtData = (TextView) findViewById(R.id.txtinfoDataNascimento);
        txtNomeMae = (TextView) findViewById(R.id.txtinfoNomeMae);
        txtSexo = (TextView) findViewById(R.id.txtInfoSexo);
        txtRaca = (TextView) findViewById(R.id.txtInfoRaca);
        txtIdentidade = (TextView) findViewById(R.id.txtInfoIdentidade);
        txtIdentidadeOrgao = (TextView) findViewById(R.id.txtInfoOrgao);
        txtNacionalidade = (TextView) findViewById(R.id.txtInfoNacionalidade);
        txtIdentidadeUf = (TextView) findViewById(R.id.txtInfoUfIdentidade);
        txtIdentidadeCidade = (TextView) findViewById(R.id.txtInfoMunicipio);
        txtEnderecoCep = (TextView) findViewById(R.id.txtInfoCep);
        txtEnderecoRua  = (TextView) findViewById(R.id.txtInfoEnderecoRua);
        txtEnderecoNumero  = (TextView) findViewById(R.id.txtInfoEnderecoNumero);
        txtEnderecoComplemento = (TextView) findViewById(R.id.txtInfoEnderecoComplemento);
        txtEnderecoBairro = (TextView) findViewById(R.id.txtInfoEnderecoBairro);
        txtEnderecoUF = (TextView) findViewById(R.id.txtInfoEnderecoUf);
        txtEnderecoMunicipio = (TextView) findViewById(R.id.txtInfoEnderecoMunicipio);
        txtContatoTelefoneFixo = (TextView) findViewById(R.id.txtInfoContatoFixo);
        txtContatoTelefoneCelular = (TextView) findViewById(R.id.txtInfoContatoCelular);
        txtContatoEmail = (TextView) findViewById(R.id.txtInfoContatoEmail);


        carregarInformacoes();

    }

    @Override
    protected void onDestroy(){
        finish();

        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        finish();

        super.onBackPressed();
    }

    private void carregarInformacoes(){

        if(Candidato.getCandidato() != null){

            if(Candidato.getCandidato().getCpf()!= null){txtCpf.setText(Candidato.getCandidato().getCpf());}
            if(Candidato.getCandidato().getNome() != null){txtNome.setText(Candidato.getCandidato().getNome());}
            if(Candidato.getCandidato().getNascimento()!= null){txtData.setText(Candidato.getCandidato().getNascimento());}
            if(Candidato.getCandidato().getMae() != null){txtNomeMae.setText(Candidato.getCandidato().getMae());}
            if(Candidato.getCandidato().getSexo() != null){txtSexo.setText(Candidato.getCandidato().getSexo());}
            if(Candidato.getCandidato().getRaca() != null){txtRaca.setText(Candidato.getCandidato().getRaca());}
            if(Candidato.getCandidato().getIdentidade()!= null){txtIdentidade.setText(Candidato.getCandidato().getIdentidade());}
            if(Candidato.getCandidato().getOrgaoExpedidor() != null){txtIdentidadeOrgao.setText(Candidato.getCandidato().getOrgaoExpedidor());}
            if(Candidato.getCandidato().getNascionalidade() != null){txtNacionalidade.setText(Candidato.getCandidato().getNascionalidade());}
            if(Candidato.getCandidato().getUfIdentidade() != null){txtIdentidadeUf.setText(Candidato.getCandidato().getUfIdentidade());}
            //txtIdentidadeCidade.setText();
            if(Candidato.getCandidato().getEndereco() != null) {
                if (Candidato.getCandidato().getEndereco().getCep() != null) {
                    txtEnderecoCep.setText(Candidato.getCandidato().getEndereco().getCep());
                }
                if (Candidato.getCandidato().getEndereco().getEndereco() != null) {
                    txtEnderecoRua.setText(Candidato.getCandidato().getEndereco().getEndereco());
                }
                if (Candidato.getCandidato().getEndereco().getNumero() != null) {
                    txtEnderecoNumero.setText(Candidato.getCandidato().getEndereco().getNumero());
                }
                if (Candidato.getCandidato().getEndereco().getComplemento() != null) {
                    txtEnderecoComplemento.setText(Candidato.getCandidato().getEndereco().getComplemento());
                }
                if (Candidato.getCandidato().getEndereco().getBairro() != null) {
                    txtEnderecoBairro.setText(Candidato.getCandidato().getEndereco().getBairro());
                }
                if (Candidato.getCandidato().getEndereco().getUf() != null) {
                    txtEnderecoUF.setText(Candidato.getCandidato().getEndereco().getUf());
                }
                if (Candidato.getCandidato().getEndereco().getMunicipio() != null) {
                    txtEnderecoMunicipio.setText(Candidato.getCandidato().getEndereco().getMunicipio());
                }
            }
            if(Candidato.getCandidato().getContato() != null) {
                if (Candidato.getCandidato().getContato().getTelefone() != null) {
                    txtContatoTelefoneFixo.setText(Candidato.getCandidato().getContato().getTelefone());
                }
                if (Candidato.getCandidato().getContato().getCelular() != null) {
                    txtContatoTelefoneCelular.setText(Candidato.getCandidato().getContato().getCelular());
                }
                if (Candidato.getCandidato().getContato().getEmail() != null) {
                    txtContatoEmail.setText(Candidato.getCandidato().getContato().getEmail());
                }
            }
        }
    }
}
