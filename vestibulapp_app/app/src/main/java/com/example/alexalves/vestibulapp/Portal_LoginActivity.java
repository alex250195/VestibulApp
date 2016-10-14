package com.example.alexalves.vestibulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Portal_LoginActivity extends AppCompatActivity {
    private Button btnAcessar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal__login);

        btnAcessar = (Button) findViewById(R.id.btnProsseguir);

        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Acessar();
            }
        });
    }

    public void Acessar(){
        Intent acessar = new Intent(this, Portal_AreaParticipanteActivity.class);
        startActivity(acessar);

        finish();
    }
}
