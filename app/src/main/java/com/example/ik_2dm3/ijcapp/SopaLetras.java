package com.example.ik_2dm3.ijcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class SopaLetras extends AppCompatActivity {

    private static final int FILAS = 9;
    private static final  int COLUMNAS = 11;
    private char c;
    private int[][] ids;
    private char [][] values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sopaletras);

        ids = new int[FILAS][COLUMNAS];
        values = new char[FILAS][COLUMNAS];
        LinearLayout llSopa=(LinearLayout) findViewById(R.id.llSopa);

        int ident = 0;
        for (int i = 0; i < COLUMNAS; i++) {
            LinearLayout l2 = new LinearLayout(this);
            l2.setOrientation(LinearLayout.VERTICAL);

            for (int j = 0; j < FILAS; j++) {
                Random r = new Random();
                c = (char)(r.nextInt(26) + 'a');


                values[j][i] = c;
                Letras letra = new Letras(this, j, i, c);

                ident++;
                letra.setId(ident);


                ids[j][i] = ident;

                letra.setFocusableInTouchMode(true);
                //letra.s
                l2.addView(letra);
            }
            l2.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.MATCH_PARENT ,1));
            llSopa.addView(l2);

        }
    }
}
