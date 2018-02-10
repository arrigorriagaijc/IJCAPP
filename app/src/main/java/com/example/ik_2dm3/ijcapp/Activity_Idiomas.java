package com.example.ik_2dm3.ijcapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Locale;

public class Activity_Idiomas extends AppCompatActivity {

    private Locale myLocale;

    public Activity_Idiomas() throws FileNotFoundException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__idiomas);

        Button btnEuskera=(Button) findViewById(R.id.btnEuskera);
        Button btnCastellano=(Button) findViewById(R.id.btnEspañol);
        Button btnact4 = findViewById(R.id.btnact4);

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
                setLocale("fr");
                Intent intent=new Intent(getApplicationContext(), Activity_Inicio.class);
                startActivity(intent);
            }
        });

        btnact4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Activity_Pantalla6.class);
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
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed (){

    }

    public void setLocale(String lang) {
        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(myLocale);
        res.updateConfiguration(conf, dm);
    }

    // private Gson gson;

    public Locale getMyLocale() {
        return myLocale;
    }
}

