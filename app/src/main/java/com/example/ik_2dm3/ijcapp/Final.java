package com.example.ik_2dm3.ijcapp;

import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Final extends AppCompatActivity {


    private MediaPlayer mediaPlayer;
    private GifImageView givMikelfinal;
    private ImageView IVFinal;
    private ImageView IVFinal2;
    private TextView TVFianal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        givMikelfinal=(GifImageView) findViewById(R.id.givMikelfinal);
        IVFinal=(ImageView) findViewById(R.id.IVFinal);
        IVFinal2=(ImageView) findViewById(R.id.IVFinal2);
        TVFianal=(TextView) findViewById(R.id.TVFinal);
        ConstraintLayout CLFinal=(ConstraintLayout) findViewById(R.id.CLFinal);
        mediaPlayer=MediaPlayer.create(Final.this, R.raw.arrigorriagahistoriacastellano);
    }
}
