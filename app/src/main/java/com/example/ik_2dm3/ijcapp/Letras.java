package com.example.ik_2dm3.ijcapp;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Letras extends android.support.v7.widget.AppCompatButton
{
    public int x = 0 ;
    public int y = 0;

    public char letra='A';
    //dice cual es el fondo yen este cado el dibujito

    public Letras(Context context, int x, int y, char letra){
        super(context);
        this.x=x;
        this.y=y;
        this.letra=letra;

        this.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.MATCH_PARENT,1));
        this.setText(String.valueOf(letra).toUpperCase());
        //this.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        //this.setPadding(0,10,0,10);
    }
}
