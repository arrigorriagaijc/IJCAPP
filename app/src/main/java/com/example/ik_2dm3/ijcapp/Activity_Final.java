package com.example.ik_2dm3.ijcapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

import static java.lang.Thread.sleep;

public class Activity_Final extends AppCompatActivity {


    private MediaPlayer mediaPlayer;
    private GifImageView givMikelfinal;
    private ImageView ivInicial;
    private ImageView ivFinal;
    private TextView tvFinal;
    private ConstraintLayout clInicial;
    private ConstraintLayout clFinal;
    private Handler handler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        givMikelfinal=(GifImageView) findViewById(R.id.givMikelfinal);
        ivInicial=(ImageView) findViewById(R.id.ivInicial);
        ivFinal=(ImageView) findViewById(R.id.ivFinal);
        tvFinal =(TextView) findViewById(R.id.tvTexto);
        clInicial=(ConstraintLayout) findViewById(R.id.clInicial);
        clFinal=(ConstraintLayout) findViewById(R.id.clFinal);

        if(tvFinal.getText().equals("ZORIONAK! Gure herriko eraikin garrantzitsuenak ezagutzeko aukera izan duzue eta horrekin bat historia piska bat.\n\nEspero dut orain eraikin hauen garrantziaz gogoratzea hauen aldetik pasatzen zaretenean.\n\nOndo ibili lagunok!")){
            mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.zorionak);
            ivInicial.setImageDrawable(getResources().getDrawable(R.drawable.zorionak));
        }else {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.felicidades);
            ivInicial.setImageDrawable(getResources().getDrawable(R.drawable.felicidades));
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                clInicial.setVisibility(View.GONE);
                clFinal.setVisibility(View.VISIBLE);
                mediaPlayer.start();
            }
        },5000);

        //Le ponemos al boton del audio un listener para que cuando complete el audio se vuelva a habilitar el boton
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                givMikelfinal.setBackgroundResource(R.drawable.mikel);
                //Cerramos el programa completo
               //finish();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }

    @Override
    public void onBackPressed (){

    }
}