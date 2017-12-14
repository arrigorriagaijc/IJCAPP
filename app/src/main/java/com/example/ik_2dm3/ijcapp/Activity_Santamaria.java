package com.example.ik_2dm3.ijcapp;

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

public class Activity_Santamaria extends AppCompatActivity {

    private Button btnSiguiente;
    private ConstraintLayout clEnunciado;
    private ImageView ivRespuestaBuena1;
    private ImageView ivRespuestaMala1;
    private ImageView ivRespuestaBuena2;
    private ImageView ivRespuestaMala2;
    private ImageView ivRespuestaBuena3;
    private ImageView ivRespuestaMala3;
    private Button btnPregunta1;
    private Button btnPregunta2;
    private Button btnPregunta3;
    private Toast toast;
    private LinearLayout llPregunta1;
    private LinearLayout llPregunta2;
    private LinearLayout llPregunta3;
    private LinearLayout getLlPregunta3;
    private TextView tvRespuestaCorregida1;
    private TextView tvRespuestaCorregida2;
    private TextView tvRespuestaCorregida3;
    private LinearLayout llRespuestas1;
    private LinearLayout llRespuestas2;
    private LinearLayout llRespuestas3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__santamaria);

        //Enunciado del ejercicio
        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);
        clEnunciado=(ConstraintLayout) findViewById(R.id.clEnunciado);
        ivRespuestaBuena1=(ImageView) findViewById(R.id.ivRespuestaBuena1);
        ivRespuestaMala1=(ImageView) findViewById(R.id.ivRespuestaMala1);
        ivRespuestaBuena2=(ImageView) findViewById(R.id.ivRespuestaBuena2);
        ivRespuestaMala2=(ImageView) findViewById(R.id.ivRespuestaMala2);
        ivRespuestaBuena3=(ImageView) findViewById(R.id.ivRespuestaBuena3);
        ivRespuestaMala3=(ImageView) findViewById(R.id.ivRespuestaMala3);
        btnPregunta1=(Button) findViewById(R.id.btnPregunta1);
        btnPregunta2=(Button) findViewById(R.id.btnPregunta2);
        btnPregunta3=(Button) findViewById(R.id.btnPregunta3);
        llPregunta1=(LinearLayout) findViewById(R.id.llPregunta1);
        llPregunta2=(LinearLayout) findViewById(R.id.llPregunta2);
        llPregunta3=(LinearLayout) findViewById(R.id.llPregunta3);
        tvRespuestaCorregida1=(TextView) findViewById(R.id.tvRespuestaCorregida1);
        tvRespuestaCorregida2=(TextView) findViewById(R.id.tvRespuestaCorregida2);
        tvRespuestaCorregida3=(TextView) findViewById(R.id.tvRespuestaCorregida3);
        llRespuestas1=(LinearLayout) findViewById(R.id.llRespuestas1);
        llRespuestas2=(LinearLayout) findViewById(R.id.llRespuestas2);
        llRespuestas3=(LinearLayout) findViewById(R.id.llRespuestas3);


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
        ivRespuestaBuena1.setOnClickListener(new View.OnClickListener() {
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
                //Mostramos la pregunta 2
                llPregunta2.setVisibility(View.VISIBLE);
            }
        });
        //Si falla:
        ivRespuestaMala1.setOnClickListener(new View.OnClickListener() {
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
                tvRespuestaCorregida1.setVisibility(View.VISIBLE);
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
                //Mostramos la pregunta 2
                llPregunta2.setVisibility(View.VISIBLE);
            }
        });

        //Pregunta 2:
        //Si acierta:
        ivRespuestaBuena2.setOnClickListener(new View.OnClickListener() {
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
                llPregunta2.setVisibility(View.GONE);
                //Mostramos la pregunta 3
                llPregunta3.setVisibility(View.VISIBLE);
            }
        });
        //Si falla:
        ivRespuestaMala2.setOnClickListener(new View.OnClickListener() {
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
                llRespuestas2.setVisibility(View.GONE);
                //Mostramos la explicación:
                tvRespuestaCorregida2.setVisibility(View.VISIBLE);
                //Mostramos el botón pregunta 2:
                btnPregunta2.setVisibility(View.VISIBLE);
            }
        });

        //Si pulsa en siguiente se muestra la pregunta 3
        btnPregunta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ocultamos la pregunta2
                llPregunta2.setVisibility(View.GONE);
                //Mostramos la pregunta 3
                llPregunta3.setVisibility(View.VISIBLE);
            }
        });

        //Pregunta 3
        //Si acierta:
        ivRespuestaBuena3.setOnClickListener(new View.OnClickListener() {
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
                llPregunta3.setVisibility(View.GONE);
                //Mostramos la pregunta 4

            }
        });
        //Si falla:
        ivRespuestaMala3.setOnClickListener(new View.OnClickListener() {
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
                llRespuestas3.setVisibility(View.GONE);
                //Mostramos la explicación:
                tvRespuestaCorregida3.setVisibility(View.VISIBLE);
                //Mostramos el botón pregunta1:
                btnPregunta3.setVisibility(View.VISIBLE);
            }
        });

        //Si pulsa en siguiente se muestra la pregunta 2
        btnPregunta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ocultamos la pregunta 3
                llPregunta3.setVisibility(View.GONE);
                //Mostramos la pregunta 4
            }
        });


    }
}
