package com.example.ik_2dm3.ijcapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
//

public class SopaLetras extends AppCompatActivity {

    private static final String TAG = "TAG";
    private final Rect mHitRect = new Rect();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sopaletras);

        char c;
        final ArrayList<TextView> arrayListTextView=new ArrayList<>();
        Random r = new Random();
        final float[] posX = new float[1];
        final float[] posY = new float[1];
        final int[] loc = new int[2];

        TextView tv1=(TextView) findViewById(R.id.tv1);
        arrayListTextView.add(tv1);
        TextView tv2=(TextView) findViewById(R.id.tv2);
        arrayListTextView.add(tv2);
        TextView tv3=(TextView) findViewById(R.id.tv3);
        arrayListTextView.add(tv3);
        TextView tv4=(TextView) findViewById(R.id.tv4);
        arrayListTextView.add(tv4);
        TextView tv5=(TextView) findViewById(R.id.tv5);
        arrayListTextView.add(tv5);
        TextView tv6=(TextView) findViewById(R.id.tv6);
        arrayListTextView.add(tv6);
        TextView tv7=(TextView) findViewById(R.id.tv7);
        arrayListTextView.add(tv7);
        TextView tv8=(TextView) findViewById(R.id.tv8);
        arrayListTextView.add(tv8);
        TextView tv9=(TextView) findViewById(R.id.tv9);
        arrayListTextView.add(tv9);
        TextView tv10=(TextView) findViewById(R.id.tv10);
        arrayListTextView.add(tv10);
        TextView tv11=(TextView) findViewById(R.id.tv11);
        arrayListTextView.add(tv11);
        TextView tv12=(TextView) findViewById(R.id.tv12);
        arrayListTextView.add(tv12);
        TextView tv13=(TextView) findViewById(R.id.tv13);
        arrayListTextView.add(tv13);
        TextView tv14=(TextView) findViewById(R.id.tv14);
        arrayListTextView.add(tv14);
        TextView tv15=(TextView) findViewById(R.id.tv15);
        arrayListTextView.add(tv15);
        TextView tv16=(TextView) findViewById(R.id.tv16);
        arrayListTextView.add(tv16);
        TextView tv17=(TextView) findViewById(R.id.tv17);
        arrayListTextView.add(tv17);
        TextView tv18=(TextView) findViewById(R.id.tv18);
        arrayListTextView.add(tv18);
        TextView tv19=(TextView) findViewById(R.id.tv19);
        arrayListTextView.add(tv19);
        TextView tv20=(TextView) findViewById(R.id.tv20);
        arrayListTextView.add(tv20);
        TextView tv21=(TextView) findViewById(R.id.tv21);
        arrayListTextView.add(tv21);
        TextView tv22=(TextView) findViewById(R.id.tv22);
        arrayListTextView.add(tv22);
        TextView tv23=(TextView) findViewById(R.id.tv23);
        arrayListTextView.add(tv23);
        TextView tv24=(TextView) findViewById(R.id.tv24);
        arrayListTextView.add(tv24);
        TextView tv25=(TextView) findViewById(R.id.tv25);
        arrayListTextView.add(tv25);
        TextView tv26=(TextView) findViewById(R.id.tv26);
        arrayListTextView.add(tv26);
        TextView tv27=(TextView) findViewById(R.id.tv27);
        arrayListTextView.add(tv27);
        TextView tv28=(TextView) findViewById(R.id.tv28);
        arrayListTextView.add(tv28);
        TextView tv29=(TextView) findViewById(R.id.tv29);
        arrayListTextView.add(tv29);
        TextView tv30=(TextView) findViewById(R.id.tv30);
        arrayListTextView.add(tv30);
        TextView tv31=(TextView) findViewById(R.id.tv31);
        arrayListTextView.add(tv31);
        TextView tv32=(TextView) findViewById(R.id.tv32);
        arrayListTextView.add(tv32);
        TextView tv33=(TextView) findViewById(R.id.tv33);
        arrayListTextView.add(tv33);
        TextView tv34=(TextView) findViewById(R.id.tv34);
        arrayListTextView.add(tv34);
        TextView tv35=(TextView) findViewById(R.id.tv35);
        arrayListTextView.add(tv35);
        TextView tv36=(TextView) findViewById(R.id.tv36);
        arrayListTextView.add(tv36);
        TextView tv37=(TextView) findViewById(R.id.tv37);
        arrayListTextView.add(tv37);
        TextView tv38=(TextView) findViewById(R.id.tv38);
        arrayListTextView.add(tv38);
        TextView tv39=(TextView) findViewById(R.id.tv39);
        arrayListTextView.add(tv39);
        TextView tv40=(TextView) findViewById(R.id.tv40);
        arrayListTextView.add(tv40);
        TextView tv41=(TextView) findViewById(R.id.tv41);
        arrayListTextView.add(tv41);
        TextView tv42=(TextView) findViewById(R.id.tv42);
        arrayListTextView.add(tv42);
        TextView tv43=(TextView) findViewById(R.id.tv43);
        arrayListTextView.add(tv43);
        TextView tv44=(TextView) findViewById(R.id.tv44);
        arrayListTextView.add(tv44);
        TextView tv45=(TextView) findViewById(R.id.tv45);
        arrayListTextView.add(tv45);
        TextView tv46=(TextView) findViewById(R.id.tv46);
        arrayListTextView.add(tv46);
        TextView tv47=(TextView) findViewById(R.id.tv47);
        arrayListTextView.add(tv47);
        TextView tv48=(TextView) findViewById(R.id.tv48);
        arrayListTextView.add(tv48);
        TextView tv49=(TextView) findViewById(R.id.tv49);
        arrayListTextView.add(tv49);
        TextView tv50=(TextView) findViewById(R.id.tv50);
        arrayListTextView.add(tv50);
        TextView tv51=(TextView) findViewById(R.id.tv51);
        arrayListTextView.add(tv51);
        TextView tv52=(TextView) findViewById(R.id.tv52);
        arrayListTextView.add(tv52);
        TextView tv53=(TextView) findViewById(R.id.tv53);
        arrayListTextView.add(tv53);
        TextView tv54=(TextView) findViewById(R.id.tv54);
        arrayListTextView.add(tv54);
        TextView tv55=(TextView) findViewById(R.id.tv55);
        arrayListTextView.add(tv55);
        TextView tv56=(TextView) findViewById(R.id.tv56);
        arrayListTextView.add(tv56);
        TextView tv57=(TextView) findViewById(R.id.tv57);
        arrayListTextView.add(tv57);
        TextView tv58=(TextView) findViewById(R.id.tv58);
        arrayListTextView.add(tv58);
        TextView tv59=(TextView) findViewById(R.id.tv59);
        arrayListTextView.add(tv59);
        TextView tv60=(TextView) findViewById(R.id.tv60);
        arrayListTextView.add(tv60);
        TextView tv61=(TextView) findViewById(R.id.tv61);
        arrayListTextView.add(tv61);
        TextView tv62=(TextView) findViewById(R.id.tv62);
        arrayListTextView.add(tv62);
        TextView tv63=(TextView) findViewById(R.id.tv63);
        arrayListTextView.add(tv63);
        TextView tv64=(TextView) findViewById(R.id.tv64);
        arrayListTextView.add(tv64);
        TextView tv65=(TextView) findViewById(R.id.tv65);
        arrayListTextView.add(tv65);
        TextView tv66=(TextView) findViewById(R.id.tv66);
        arrayListTextView.add(tv66);
        TextView tv67=(TextView) findViewById(R.id.tv67);
        arrayListTextView.add(tv67);
        TextView tv68=(TextView) findViewById(R.id.tv68);
        arrayListTextView.add(tv68);
        TextView tv69=(TextView) findViewById(R.id.tv69);
        arrayListTextView.add(tv69);
        TextView tv70=(TextView) findViewById(R.id.tv70);
        arrayListTextView.add(tv70);
        TextView tv71=(TextView) findViewById(R.id.tv71);
        arrayListTextView.add(tv71);
        TextView tv72=(TextView) findViewById(R.id.tv72);
        arrayListTextView.add(tv72);
        TextView tv73=(TextView) findViewById(R.id.tv73);
        arrayListTextView.add(tv73);
        TextView tv74=(TextView) findViewById(R.id.tv74);
        arrayListTextView.add(tv74);
        TextView tv75=(TextView) findViewById(R.id.tv75);
        arrayListTextView.add(tv75);
        TextView tv76=(TextView) findViewById(R.id.tv76);
        arrayListTextView.add(tv76);
        TextView tv77=(TextView) findViewById(R.id.tv77);
        arrayListTextView.add(tv77);
        TextView tv78=(TextView) findViewById(R.id.tv78);
        arrayListTextView.add(tv78);
        TextView tv79=(TextView) findViewById(R.id.tv79);
        arrayListTextView.add(tv79);
        TextView tv80=(TextView) findViewById(R.id.tv80);
        arrayListTextView.add(tv80);
        TextView tv81=(TextView) findViewById(R.id.tv81);
        arrayListTextView.add(tv81);
        TextView tv82=(TextView) findViewById(R.id.tv82);
        arrayListTextView.add(tv82);
        TextView tv83=(TextView) findViewById(R.id.tv83);
        arrayListTextView.add(tv83);
        TextView tv84=(TextView) findViewById(R.id.tv84);
        arrayListTextView.add(tv84);
        TextView tv85=(TextView) findViewById(R.id.tv85);
        arrayListTextView.add(tv85);
        TextView tv86=(TextView) findViewById(R.id.tv86);
        arrayListTextView.add(tv86);
        TextView tv87=(TextView) findViewById(R.id.tv87);
        arrayListTextView.add(tv87);
        TextView tv88=(TextView) findViewById(R.id.tv88);
        arrayListTextView.add(tv88);
        TextView tv89=(TextView) findViewById(R.id.tv89);
        arrayListTextView.add(tv89);
        TextView tv90=(TextView) findViewById(R.id.tv90);
        arrayListTextView.add(tv90);
        TextView tv91=(TextView) findViewById(R.id.tv91);
        arrayListTextView.add(tv91);
        TextView tv92=(TextView) findViewById(R.id.tv92);
        arrayListTextView.add(tv92);
        TextView tv93=(TextView) findViewById(R.id.tv93);
        arrayListTextView.add(tv93);
        TextView tv94=(TextView) findViewById(R.id.tv94);
        arrayListTextView.add(tv94);
        TextView tv95=(TextView) findViewById(R.id.tv95);
        arrayListTextView.add(tv95);
        TextView tv96=(TextView) findViewById(R.id.tv96);
        arrayListTextView.add(tv96);
        TextView tv97=(TextView) findViewById(R.id.tv97);
        arrayListTextView.add(tv97);
        TextView tv98=(TextView) findViewById(R.id.tv98);
        arrayListTextView.add(tv98);
        TextView tv99=(TextView) findViewById(R.id.tv99);
        arrayListTextView.add(tv99);

        for(int i=0;i<99;i++){
            c = (char)(r.nextInt(26) + 'a');
            arrayListTextView.get(i).setText(String.valueOf(c).toUpperCase());
            arrayListTextView.get(i).setFocusable(true);
            arrayListTextView.get(i).setFocusableInTouchMode(true);
            arrayListTextView.get(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            ((TextView) v).setBackgroundColor(Color.parseColor("#E4E663"));
                            break;
                        case MotionEvent.ACTION_UP:
                            ((TextView) v).setBackgroundColor(Color.parseColor("#FFFFFF"));
                            break;
                        case MotionEvent.ACTION_MOVE:
                            ((TextView) v).setBackgroundColor(Color.parseColor("#E4E663"));
                            posX[0] =event.getRawX();
                            posY[0] =event.getRawY();
                            int posiX=(int)posX[0];
                            int posiY=(int)posY[0];
                            Log.d(TAG,"X: "+Integer.toString(posiX));
                            Log.d(TAG,"Y: "+Integer.toString(posiY));

                            for(int j=0;j<99;j++){
                                Rect hitRect = mHitRect;
                                arrayListTextView.get(j).getHitRect(hitRect);
                                Log.d(TAG,"Pos: "+Integer.toString(j+1)+"X: "+Integer.toString((int)hitRect.exactCenterX())+"Y: "+Integer.toString((int)hitRect.exactCenterY()));
                                if (hitRect.contains(posiX, posiY)) {
                                    arrayListTextView.get(j).setBackgroundColor(Color.parseColor("#E4E663"));
                                    Log.d(TAG,"Estas dentro");
                                }
                            }
                            break;
                        default:
                            break;
                    }

                    return true;
                }
            });


