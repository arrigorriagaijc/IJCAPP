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

import pl.droidsonroids.gif.GifImageView;

public class Activity_Inicio extends AppCompatActivity {
    private GifImageView GifMikel;
    private TextView txtPresentacion;
    private TextView txtIdioma;
    private ImageButton btnMap;
    private MediaPlayer mp ;
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__inicio);

        //El gif de mikel rico lo cargo
        GifMikel = (findViewById(R.id.mikelRicoView));

        //Creo un txt para pasarle el idioma ya que no se le puede pasar con txtPresentacion
        txtIdioma=(TextView) (findViewById(R.id.txtIdioma));

        //Cargo el txtPresentacion y le asigno la propiedad de que sea desplazable
        txtPresentacion = (TextView) (findViewById(R.id.txtPresentacion));
        txtPresentacion.setMovementMethod(new ScrollingMovementMethod());

        //Miro el idioma y en base a el pongo un audio u otro
        if(txtIdioma.getText().toString().equals("Onartu")){
            mp = MediaPlayer.create(Activity_Inicio.this, R.raw.mikelricoeuskera);
        }else{
            mp = MediaPlayer.create(Activity_Inicio.this, R.raw.mikelricocastellano);
        }

        //Inicio el mediaplayer
        mp.start();

        //Le ponemos al boton del audio un listener para que cuando complete el audio se vuelva a habilitar el boton
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //Volvemos a desactivar el gif asignando la imagen
                GifMikel.setBackgroundResource(R.drawable.mikel);
            }
        });

        //Asigno el boton de mapa y hago que al pulsar pase al siguiente activity
        btnMap = (findViewById(R.id.btnMapa));
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguienteActivity();
            }
        });

    }

    //Aqui paro el mediaplayer y paso a otro intent
    protected void siguienteActivity(){
                mp.stop();
                Intent intent=new Intent(getApplicationContext(), Pista1.class);
                startActivity(intent);
            }


    @Override
    public void onPause() {
        super.onPause();
        mp.stop();
    }

    @Override
    public void onBackPressed (){

    }

}

