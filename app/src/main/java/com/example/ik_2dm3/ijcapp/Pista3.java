package com.example.ik_2dm3.ijcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Pista3 extends AppCompatActivity {
    private Button btnSiguiente;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pista3);

        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);
        radioButton=(RadioButton) findViewById(R.id.radioButton);
        radioButton2=(RadioButton) findViewById(R.id.radioButton2);
        radioButton3=(RadioButton) findViewById(R.id.radioButton3);



        //Coprobacion de la pregunta si esta bien al darle al boton y crear el toast

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton.isChecked()==true) {
                    //Cargamos el layout de la X
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
                } else
                if (radioButton2.isChecked()==true) {
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
                    Intent intent=new Intent(Pista3.this, Activity_Mapa.class);
                    intent.putExtra("Pista3", "Pista3");
                    startActivity(intent);
                    finish();
                } else
                if (radioButton3.isChecked()==true) {
                    //Cargamos el layout de la X
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
                }

            }
        });


    }

    @Override
    public void onBackPressed (){

    }
}
