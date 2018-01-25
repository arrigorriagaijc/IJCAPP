package com.example.ik_2dm3.ijcapp;

import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pl.droidsonroids.gif.GifImageView;


public class Activity_Pantalla1 extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button btnAudio1;
    private GifImageView givMikel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        givMikel=(GifImageView) findViewById(R.id.givMikel);
        ConstraintLayout llPlaza=(ConstraintLayout) findViewById(R.id.llPlaza);
        btnAudio1=(Button) findViewById(R.id.btnAudio1);
        mediaPlayer=MediaPlayer.create(Activity_Pantalla1.this, R.raw.arrigorriagahistoriacastellano);

        //Hacemos que empiece parado poniendo la imagen
        givMikel.setBackgroundResource(R.drawable.mikel);
        //Le ponemos al boton del audio un listener para que cuando hagamos click se reproduzca el audio y se seshavbilite el boton
        btnAudio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                btnAudio1.setEnabled(false);
                //Activamos el gif, asignandolo al src
                givMikel.setBackgroundResource(R.drawable.mikelgif);


            }
        });

        //Le ponemos al boton del audio un listener para que cuando complete el audio se vuelva a habilitar el boton
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btnAudio1.setEnabled(true);
                mediaPlayer=MediaPlayer.create(Activity_Pantalla1.this, R.raw.arrigorriagahistoriacastellano);
                //Volvemos a desactivar el gif asignando la imagen
                givMikel.setBackgroundResource(R.drawable.mikel);
            }
        });

    }
}
