package com.example.ik_2dm3.ijcapp;

import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Activity_Plaza extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button btnAudio1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plaza);

        ConstraintLayout llPlaza=(ConstraintLayout) findViewById(R.id.llPlaza);
        btnAudio1=(Button) findViewById(R.id.btnAudio1);
        mediaPlayer=MediaPlayer.create(Activity_Plaza.this, R.raw.arrigorriagahistoriacastellano);

        //Le ponemos al boton del audio un listener para que cuando hagamos click se reproduzca el audio y se seshavbilite el boton
        btnAudio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                btnAudio1.setEnabled(false);
            }
        });

        //Le ponemos al boton del audio un listener para que cuando complete el audio se vuelva a habilitar el boton
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btnAudio1.setEnabled(true);
            }
        });

    }
}
