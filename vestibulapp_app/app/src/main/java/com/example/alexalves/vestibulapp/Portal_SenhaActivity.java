package com.example.alexalves.vestibulapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Portal_SenhaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal__senha);
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
