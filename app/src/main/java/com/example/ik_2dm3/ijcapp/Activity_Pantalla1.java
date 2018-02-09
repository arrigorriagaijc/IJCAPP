package com.example.ik_2dm3.ijcapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;


public class Activity_Pantalla1 extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private ImageButton btnAudio1;
    private GifImageView givMikel;
    private TextView tvZona1;
    private Button btnSaltarAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        //Cogemos el tvZona1
        tvZona1=(TextView) findViewById(R.id.tvZona1);

        givMikel=(GifImageView) findViewById(R.id.givMikel);
        ConstraintLayout llPlaza=(ConstraintLayout) findViewById(R.id.llPlaza);
        btnAudio1=(ImageButton) findViewById(R.id.btnAudio1);
        if(tvZona1.getText().equals("Arrigorriagako plazari buruzko audio hau entzun ezazu.")){
            mediaPlayer=MediaPlayer.create(Activity_Pantalla1.this, R.raw.arrigorriagahistoriaeuskera);
        }else {
            mediaPlayer = MediaPlayer.create(Activity_Pantalla1.this, R.raw.arrigorriagahistoriacastellano);
        }
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
                Intent intent=new Intent(getApplicationContext(), Pista2.class);
                startActivity(intent);
            }
        });

        //Añado el boton de saltar audio
        btnSaltarAudio=(Button) findViewById(R.id.btnSaltarAudio);

        //Añado el listener al boton de saltar el audio para que lo pare y aparezca la sopa de letras
        btnSaltarAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                Intent intent=new Intent(getApplicationContext(), Pista2.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed (){

    }
}
