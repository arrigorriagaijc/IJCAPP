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
    private ImageView ivRespuestaBuena4;
    private ImageView ivRespuestaMala4;
    private Button btnPregunta1;
    private Button btnPregunta2;
    private Button btnPregunta3;
    private Button btnPregunta4;
    private Toast toast;
    private LinearLayout llPregunta1;
    private LinearLayout llPregunta2;
    private LinearLayout llPregunta3;
    private LinearLayout llPregunta4;
    private ConstraintLayout clCorregido1;
    private ConstraintLayout clCorregido2;
    private ConstraintLayout clCorregido3;
    private LinearLayout llRespuestas1;
    private LinearLayout llRespuestas2;
    private LinearLayout llRespuestas3;
    private LinearLayout llRespuestas4;
    private LinearLayout llSantaMaria;
    private ConstraintLayout clPregunta4;
    private ConstraintLayout clExplicacion;
    private Button btnExplicacion;
    private ConstraintLayout clPregunta5;
    private LinearLayout llRespuestas51;
    private LinearLayout llRespuestas52;
    private TextView tvRespuestaCorregida5;
    private Button btnPregunta5;
    private ImageView ivRespuestaBuena5;
    private ImageView ivRespuestaMala511;
    private ImageView ivRespuestaMala521;
    private ImageView ivRespuestaMala522;
    private LinearLayout llPregunta5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__santamaria);

        //Enunciado del ejercicio
        llSantaMaria=(LinearLayout) findViewById(R.id.llSantaMaria);
        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);
        clEnunciado=(ConstraintLayout) findViewById(R.id.clEnunciado);
        ivRespuestaBuena1=(ImageView) findViewById(R.id.ivRespuestaBuena1);
        ivRespuestaMala1=(ImageView) findViewById(R.id.ivRespuestaMala1);
        ivRespuestaBuena2=(ImageView) findViewById(R.id.ivRespuestaBuena2);
        ivRespuestaMala2=(ImageView) findViewById(R.id.ivRespuestaMala2);
        ivRespuestaBuena3=(ImageView) findViewById(R.id.ivRespuestaBuena3);
        ivRespuestaMala3=(ImageView) findViewById(R.id.ivRespuestaMala3);
        ivRespuestaBuena4=(ImageView) findViewById(R.id.ivRespuestaBuena4);
        ivRespuestaMala4=(ImageView) findViewById(R.id.ivRespuestaMala4);
        ivRespuestaBuena5=(ImageView) findViewById(R.id.ivRespuestaBuena5);
        ivRespuestaMala511=(ImageView) findViewById(R.id.ivRespuestaMala511);
        ivRespuestaMala521=(ImageView) findViewById(R.id.ivRespuestaMala521);
        ivRespuestaMala522=(ImageView) findViewById(R.id.ivRespuestaMala522);
        btnPregunta1=(Button) findViewById(R.id.btnPregunta1);
        btnPregunta2=(Button) findViewById(R.id.btnPregunta2);
        btnPregunta3=(Button) findViewById(R.id.btnPregunta3);
        btnPregunta4=(Button) findViewById(R.id.btnPregunta4);
        llPregunta1=(LinearLayout) findViewById(R.id.llPregunta1);
        llPregunta2=(LinearLayout) findViewById(R.id.llPregunta2);
        llPregunta3=(LinearLayout) findViewById(R.id.llPregunta3);
        llPregunta4=(LinearLayout) findViewById(R.id.llPregunta4);
        llPregunta5=(LinearLayout) findViewById(R.id.llPregunta5);
        clCorregido1=(ConstraintLayout) findViewById(R.id.clCorregido1);
        clCorregido2=(ConstraintLayout) findViewById(R.id.clCorregido2);
        clCorregido3=(ConstraintLayout) findViewById(R.id.clCorregido3);
        llRespuestas1=(LinearLayout) findViewById(R.id.llRespuestas1);
        llRespuestas2=(LinearLayout) findViewById(R.id.llRespuestas2);
        llRespuestas3=(LinearLayout) findViewById(R.id.llRespuestas3);
        llRespuestas4=(LinearLayout) findViewById(R.id.llRespuestas4);
        clPregunta4=(ConstraintLayout) findViewById(R.id.clPregunta4);
        clExplicacion=(ConstraintLayout) findViewById(R.id.clExplicacion);
        btnExplicacion=(Button) findViewById(R.id.btnExplicacion);
        clPregunta5=(ConstraintLayout) findViewById(R.id.clPregunta5);
        llRespuestas51=(LinearLayout) findViewById(R.id.llRespuestas51);
        llRespuestas52=(LinearLayout) findViewById(R.id.llRespuestas52);
        tvRespuestaCorregida5=(TextView) findViewById(R.id.tvRespuestaCorregida5);
        btnPregunta5=(Button) findViewById(R.id.btnPregunta5);


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
                clCorregido1.setVisibility(View.VISIBLE);
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
                clCorregido2.setVisibility(View.VISIBLE);
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
                llPregunta4.setVisibility(View.VISIBLE);
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
                clCorregido3.setVisibility(View.VISIBLE);
                //Mostramos el botón pregunta1:
                btnPregunta3.setVisibility(View.VISIBLE);
            }
        });
