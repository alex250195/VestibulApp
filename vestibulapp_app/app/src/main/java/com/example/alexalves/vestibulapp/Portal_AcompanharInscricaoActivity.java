package com.example.alexalves.vestibulapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Portal_AcompanharInscricaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal__acompanhar_inscricao);
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
}
