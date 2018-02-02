package com.example.ik_2dm3.ijcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Activity_Idiomas extends AppCompatActivity {

    public Activity_Idiomas() throws FileNotFoundException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__idiomas);

        Button btnEuskera=(Button) findViewById(R.id.btnEuskera);
        Button btnCastellano=(Button) findViewById(R.id.btnEspañol);

        btnEuskera.setWidth(btnCastellano.getWidth());

        btnCastellano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Activity_Inicio.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        btnEuskera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Activity_Inicio.class);
                startActivity(intent);
            }
        });

        String json = "";
        JsonResquest js = new JsonResquest();

        js.execute();
        try {
            FileOutputStream fOut = new FileOutputStream("/mnt/sdcard/test.txt");
            fOut.close();
            boolean changed = false;
            while (!changed) {
                if (json.compareTo("") == 0) {
                    js.execute();
                    json = js.getResult();
                } else {
                    changed = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


                System.out.println(json);
                Toast toast = Toast.makeText(this,json,Toast.LENGTH_LONG);
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
       // private Gson gson;

    }

