package com.example.ik_2dm3.ijcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Pantalla6 extends AppCompatActivity {

    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pantalla6);

        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Activity_Final.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed (){

    }
}
