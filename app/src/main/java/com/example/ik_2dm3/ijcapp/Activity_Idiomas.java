package com.example.ik_2dm3.ijcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Activity_Idiomas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__idiomas);

        Button btnEuskera=(Button) findViewById(R.id.btnEuskera);
        Button btnCastellano=(Button) findViewById(R.id.btnEspañol);

        btnEuskera.setWidth(btnCastellano.getWidth());
    }
}
