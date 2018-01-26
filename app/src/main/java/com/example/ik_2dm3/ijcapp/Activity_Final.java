package com.example.ik_2dm3.ijcapp;

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
        mediaPlayer=MediaPlayer.create(Activity_Final.this, R.raw.arrigorriagahistoriacastellano);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                clInicial.setVisibility(View.GONE);
                clFinal.setVisibility(View.VISIBLE);
            }
        },5000);
    }
    @Override
    public void onBackPressed (){

    }
}
