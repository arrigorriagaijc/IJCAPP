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
        if(txtPresentacion.getText().equals("Kaixo guztioi! Ongi etorri Arrigorriaka ezagutzeko APP-r!. Mikel Rico naiz, Athletic Club-eko jokalaria eta zuek bezala, Arrigorriakoa naiz. Goiz honetan zehar, zuekin egongo naiz txango hau egiten eta herria hobeto ezagutzen laguntzen, baina txangoa hasi baino lehen, herriari buruz lagungarria izan daitekeen zenbait gauza kontatuko diskizuet. Arrigorriaga, Bilboaldean dagoen herria da, Nerbioi ibaiaren joanean eta 12000 biztanle inguru ditu.\n\nGaurko egunan, herriak duen kultur ondoaren inguruan izango denez, dakizuenez Arrigorriagako kultur ondare gehiena erligiosoa dena (elizak, baselizak, tailuak…) baina eraikin zibilak ere badaude, bidai honetan zehar ezagutuko dituzuenak.\n\nBeraz, besterik gabe, egin KLIK nire azpian dagoen mapan; zuen txangoa hastera doa!")){
            mp = MediaPlayer.create(Activity_Inicio.this, R.raw.mikelricoeuskera);
        }else{
            mp = MediaPlayer.create(Activity_Inicio.this, R.raw.mikelricocastellano);
        }
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