//
        //Si pulsa en siguiente se muestra la pregunta 4
        btnPregunta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ocultamos la pregunta 3
                llPregunta3.setVisibility(View.GONE);
                //Mostramos la pregunta 4
                llPregunta4.setVisibility(View.VISIBLE);
            }
        });

        //Pregunta 4
        //Si acierta:
        ivRespuestaBuena4.setOnClickListener(new View.OnClickListener() {
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
                clPregunta4.setVisibility(View.GONE);
                //Ocutamos las respuestas
                llRespuestas4.setVisibility(View.GONE);
                //Cambiamos el bacground
                llSantaMaria.setBackground(getResources().getDrawable(R.drawable.santamariamagdalena));
                //Mostramos el botón pregunta 4:
                btnPregunta4.setVisibility(View.VISIBLE);
            }
        });
        //Si falla:
        ivRespuestaMala4.setOnClickListener(new View.OnClickListener() {
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

                //Ocultamos la pregunta actual
                clPregunta4.setVisibility(View.GONE);
                //Ocutamos las respuestas
                llRespuestas4.setVisibility(View.GONE);
                //Cambiamos el bacground
                llSantaMaria.setBackground(getResources().getDrawable(R.drawable.santamariamagdalena));
                //Mostramos el botón pregunta 4:
                btnPregunta4.setVisibility(View.VISIBLE);
            }
        });

        //Si pulsa en siguiente se pasa a la explicacion
        btnPregunta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ocultamos la pregunta 3
                llPregunta4.setVisibility(View.GONE);
                //Cambiamos el bacground
                llSantaMaria.setBackground(getResources().getDrawable(R.drawable.santamariafondo));
                //Pasamos a la explicacion
                clExplicacion.setVisibility(View.VISIBLE);
            }
        });

        //Explicacion
        //Paso a la ultima pregunta
        btnExplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Oculto la explicacion
                clExplicacion.setVisibility(View.GONE);
                //Paso a la utlima pregunta
                llPregunta5.setVisibility(View.VISIBLE);
            }
        });

        //Pregunta 5
        //Si acierta:
        ivRespuestaBuena5.setOnClickListener(new View.OnClickListener() {
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
                clPregunta5.setVisibility(View.GONE);
                //Ocutamos las respuestas
                llRespuestas51.setVisibility(View.GONE);
                llRespuestas52.setVisibility(View.GONE);
                //Cambiamos el bacground
                llSantaMaria.setBackground(getResources().getDrawable(R.drawable.sanpedroabrisketa));
                //Mostramos la respuesta corregida
                tvRespuestaCorregida5.setVisibility(View.VISIBLE);
                //Mostramos el botón pregunta 5:
                btnPregunta5.setVisibility(View.VISIBLE);
            }
        });
        //Si falla:
        ivRespuestaMala511.setOnClickListener(new View.OnClickListener() {
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

                //Ocultamos la pregunta actual
                clPregunta5.setVisibility(View.GONE);
                //Ocutamos las respuestas
                llRespuestas51.setVisibility(View.GONE);
                llRespuestas52.setVisibility(View.GONE);
                //Cambiamos el bacground
                llSantaMaria.setBackground(getResources().getDrawable(R.drawable.sanpedroabrisketa));
                //Mostramos la respuesta corregida
                tvRespuestaCorregida5.setVisibility(View.VISIBLE);
                //Mostramos el botón pregunta 5:
                btnPregunta5.setVisibility(View.VISIBLE);
            }
        });

        ivRespuestaMala521.setOnClickListener(new View.OnClickListener() {
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

                //Ocultamos la pregunta actual
                clPregunta5.setVisibility(View.GONE);
                //Ocutamos las respuestas
                llRespuestas51.setVisibility(View.GONE);
                llRespuestas52.setVisibility(View.GONE);
                //Cambiamos el bacground
                llSantaMaria.setBackground(getResources().getDrawable(R.drawable.sanpedroabrisketa));
                //Mostramos la respuesta corregida
                tvRespuestaCorregida5.setVisibility(View.VISIBLE);
                //Mostramos el botón pregunta 5:
                btnPregunta5.setVisibility(View.VISIBLE);
            }
        });

        ivRespuestaMala522.setOnClickListener(new View.OnClickListener() {
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

                //Ocultamos la pregunta actual
                clPregunta5.setVisibility(View.GONE);
                //Ocutamos las respuestas
                llRespuestas51.setVisibility(View.GONE);
                llRespuestas52.setVisibility(View.GONE);
                //Cambiamos el bacground
                llSantaMaria.setBackground(getResources().getDrawable(R.drawable.sanpedroabrisketa));
                //Mostramos la respuesta corregida
                tvRespuestaCorregida5.setVisibility(View.VISIBLE);
                //Mostramos el botón pregunta 5:
                btnPregunta5.setVisibility(View.VISIBLE);
            }
        });

        //Si pulsa en siguiente se acaba
        btnPregunta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
