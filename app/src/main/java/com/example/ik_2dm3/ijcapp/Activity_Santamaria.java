package com.example.ik_2dm3.ijcapp;

import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class Activity_Santamaria extends AppCompatActivity {

    private Button btnSiguiente;
    private ConstraintLayout clEnunciado;
    private ImageView ivRespuestaBuena;
    private ImageView ivRespuestaMala;
    private ImageView ivAcierto;
    private Button btnPregunta1;
    private int duracion;
    private Toast toast;
    private LinearLayout llPregunta1;
    private TextView tvRespuestaCorregida;
    private LinearLayout llRespuestas1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__santamaria);

        //Enunciado del ejercicio
        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);
        clEnunciado=(ConstraintLayout) findViewById(R.id.clEnunciado);
        ivRespuestaBuena=(ImageView) findViewById(R.id.ivRespuestaBuena);
        ivRespuestaMala=(ImageView) findViewById(R.id.ivRespuestaMala);
        btnPregunta1=(Button) findViewById(R.id.btnPregunta1);
        llPregunta1=(LinearLayout) findViewById(R.id.llPregunta1);
        tvRespuestaCorregida=(TextView) findViewById(R.id.tvRespuestaCorregida);
        llRespuestas1=(LinearLayout) findViewById(R.id.llRespuestas1);

        //Pasamos a la primera pregunta
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ocultamos el enunciado
                clEnunciado.setVisibility(View.GONE);
                //Mostramos la pregunta
                llPregunta1.setVisibility(View.VISIBLE);
            }
        });


        //Primera pregunta
        //Si acierta:
        ivRespuestaBuena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Cargamos el layout del tick
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.acierto,
                        (ViewGroup) findViewById(R.id.clAcierto));

                //Creamos el toast
                toast = new Toast(getApplicationContext());
                //Lo centramos
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                //Le ponemos duración corta
                toast.setDuration(Toast.LENGTH_SHORT);
                //Le asignamos el layout
                toast.setView(layout);
                //Lo mostramos
                toast.show();

                //Ocultamos la pregunta actual
                llPregunta1.setVisibility(View.GONE);
            }
        });
        //Si falla:
        ivRespuestaMala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cargamos el layout del tick
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.error,
                        (ViewGroup) findViewById(R.id.clError));

                //Creamos el toast
                toast = new Toast(getApplicationContext());
                //Lo centramos
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                //Le ponemos duración corta
                toast.setDuration(Toast.LENGTH_SHORT);
                //Le asignamos el layout
                toast.setView(layout);
                //Lo mostramos
                toast.show();

                //Ocultamos las respuestas
                llRespuestas1.setVisibility(View.GONE);
                //Mostramos la explicación:
                tvRespuestaCorregida.setVisibility(View.VISIBLE);
                //Mostramos el botón pregunta1:
                btnPregunta1.setVisibility(View.VISIBLE);
            }
        });

        //Si pulsa en siguiente se muestra la pregunta 2
        btnPregunta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ocultamos la pregunta1
                llPregunta1.setVisibility(View.GONE);
            }
        });



    }
}
