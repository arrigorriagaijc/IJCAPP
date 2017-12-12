package com.example.ik_2dm3.ijcapp;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Santamaria extends AppCompatActivity {

    private Button btnSiguiente;
    private ConstraintLayout clEnunciado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__santamaria);

        //Enunciado del ejercicio
        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);
        clEnunciado=(ConstraintLayout) findViewById(R.id.clEnunciado);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clEnunciado.setVisibility(View.GONE);
            }
        });

        //Primera pregunta


    }
}
