package com.example.ik_2dm3.ijcapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Activity_Plaza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plaza);

        LinearLayout llPlaza=(LinearLayout) findViewById(R.id.llPlaza);
        Button btnAudio1=(Button) findViewById(R.id.btnAudio1);
        btnAudio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(Activity_Plaza.this, R.raw.arrigorriagahistoriacastellano);
                if (mediaPlayer.isPlaying()){

                }else{
                    mediaPlayer.start();
                }

            }
        });

    }
}
