package com.example.ik_2dm3.ijcapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Inicio extends AppCompatActivity {
    private ImageView imgMikel;
    private TextView txtPresentacion;
    private ImageButton btnMap;
    private MediaPlayer mp ;
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__inicio);
        imgMikel = (findViewById(R.id.mikelRicoView));
        txtPresentacion = (findViewById(R.id.txtPresentacion));
        mp = MediaPlayer.create(Activity_Inicio.this, R.raw.mikelricocastellano);
        txtPresentacion.setMovementMethod(new ScrollingMovementMethod());
        mp.start();
        btnMap = (findViewById(R.id.btnMapa));
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguienteActivity();
            }
        });

    }

    protected void siguienteActivity(){
                mp.stop();
                Intent intent=new Intent(getApplicationContext(), Pista1.class);
                startActivity(intent);
            }


    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"REventado");
        finish();
    }

    @Override
    public void onBackPressed (){

    }

}

