package com.example.alexalves.vestibulapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.alexalves.vestibulapp.Entidades.Candidato;
import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.Preferencias;
import com.example.alexalves.vestibulapp.threads.CandidatoSelectBySpecificationThread;

public class Portal_AreaParticipanteActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ProgressDialog progressDialog;
    private Preferencias preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal__area_participante);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //carrega as informaçoes do candidato
        showProgressDialog("Aguarde...");
        new CandidatoSelectBySpecificationThread(this, Candidato.getCandidato().getCpf()).execute();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.portal__area_participante, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_sair) {
            try{

                if(preferencias == null){
                    preferencias = new Preferencias(this, Constants.appName);
                }

                preferencias.begin();
                preferencias.remove(Constants.prefCpf);
                preferencias.remove(Constants.prefSenha);
                preferencias.end();

                Thread.sleep(1000);
                finish();
            }catch (Exception ex){}
        } else if (id == R.id.nav_inscricao) {
            Intent inscricao = new Intent(this, Portal_AcompanharInscricaoActivity.class);
            startActivity(inscricao);
        } else if (id == R.id.nav_dados) {
            Intent dados = new Intent(this, Portal_InformacaoPessoalActivity.class);
            startActivity(dados);
        } else if (id == R.id.nav_atendimento) {
            Intent atendimento = new Intent(this, Portal_AtendimentoActivity.class);
            startActivity(atendimento);
        } else if (id == R.id.nav_local) {

        } else if (id == R.id.nav_senha) {
            Intent senha = new Intent(this, Portal_SenhaActivity.class);
            startActivity(senha);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showProgressDialog(String _mensagem){

        if(progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(_mensagem);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);

            progressDialog.show();
        }
    }

    public void result(){

        if(progressDialog != null){
            progressDialog.dismiss();
        }


    }

}
