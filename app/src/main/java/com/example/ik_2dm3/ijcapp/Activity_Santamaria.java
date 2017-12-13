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
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class Activity_Santamaria extends AppCompatActivity {

    private Button btnSiguiente;
    private ConstraintLayout clEnunciado;
    private ImageView ivRespuestaBuena;
    private ImageView ivAcierto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__santamaria);

        //Enunciado del ejercicio
        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);
        clEnunciado=(ConstraintLayout) findViewById(R.id.clEnunciado);
        ivRespuestaBuena=(ImageView) findViewById(R.id.ivRespuestaBuena);

        ivAcierto.setImageDrawable(getResources().getDrawable(R.drawable.tick));
        ivAcierto.setMaxWidth(100);
        ivAcierto.setMaxHeight(100);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clEnunciado.setVisibility(View.GONE);
            }
        });


        //Primera pregunta
        ivRespuestaBuena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=new Toast(getApplicationContext());
                toast.setGravity(Gravity.CLIP_HORIZONTAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(ivAcierto);
                toast.show();
            }
        });


    }
}
