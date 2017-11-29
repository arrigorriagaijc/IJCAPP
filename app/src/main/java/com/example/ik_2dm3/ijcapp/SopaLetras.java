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
    private String direccion;
    private Boolean PrimerToque=false;
    private ArrayList<TextView> arrayListLetrasSeleccionadas=new ArrayList<>();
    private ArrayList<TextView> arrayListLetraAnterior=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sopaletras);

        char c;
        final ArrayList<TextView> arrayListTextView=new ArrayList<>();
        Random r = new Random();
        final float[] posIniX = new float[1];
        final float[] posIniY = new float[1];
        final float[] posFinX = new float[1];
        final float[] posFinY = new float[1];
        final float[] dirX = new float[1];
        final float[] dirY = new float[1];
        final float[] posX = new float[1];
        final float[] posY = new float[1];

        //LinearLayout llHFila9=(LinearLayout)findViewById(R.id.llHFila9);
        //llHFila1.setY((float) 200.0);

        TextView tv1= findViewById(R.id.tv1);
        arrayListTextView.add(tv1);
        TextView tv2= findViewById(R.id.tv2);
        arrayListTextView.add(tv2);
        TextView tv3= findViewById(R.id.tv3);
        arrayListTextView.add(tv3);
        TextView tv4= findViewById(R.id.tv4);
        arrayListTextView.add(tv4);
        TextView tv5= findViewById(R.id.tv5);
        arrayListTextView.add(tv5);
        TextView tv6= findViewById(R.id.tv6);
        arrayListTextView.add(tv6);
        TextView tv7= findViewById(R.id.tv7);
        arrayListTextView.add(tv7);
        TextView tv8= findViewById(R.id.tv8);
        arrayListTextView.add(tv8);
        TextView tv9= findViewById(R.id.tv9);
        arrayListTextView.add(tv9);
        TextView tv10= findViewById(R.id.tv10);
        arrayListTextView.add(tv10);
        TextView tv11= findViewById(R.id.tv11);
        arrayListTextView.add(tv11);
        TextView tv12= findViewById(R.id.tv12);
        arrayListTextView.add(tv12);
        TextView tv13= findViewById(R.id.tv13);
        arrayListTextView.add(tv13);
        TextView tv14= findViewById(R.id.tv14);
        arrayListTextView.add(tv14);
        TextView tv15= findViewById(R.id.tv15);
        arrayListTextView.add(tv15);
        TextView tv16= findViewById(R.id.tv16);
        arrayListTextView.add(tv16);
        TextView tv17= findViewById(R.id.tv17);
        arrayListTextView.add(tv17);
        TextView tv18= findViewById(R.id.tv18);
        arrayListTextView.add(tv18);
        TextView tv19= findViewById(R.id.tv19);
        arrayListTextView.add(tv19);
        TextView tv20= findViewById(R.id.tv20);
        arrayListTextView.add(tv20);
        TextView tv21= findViewById(R.id.tv21);
        arrayListTextView.add(tv21);
        TextView tv22= findViewById(R.id.tv22);
        arrayListTextView.add(tv22);
        TextView tv23= findViewById(R.id.tv23);
        arrayListTextView.add(tv23);
        TextView tv24= findViewById(R.id.tv24);
        arrayListTextView.add(tv24);
        TextView tv25= findViewById(R.id.tv25);
        arrayListTextView.add(tv25);
        TextView tv26= findViewById(R.id.tv26);
        arrayListTextView.add(tv26);
        TextView tv27= findViewById(R.id.tv27);
        arrayListTextView.add(tv27);
        TextView tv28= findViewById(R.id.tv28);
        arrayListTextView.add(tv28);
        TextView tv29= findViewById(R.id.tv29);
        arrayListTextView.add(tv29);
        TextView tv30= findViewById(R.id.tv30);
        arrayListTextView.add(tv30);
        TextView tv31= findViewById(R.id.tv31);
        arrayListTextView.add(tv31);
        TextView tv32= findViewById(R.id.tv32);
        arrayListTextView.add(tv32);
        TextView tv33= findViewById(R.id.tv33);
        arrayListTextView.add(tv33);
        TextView tv34= findViewById(R.id.tv34);
        arrayListTextView.add(tv34);
        TextView tv35= findViewById(R.id.tv35);
        arrayListTextView.add(tv35);
        TextView tv36= findViewById(R.id.tv36);
        arrayListTextView.add(tv36);
        TextView tv37= findViewById(R.id.tv37);
        arrayListTextView.add(tv37);
        TextView tv38= findViewById(R.id.tv38);
        arrayListTextView.add(tv38);
        TextView tv39= findViewById(R.id.tv39);
        arrayListTextView.add(tv39);
        TextView tv40= findViewById(R.id.tv40);
        arrayListTextView.add(tv40);
        TextView tv41= findViewById(R.id.tv41);
        arrayListTextView.add(tv41);
        TextView tv42= findViewById(R.id.tv42);
        arrayListTextView.add(tv42);
        TextView tv43= findViewById(R.id.tv43);
        arrayListTextView.add(tv43);
        TextView tv44= findViewById(R.id.tv44);
        arrayListTextView.add(tv44);
        TextView tv45= findViewById(R.id.tv45);
        arrayListTextView.add(tv45);
        TextView tv46= findViewById(R.id.tv46);
        arrayListTextView.add(tv46);
        TextView tv47= findViewById(R.id.tv47);
        arrayListTextView.add(tv47);
        TextView tv48= findViewById(R.id.tv48);
        arrayListTextView.add(tv48);
        TextView tv49= findViewById(R.id.tv49);
        arrayListTextView.add(tv49);
        TextView tv50= findViewById(R.id.tv50);
        arrayListTextView.add(tv50);
        TextView tv51= findViewById(R.id.tv51);
        arrayListTextView.add(tv51);
        TextView tv52= findViewById(R.id.tv52);
        arrayListTextView.add(tv52);
        TextView tv53= findViewById(R.id.tv53);
        arrayListTextView.add(tv53);
        TextView tv54= findViewById(R.id.tv54);
        arrayListTextView.add(tv54);
        TextView tv55= findViewById(R.id.tv55);
        arrayListTextView.add(tv55);
        TextView tv56= findViewById(R.id.tv56);
        arrayListTextView.add(tv56);
        TextView tv57= findViewById(R.id.tv57);
        arrayListTextView.add(tv57);
        TextView tv58= findViewById(R.id.tv58);
        arrayListTextView.add(tv58);
        TextView tv59= findViewById(R.id.tv59);
        arrayListTextView.add(tv59);
        TextView tv60= findViewById(R.id.tv60);
        arrayListTextView.add(tv60);
        TextView tv61= findViewById(R.id.tv61);
        arrayListTextView.add(tv61);
        TextView tv62= findViewById(R.id.tv62);
        arrayListTextView.add(tv62);
        TextView tv63= findViewById(R.id.tv63);
        arrayListTextView.add(tv63);
        TextView tv64= findViewById(R.id.tv64);
        arrayListTextView.add(tv64);
        TextView tv65= findViewById(R.id.tv65);
        arrayListTextView.add(tv65);
        TextView tv66= findViewById(R.id.tv66);
        arrayListTextView.add(tv66);
        TextView tv67= findViewById(R.id.tv67);
        arrayListTextView.add(tv67);
        TextView tv68= findViewById(R.id.tv68);
        arrayListTextView.add(tv68);
        TextView tv69= findViewById(R.id.tv69);
        arrayListTextView.add(tv69);
        TextView tv70= findViewById(R.id.tv70);
        arrayListTextView.add(tv70);
        TextView tv71= findViewById(R.id.tv71);
        arrayListTextView.add(tv71);
        TextView tv72= findViewById(R.id.tv72);
        arrayListTextView.add(tv72);
        TextView tv73= findViewById(R.id.tv73);
        arrayListTextView.add(tv73);
        TextView tv74= findViewById(R.id.tv74);
        arrayListTextView.add(tv74);
        TextView tv75= findViewById(R.id.tv75);
        arrayListTextView.add(tv75);
        TextView tv76= findViewById(R.id.tv76);
        arrayListTextView.add(tv76);
        TextView tv77= findViewById(R.id.tv77);
        arrayListTextView.add(tv77);
        TextView tv78= findViewById(R.id.tv78);
        arrayListTextView.add(tv78);
        TextView tv79= findViewById(R.id.tv79);
        arrayListTextView.add(tv79);
        TextView tv80= findViewById(R.id.tv80);
        arrayListTextView.add(tv80);
        TextView tv81= findViewById(R.id.tv81);
        arrayListTextView.add(tv81);
        TextView tv82= findViewById(R.id.tv82);
        arrayListTextView.add(tv82);
        TextView tv83= findViewById(R.id.tv83);
        arrayListTextView.add(tv83);
        TextView tv84= findViewById(R.id.tv84);
        arrayListTextView.add(tv84);
        TextView tv85= findViewById(R.id.tv85);
        arrayListTextView.add(tv85);
        TextView tv86= findViewById(R.id.tv86);
        arrayListTextView.add(tv86);
        TextView tv87= findViewById(R.id.tv87);
        arrayListTextView.add(tv87);
        TextView tv88= findViewById(R.id.tv88);
        arrayListTextView.add(tv88);
        TextView tv89= findViewById(R.id.tv89);
        arrayListTextView.add(tv89);
        TextView tv90= findViewById(R.id.tv90);
        arrayListTextView.add(tv90);
        TextView tv91= findViewById(R.id.tv91);
        arrayListTextView.add(tv91);
        TextView tv92= findViewById(R.id.tv92);
        arrayListTextView.add(tv92);
        TextView tv93= findViewById(R.id.tv93);
        arrayListTextView.add(tv93);
        TextView tv94= findViewById(R.id.tv94);
        arrayListTextView.add(tv94);
        TextView tv95= findViewById(R.id.tv95);
        arrayListTextView.add(tv95);
        TextView tv96= findViewById(R.id.tv96);
        arrayListTextView.add(tv96);
        TextView tv97= findViewById(R.id.tv97);
        arrayListTextView.add(tv97);
        TextView tv98= findViewById(R.id.tv98);
        arrayListTextView.add(tv98);
        TextView tv99= findViewById(R.id.tv99);
        arrayListTextView.add(tv99);


        /*if (hitRect.contains(posiX, posiY)) {
            arrayListTextView.get(j).setBackgroundColor(Color.parseColor("#E4E663"));
            Log.d(TAG,"Estas dentro");
        }*/

        //float pos;
        //pos=findViewById(R.id.tv99).getY();
        //tv95.getLocationInWindow(pos);
        //Log.d(TAG,"X: "+Float.toString(pos));
        //Log.d(TAG,Float.toString(tv99.getTranslationY()));

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
                            arrayListLetrasSeleccionadas.add((TextView)v);
                            Rect hitRect = mHitRect;
                            v.getGlobalVisibleRect(hitRect);
                            dirX[0]=hitRect.exactCenterX();
                            dirY[0]=hitRect.exactCenterY();
                            arrayListLetraAnterior.add((TextView)v);
                            PrimerToque=false;
                            //Log.d(TAG,Float.toString(posIniX[0])+" "+Float.toString(posIniY[0]));
                            break;
                        case MotionEvent.ACTION_UP:
                            //Cuando levanto el dedo se pone all blanco
                            for(int z=0;z<99;z++){
                                arrayListTextView.get(z).setBackgroundColor(Color.parseColor("#FFFFFF"));
                            }
                            String palabra=new String("");
                            for (int g=0;g<arrayListLetrasSeleccionadas.size();g++){
                                palabra=palabra+arrayListLetrasSeleccionadas.get(g).getText();
                            }
                            Log.d(TAG,palabra);
                            break;
                        case MotionEvent.ACTION_MOVE:
                            ((TextView) v).setBackgroundColor(Color.parseColor("#E4E663"));
                            //Esta es la posición actual del dedo
                            posX[0] =event.getRawX();
                            posY[0] =event.getRawY();
                            int posiX=(int)posX[0];
                            int posiY=(int)posY[0];
                            //Compruebo que mi posicion actual coincide con la posicion de alguno de los textviews

                            for(int j=0;j<99;j++){
                                //Obtengo el cuadrado posicional de mi textview
                                hitRect = mHitRect;
                                arrayListTextView.get(j).getGlobalVisibleRect(hitRect);
                                //Log.d(TAG,"Pos: "+Integer.toString(j+1)+", X: "+Integer.toString((int)hitRect.exactCenterX())+", Y: "+Integer.toString((int)hitRect.exactCenterY()));

                                    //Si estoy en uno de los textviews:
                                    if(hitRect.contains(posiX,posiY)){
                                        //Capturamos las coordenadas del cuadrado sobre el que estamos
                                        posFinX[0]=hitRect.exactCenterX();
                                        posFinY[0]=hitRect.exactCenterY();
                                        //
                                        //Si no es el anterior textview:
                                        if(!arrayListLetraAnterior.get(arrayListLetraAnterior.size()-1).equals(arrayListTextView.get(j)) && ((posFinX[0]!=dirX[0] && posFinY[0]==dirY[0])  || (posFinX[0]==dirX[0] && posFinY[0]!=dirY[0]))){

                                            if(dirX[0]==posFinX[0] && posFinY[0]<dirY[0]){
                                                direccion=new String("arriba");
                                                //Log.d(TAG,"arriba");
                                            }
                                            //Si vamos hacia abajo
                                            if(dirX[0]==posFinX[0] && posFinY[0]>dirY[0]){
                                                direccion=new String("abajo");
                                                //Log.d(TAG,"abajo");
                                            }
                                            //Si vamos hacia la derecha
                                            if(dirY[0]==posFinY[0] && posFinX[0]>dirX[0]){
                                                direccion=new String("derecha");
                                                //Log.d(TAG,"derecha");
                                            }
                                            //Si vamos hacia la izquierda
                                            if(dirY[0]==posFinY[0] && posFinX[0]<dirX[0]) {
                                                direccion = new String("izquierda");
                                                //Log.d(TAG, "izquierda");
                                            }
                                                //Log.d(TAG,Float.toString(posFinX[0])+" "+Float.toString(posFinY[0]));
                                            //Si la posicion del cuadrado coincide con la de la direccion:
                                            if(posFinX[0]==dirX[0] && (direccion.equals("arriba") || direccion.equals("abajo"))){
                                                arrayListTextView.get(j).setBackgroundColor(Color.parseColor("#E4E663"));
                                                //Meto en un array las letras que he seleccionado
                                                arrayListLetrasSeleccionadas.add(arrayListTextView.get(j));
                                                arrayListLetraAnterior.add(arrayListTextView.get(j));
                                                //Log.d(TAG,"Funciona");
                                            }
                                            else if(posFinY[0]==dirY[0] && (direccion.equals("izquierda") || direccion.equals("derecha"))){
                                                arrayListTextView.get(j).setBackgroundColor(Color.parseColor("#E4E663"));
                                                //Meto en un array las letras que he seleccionado
                                                arrayListLetrasSeleccionadas.add(arrayListTextView.get(j));
                                                arrayListLetraAnterior.add(arrayListTextView.get(j));
                                            }

                                        }

                                    //Log.d(TAG,"Estas fuera");
                                }

                            }
                            break;
                        default:
                            break;
                    }

                    return true;
                }
            });



        }
        arrayListTextView.get(2).setText(String.valueOf("L").toUpperCase());
        arrayListTextView.get(3).setText(String.valueOf("E").toUpperCase());
        arrayListTextView.get(4).setText(String.valueOf("Y").toUpperCase());
        arrayListTextView.get(5).setText(String.valueOf("E").toUpperCase());
        arrayListTextView.get(6).setText(String.valueOf("S").toUpperCase());
        arrayListTextView.get(11).setText(String.valueOf("A").toUpperCase());
        arrayListTextView.get(20).setText(String.valueOf("P").toUpperCase());
        arrayListTextView.get(22).setText(String.valueOf("L").toUpperCase());
        arrayListTextView.get(31).setText(String.valueOf("O").toUpperCase());
        arrayListTextView.get(33).setText(String.valueOf("C").toUpperCase());
        arrayListTextView.get(42).setText(String.valueOf("L").toUpperCase());
        arrayListTextView.get(44).setText(String.valueOf("A").toUpperCase());
        arrayListTextView.get(53).setText(String.valueOf("I").toUpperCase());
        arrayListTextView.get(55).setText(String.valueOf("L").toUpperCase());
        arrayListTextView.get(64).setText(String.valueOf("T").toUpperCase());
        arrayListTextView.get(66).setText(String.valueOf("D").toUpperCase());
        arrayListTextView.get(75).setText(String.valueOf("I").toUpperCase());
        arrayListTextView.get(77).setText(String.valueOf("E").toUpperCase());
        arrayListTextView.get(86).setText(String.valueOf("C").toUpperCase());
        arrayListTextView.get(88).setText(String.valueOf("C").toUpperCase());
        arrayListTextView.get(89).setText(String.valueOf("O").toUpperCase());
        arrayListTextView.get(90).setText(String.valueOf("N").toUpperCase());
        arrayListTextView.get(91).setText(String.valueOf("C").toUpperCase());
        arrayListTextView.get(92).setText(String.valueOf("E").toUpperCase());
        arrayListTextView.get(93).setText(String.valueOf("J").toUpperCase());
        arrayListTextView.get(94).setText(String.valueOf("A").toUpperCase());
        arrayListTextView.get(95).setText(String.valueOf("L").toUpperCase());
        arrayListTextView.get(97).setText(String.valueOf("A").toUpperCase());





    }
}
