package com.example.ik_2dm3.ijcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Pantalla6 extends AppCompatActivity {

    private Button btnSiguiente;
    private int preguntas =1;

    private TextView txtPregunta, txtOpcion1,txtOpcion2,txtOpcion3;
    private ImageView imgPregunta;

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
            }
        });

        txtOpcion1 = findViewById(R.id.txtOpcion1);
        txtOpcion2 = findViewById(R.id.txtOpcion2);
        txtOpcion3 = findViewById(R.id.txtOpcion3);
        txtPregunta = findViewById(R.id.txtPregunta);
        imgPregunta = findViewById(R.id.imgPregunta);

        //listeners

        txtOpcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobar(1);
            }
        });
        txtOpcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobar(2);
            }
        });
        txtOpcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobar(3);
            }
        });
    }

    private void comprobar(int opc){
        if(preguntas <4){
            switch (preguntas){
                case 1:
                    if(opc==1){
                        correcto();
                    }else incorrecto();
                    break;
                case 2:
                    if(opc==2){
                        correcto();
                    }else incorrecto();
                    break;
                case 3:
                    if(opc==1){
                        correcto();
                    }else incorrecto();
                    break;
            }
        }

    }
    private void correcto(){
       preguntas++;
        switch (preguntas){
            case 2:
                imgPregunta.setImageResource(R.drawable.jeroglificospregunta2);
                txtPregunta.setText(getResources().getString(R.string.jrgPregunta2));
                txtOpcion1.setText(getResources().getString(R.string.jrgp2Opc1));
                txtOpcion2.setText(getResources().getString(R.string.jrgp2Opc2));
                txtOpcion3.setText(getResources().getString(R.string.jrgp2Opc3));
                break;
            case 3:
                imgPregunta.setImageResource(R.drawable.jeroglificospregunta3);
                txtPregunta.setText(getResources().getString(R.string.jrgPregunta3));
                txtOpcion1.setText(getResources().getString(R.string.jrgp3Opc1));
                txtOpcion2.setText(getResources().getString(R.string.jrgp3Opc2));
                txtOpcion3.setText(getResources().getString(R.string.jrgp3Opc3));
                break;
            case 4:
                btnSiguiente.setVisibility(View.VISIBLE);
                break;
        }
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.acierto,
                (ViewGroup) findViewById(R.id.clAcierto));
        //Creamos el toast
        Toast toast;
        toast = new Toast(getApplicationContext());
        //Lo centramos
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        //Le ponemos duración corta
        toast.setDuration(Toast.LENGTH_SHORT);
        //Le asignamos el layout
        toast.setView(layout);
        //Lo mostramos
        toast.show();



    }

    private void incorrecto(){
        //Creamos el toast
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.error,
                (ViewGroup) findViewById(R.id.clError));
        Toast toast;
        toast = new Toast(getApplicationContext());
        //Lo centramos
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        //Le ponemos duración corta
        toast.setDuration(Toast.LENGTH_SHORT);
        //Le asignamos el layout
        toast.setView(layout);
        //Lo mostramos
        toast.show();
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