/*
            arrayListTextView.get(i).setOnHoverListener(new View.OnHoverListener() {
                @Override
                public boolean onHover(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_HOVER_ENTER:
                            ((TextView) v).setBackgroundColor(Color.parseColor("#E4E663"));
                            break;
                        case MotionEvent.ACTION_HOVER_MOVE:
                            ((TextView) v).setBackgroundColor(Color.parseColor("#E4E663"));
                            break;
                        case MotionEvent.ACTION_HOVER_EXIT:
                            ((TextView) v).setBackgroundColor(Color.parseColor("#E4E663"));
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            });
*/
/*
            arrayListTextView.get(i).setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        ((TextView) v).setBackgroundColor(Color.parseColor("#E4E663"));
                    }
                }
            }); */
            /*
            if(arrayListTextView.get(i).isFocused()){
                arrayListTextView.get(i).setBackgroundColor(Color.parseColor("#E4E663"));
            }*/

        }






        /*
        int ident = 0;
        for (int i = 0; i < FILAS; i++) {
            LinearLayout l2=arrayListLinearLayout.get(i);
            for (int j=0; j < COLUMNAS; j++) {

                Random r = new Random();
                c = (char)(r.nextInt(26) + 'a');


                values[i][j] = c;
                Letras letra = new Letras(this, j, i, c);


                ident++;
                letra.setId(ident);


                ids[i][j] = ident;

                //letra.setFocusableInTouchMode(true);
                l2.addView(letra);
                String dato=new String(String.valueOf(j));
                Log.d(TAG,dato);
            }
        }
        */

    }
}
