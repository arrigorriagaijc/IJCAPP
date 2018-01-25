package com.example.ik_2dm3.ijcapp;

import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Final extends AppCompatActivity {


    private MediaPlayer mediaPlayer;
    private GifImageView givMikelfinal;
    private ImageView ivInicial;
    private ImageView ivFinal;
    private TextView tvTexto;
    private ConstraintLayout clInicial;
    private ConstraintLayout clFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);



        clInicial=(ConstraintLayout) findViewById(R.id.clInicial);
        clFinal=(ConstraintLayout) findViewById(R.id.clFinal);
        givMikelfinal=(GifImageView) findViewById(R.id.givMikelfinal);
        ivInicial=(ImageView) findViewById(R.id.ivInicial);
        ivFinal=(ImageView) findViewById(R.id.ivFinal);
        tvTexto=(TextView) findViewById(R.id.tvTexto);

        mediaPlayer=MediaPlayer.create(Final.this, R.raw.arrigorriagahistoriacastellano);

        Runnable runnable=new Runnable(){
            @Override public void run() {

                clInicial.setVisibility(View.GONE);
                clFinal.setVisibility(View.VISIBLE);
            }
        };
        clInicial.postDelayed(runnable,3000);

    }
}
