package com.example.ik_2dm3.ijcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pista1 extends AppCompatActivity {

    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pista1);

        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Pista1.this, Activity_Mapa.class);
                intent.putExtra("Pista1", "Pista1");
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed (){

    }
}
