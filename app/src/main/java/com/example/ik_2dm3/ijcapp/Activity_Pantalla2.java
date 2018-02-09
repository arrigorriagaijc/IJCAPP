package com.example.ik_2dm3.ijcapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;


public class Activity_Pantalla2 extends AppCompatActivity {

    //private static final String TAG = "TAG";
    private final Rect mHitRect = new Rect();
    private String direccion;
    private Boolean PrimerToque=false;
    private ArrayList<TextView> arrayListLetrasSeleccionadas=new ArrayList<>();
    private ArrayList<TextView> arrayListLetraAnterior=new ArrayList<>();
    private ArrayList<TextView> arrayListLetrasAcertadas=new ArrayList<>();
    private ArrayList<TextView> arrayListTextView=new ArrayList<>();
    private boolean añadir=true;
    private int aciertos=0;
    private float[] posFinX = new float[1];
    private float[] posFinY = new float[1];
    private float[] dirX = new float[1];
    private float[] dirY = new float[1];
    private float[] posX = new float[1];
    private float[] posY = new float[1];
    private boolean alcalde=false;
    private boolean concejal=false;
    private boolean politica=false;
    private boolean leyes=false;
    private Dialog customDialog = null;
    private int titulo;
    private int mensaje;
    private boolean acertado=false;
    private  Button btnSiguiente;
    private LinearLayout llGeneral;
    private MediaPlayer mediaPlayer;
    private ImageButton btnAudio2;
    private GifImageView givMikel;
    private ConstraintLayout clMikel;
    private TextView tvMensaje;
    private LinearLayout llSopa;
    private TextView tvZona1;
    private Button btnSaltarAudio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        //Añado el textviewzona2
        tvZona1=(TextView) findViewById(R.id.tvZona1);

        givMikel=(GifImageView) findViewById(R.id.givMikel);
        ConstraintLayout llPlaza=(ConstraintLayout) findViewById(R.id.llPlaza);
        btnAudio2=(ImageButton) findViewById(R.id.btnAudio2);

        if(tvZona1.getText().equals("Escucha este audio sobre el Ayuntamiento de Arrigorriaga.")){
            mediaPlayer= MediaPlayer.create(Activity_Pantalla2.this, R.raw.udaletxeaerdaraz);
        }else{
            mediaPlayer= MediaPlayer.create(Activity_Pantalla2.this, R.raw.udaletxeaeuskaraz);
        }
        clMikel=(ConstraintLayout) findViewById(R.id.clMikel);
        llSopa=(LinearLayout) findViewById(R.id.llSopa);
        tvMensaje=(TextView) findViewById(R.id.tvMensaje);
        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);


        //Hacemos que empiece parado poniendo la imagen
        givMikel.setBackgroundResource(R.drawable.mikel);
        //Le ponemos al boton del audio un listener para que cuando hagamos click se reproduzca el audio y se seshavbilite el boton
        btnAudio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                btnAudio2.setEnabled(false);
                //Activamos el gif, asignandolo al src
                givMikel.setBackgroundResource(R.drawable.mikelgif);
            }
        });

        //Le ponemos al boton del audio un listener para que cuando complete el audio se vuelva a habilitar el boton
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btnAudio2.setEnabled(true);
                //Volvemos a desactivar el gif asignando la imagen
                givMikel.setBackgroundResource(R.drawable.mikel);
                //Cambiamos la visibilidad de este constraintlayout a gone
                clMikel.setVisibility(View.GONE);
                tvMensaje.setVisibility(View.VISIBLE);
                llSopa.setVisibility(View.VISIBLE);
                btnSiguiente.setVisibility(View.INVISIBLE);
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
                clMikel.setVisibility(View.GONE);
                tvMensaje.setVisibility(View.VISIBLE);
                llSopa.setVisibility(View.VISIBLE);
                btnSiguiente.setVisibility(View.INVISIBLE);
            }
        });

        //Declaro el char que me va a servir para guardar las letras que genere para la sopa de letras
        char c;
        //Preparo una sentencia alatoria
        Random r = new Random();



        //Añado todos los textViews a un arraylist - Código Espartano
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

        llGeneral=(LinearLayout) findViewById(R.id.llGeneral);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Finalizo este activity, esto lo tendremos que cambiar porque habra que volver con un onrequestactivitya activity_mapa
                Intent intent=new Intent(getApplicationContext(), Pista3.class);
                startActivity(intent);
            }
        });

        //Recorro el array de textViews
        for(int i=0;i<99;i++){
            //Genero una letra para la char c
            c = (char)(r.nextInt(26) + 'a');
            //Asigno la letra al textView que estemos
            arrayListTextView.get(i).setText(String.valueOf(c).toUpperCase());
            //Declaro un evento que reaccione al toque de la pantalla
            arrayListTextView.get(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    //4 casos
                    switch (event.getAction()) {
                        //El primer caso es cuando toco con el dedo la pantalla, este evento solo recoge el primer pulso, no el arrastrar
                        case MotionEvent.ACTION_DOWN:
                            //Transformo la vista v del listener en textView ya que es su formato original y para trabajar con el.
                            ((TextView) v).setBackgroundColor(Color.parseColor("#E4E663"));
                            //En otro array donde voy a guardar las letras que yo seleccione con el dedo voy a guardar este textView
                            arrayListLetrasSeleccionadas.add((TextView)v);
                            //Aqui estoy declarando una variable que es capaz de coger una vista y decir con la siguiente función si unas coordenadas que yo
                            //le paso están dentro de esa vista.
                            Rect hitRect = mHitRect;
                            //Esta es la función citada, que hace referencia a la vista v (el TextView) y modifica la variable hitRect que le paso
                            v.getGlobalVisibleRect(hitRect);
                            //Con estas dos funciones sacamos la X e Y central de la vista
                            dirX[0]=hitRect.exactCenterX();
                            dirY[0]=hitRect.exactCenterY();
                            //En este otro array voy a guardar la letra que tengo para posteriormente comprobar la direccion en la que he empezado a arrastrar el dedo
                            arrayListLetraAnterior.add((TextView)v);
                            //Aqui declaro una variable que me servira para que se establezcan las direcciones una sola vez y no se vuelva loco el problema
                            PrimerToque=false;
                            //Aqui declaro una variable que me va a decir si el textView en el que estoy ya lo he añadido al arraylist de antes para que no se repitan letras
                            añadir=true;
                            break;
                        //El segundo caso es cuando levanto el dedo de la pantalla, este evento solo recoge el primer pulso, no el arrastrar
                        case MotionEvent.ACTION_UP:
                            //Declaro la variable en la que se va a guardar la palabra que tengo marcada con el dedo
                            String palabra=new String("");
                            //Meto en la palabra lo que tengo marcado (seleccionado)
                            for (int g=0;g<arrayListLetrasSeleccionadas.size();g++){
                                palabra=palabra+arrayListLetrasSeleccionadas.get(g).getText();
                            }

                            //Compruebo en castellano primero
                            if(tvZona1.getText().equals("Escucha este audio sobre el Ayuntamiento de Arrigorriaga.")) {
                                //Si la palabra que tengo seleccionada coincide con alcalde y no ha sido acertada
                                if (palabra.equals("ALCALDE") && alcalde == false) {
                                    //Hago un bucle donde busco los textViews donde están las letras de esta palabra
                                    for (int z = 0; z < 99; z++) {
                                        for (int s = 0; s < arrayListLetrasSeleccionadas.size(); s++) {
                                            if (arrayListTextView.get(z).equals(arrayListLetrasSeleccionadas.get(s))) {
                                                //les cambio el color a azul clarito
                                                arrayListTextView.get(z).setBackgroundColor(Color.parseColor("#00FFFF"));
                                                //añado al array de letras acertadas los textViews de la palabra
                                                arrayListLetrasAcertadas.add(arrayListTextView.get(z));
                                            }

                                        }

                                    }
                                    //Pongo el valor de alcalde a true para que no vuelva a contabilizarla
                                    alcalde = true;
                                    //Aumento en uno los aciertos
                                    aciertos++;

                                }
                                //Si la palabra que tengo seleccionada coincide con leyes y no ha sido acertada
                                else if (palabra.equals("LEYES") && leyes == false) {
                                    //Hago un bucle donde busco los textViews donde están las letras de esta palabra
                                    for (int z = 0; z < 99; z++) {
                                        for (int s = 0; s < arrayListLetrasSeleccionadas.size(); s++) {
                                            if (arrayListTextView.get(z).equals(arrayListLetrasSeleccionadas.get(s))) {
                                                //les cambio el color a azul clarito
                                                arrayListTextView.get(z).setBackgroundColor(Color.parseColor("#00FFFF"));
                                                //añado al array de letras acertadas los textViews de la palabra
                                                arrayListLetrasAcertadas.add(arrayListTextView.get(z));

                                            }

                                        }

                                    }
                                    //Pongo el valor de leyes a true para que no vuelva a contabilizarla
                                    leyes = true;
                                    //Aumento en uno los aciertos
                                    aciertos++;
                                }
                                //Si la palabra que tengo seleccionada coincide con concejal y no ha sido acertada
                                else if (palabra.equals("CONCEJAL") && concejal == false) {
                                    //Hago un bucle donde busco los textViews donde están las letras de esta palabra
                                    for (int z = 0; z < 99; z++) {
                                        for (int s = 0; s < arrayListLetrasSeleccionadas.size(); s++) {
                                            if (arrayListTextView.get(z).equals(arrayListLetrasSeleccionadas.get(s))) {
                                                //les cambio el color a azul clarito
                                                arrayListTextView.get(z).setBackgroundColor(Color.parseColor("#00FFFF"));
                                                //añado al array de letras acertadas los textViews de la palabra
                                                arrayListLetrasAcertadas.add(arrayListTextView.get(z));

                                            }

                                        }

                                    }
                                    //Pongo el valor de concejal a true para que no vuelva a contabilizarla
                                    concejal = true;
                                    //Aumento en uno los aciertos
                                    aciertos++;
                                }
                                //Si la palabra que tengo seleccionada coincide con politica y no ha sido acertada
                                else if (palabra.equals("POLITICA") && politica == false) {
                                    //Hago un bucle donde busco los textViews donde están las letras de esta palabra
                                    for (int z = 0; z < 99; z++) {
                                        for (int s = 0; s < arrayListLetrasSeleccionadas.size(); s++) {
                                            if (arrayListTextView.get(z).equals(arrayListLetrasSeleccionadas.get(s))) {
                                                //les cambio el color a azul clarito
                                                arrayListTextView.get(z).setBackgroundColor(Color.parseColor("#00FFFF"));
                                                //añado al array de letras acertadas los textViews de la palabra
                                                arrayListLetrasAcertadas.add(arrayListTextView.get(z));

                                            }

                                        }

                                    }
                                    //Pongo el valor de politica a true para que no vuelva a contabilizarla
                                    politica = true;
                                    //Aumento en uno los aciertos
                                    aciertos++;
                                    //Si no es ninguna de las 4 palabras
                                } else {
                                    //Hago un bucle donde recorro el array de todos los textviews
                                    for (int t = 0; t < 99; t++) {
                                        //Si el arraydeletrasacertadas esta vacío pongo all blanco
                                        if (arrayListLetrasAcertadas.isEmpty()) {
                                            //Pongo el textView blanco
                                            arrayListTextView.get(t).setBackgroundColor(Color.parseColor("#00000000"));
                                        }
                                        //Si no esta vacio
                                        else {
                                            //Hago un bucle donde recorro el array de letras acertadas
                                            for (int l = 0; l < arrayListLetrasAcertadas.size(); l++) {
                                                //si el textview de letras acertadas no coincide con el textview del array de todos los textviews
                                                if (!arrayListTextView.get(t).equals(arrayListLetrasAcertadas.get(l))) {
                                                    //Cambio el color a blanco
                                                    arrayListTextView.get(t).setBackgroundColor(Color.parseColor("#00000000"));
                                                } else {
                                                    //cambio el color a azul clarito
                                                    arrayListTextView.get(t).setBackgroundColor(Color.parseColor("#00FFFF"));
                                                    //Salgo del bucle para que no me siga comparando porque si no me lo vuelve a poner blanco
                                                    //ya que compara con todas las letras acertadas
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                //Si subrayo las letras cuantas veces quiera me sale la ventana emergente(bocadillo)
                                if (palabra.equals("LEYES")) {
                                    //Asigno a la variables titulo y mensaje su valor para que se ejecuten
                                    //dentro del dialog
                                    titulo = R.string.ley;
                                    mensaje = R.string.leyes;
                                    dialogo();
                                } else if (palabra.equals("ALCALDE")) {
                                    //Asigno a la variables titulo y mensaje su valor para que se ejecuten
                                    //dentro del dialog
                                    titulo = R.string.alca;
                                    mensaje = R.string.alcalde;
                                    dialogo();
                                } else if (palabra.equals("CONCEJAL")) {
                                    //Asigno a la variables titulo y mensaje su valor para que se ejecuten
                                    //dentro del dialog
                                    titulo = R.string.conce;
                                    mensaje = R.string.concejal;
                                    dialogo();
                                } else if (palabra.equals("POLITICA")) {
                                    //Asigno a la variables titulo y mensaje su valor para que se ejecuten
                                    //dentro del dialog
                                    titulo = R.string.pol;
                                    mensaje = R.string.politica;
                                    dialogo();
                                }
                                //Limpio el arraylist de letras seleccionadas
                                arrayListLetrasSeleccionadas.clear();
                                //Limpio el arraylist de letras anteriores
                                arrayListLetraAnterior.clear();
                                //Vacio la palabra
                                palabra = new String("");
                                //Hago un bucle recorriendo el array de letras acertadas
                                for (int g = 0; g < arrayListLetrasAcertadas.size(); g++) {
                                    //Asigno a palabra cada una de las letras de los textViews
                                    palabra = palabra + arrayListLetrasAcertadas.get(g).getText();
                                }
                                //Si los aciertos son 4, (Estan todos acertados)
                                if (aciertos == 4 && acertado == false) {
                                    if(tvZona1.getText().equals("Escucha este audio sobre el Ayuntamiento de Arrigorriaga.")){
                                        //Saco un mensaje de eres un crack por pantalla en un toast
                                        Toast.makeText(getApplicationContext(), "Has acabado, pulsa la flecha", Toast.LENGTH_LONG).show();

                                    }else{
                                        //Saco un mensaje de eres un crack por pantalla en un toast
                                        Toast.makeText(getApplicationContext(), "Amaitu duzu, gezia sakatu", Toast.LENGTH_LONG).show();
                                        }
                                    //Visibilizo el boton
                                    btnSiguiente.setVisibility(View.VISIBLE);
                                    //Pongo la variable acertado a true para que no me haga estas ordenes mas veces
                                    acertado = true;
                                }
                                break;
                                //Compruebo en euskera despues
                            }else{
                                //Si la palabra que tengo seleccionada coincide con alcalde y no ha sido acertada
                                if (palabra.equals("ALKATEA") && alcalde == false) {
                                    //Hago un bucle donde busco los textViews donde están las letras de esta palabra
                                    for (int z = 0; z < 99; z++) {
                                        for (int s = 0; s < arrayListLetrasSeleccionadas.size(); s++) {
                                            if (arrayListTextView.get(z).equals(arrayListLetrasSeleccionadas.get(s))) {
                                                //les cambio el color a azul clarito
                                                arrayListTextView.get(z).setBackgroundColor(Color.parseColor("#00FFFF"));
                                                //añado al array de letras acertadas los textViews de la palabra
                                                arrayListLetrasAcertadas.add(arrayListTextView.get(z));
                                            }

                                        }

                                    }
                                    //Pongo el valor de alcalde a true para que no vuelva a contabilizarla
                                    alcalde = true;
                                    //Aumento en uno los aciertos
                                    aciertos++;

                                }
                                //Si la palabra que tengo seleccionada coincide con leyes y no ha sido acertada
                                else if (palabra.equals("LEGEAK") && leyes == false) {
                                    //Hago un bucle donde busco los textViews donde están las letras de esta palabra
                                    for (int z = 0; z < 99; z++) {
                                        for (int s = 0; s < arrayListLetrasSeleccionadas.size(); s++) {
                                            if (arrayListTextView.get(z).equals(arrayListLetrasSeleccionadas.get(s))) {
                                                //les cambio el color a azul clarito
                                                arrayListTextView.get(z).setBackgroundColor(Color.parseColor("#00FFFF"));
                                                //añado al array de letras acertadas los textViews de la palabra
                                                arrayListLetrasAcertadas.add(arrayListTextView.get(z));

                                            }

                                        }

                                    }
                                    //Pongo el valor de leyes a true para que no vuelva a contabilizarla
                                    leyes = true;
                                    //Aumento en uno los aciertos
                                    aciertos++;
                                }
                                //Si la palabra que tengo seleccionada coincide con concejal y no ha sido acertada
                                else if (palabra.equals("ZINEGOTZIA") && concejal == false) {
                                    //Hago un bucle donde busco los textViews donde están las letras de esta palabra
                                    for (int z = 0; z < 99; z++) {
                                        for (int s = 0; s < arrayListLetrasSeleccionadas.size(); s++) {
                                            if (arrayListTextView.get(z).equals(arrayListLetrasSeleccionadas.get(s))) {
                                                //les cambio el color a azul clarito
                                                arrayListTextView.get(z).setBackgroundColor(Color.parseColor("#00FFFF"));
                                                //añado al array de letras acertadas los textViews de la palabra
                                                arrayListLetrasAcertadas.add(arrayListTextView.get(z));

                                            }

                                        }

                                    }
                                    //Pongo el valor de concejal a true para que no vuelva a contabilizarla
                                    concejal = true;
                                    //Aumento en uno los aciertos
                                    aciertos++;
                                }
                                //Si la palabra que tengo seleccionada coincide con politica y no ha sido acertada
                                else if (palabra.equals("POLITIKA") && politica == false) {
                                    //Hago un bucle donde busco los textViews donde están las letras de esta palabra
                                    for (int z = 0; z < 99; z++) {
                                        for (int s = 0; s < arrayListLetrasSeleccionadas.size(); s++) {
                                            if (arrayListTextView.get(z).equals(arrayListLetrasSeleccionadas.get(s))) {
                                                //les cambio el color a azul clarito
                                                arrayListTextView.get(z).setBackgroundColor(Color.parseColor("#00FFFF"));
                                                //añado al array de letras acertadas los textViews de la palabra
                                                arrayListLetrasAcertadas.add(arrayListTextView.get(z));

                                            }

                                        }

                                    }
                                    //Pongo el valor de politica a true para que no vuelva a contabilizarla
                                    politica = true;
                                    //Aumento en uno los aciertos
                                    aciertos++;
                                    //Si no es ninguna de las 4 palabras
                                } else {
                                    //Hago un bucle donde recorro el array de todos los textviews
                                    for (int t = 0; t < 99; t++) {
                                        //Si el arraydeletrasacertadas esta vacío pongo all blanco
                                        if (arrayListLetrasAcertadas.isEmpty()) {
                                            //Pongo el textView blanco
                                            arrayListTextView.get(t).setBackgroundColor(Color.parseColor("#00000000"));
                                        }
                                        //Si no esta vacio
                                        else {
                                            //Hago un bucle donde recorro el array de letras acertadas
                                            for (int l = 0; l < arrayListLetrasAcertadas.size(); l++) {
                                                //si el textview de letras acertadas no coincide con el textview del array de todos los textviews
                                                if (!arrayListTextView.get(t).equals(arrayListLetrasAcertadas.get(l))) {
                                                    //Cambio el color a blanco
                                                    arrayListTextView.get(t).setBackgroundColor(Color.parseColor("#00000000"));
                                                } else {
                                                    //cambio el color a azul clarito
                                                    arrayListTextView.get(t).setBackgroundColor(Color.parseColor("#00FFFF"));
                                                    //Salgo del bucle para que no me siga comparando porque si no me lo vuelve a poner blanco
                                                    //ya que compara con todas las letras acertadas
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                //Si subrayo las letras cuantas veces quiera me sale la ventana emergente(bocadillo)
                                if (palabra.equals("LEGEAK")) {
                                    //Asigno a la variables titulo y mensaje su valor para que se ejecuten
                                    //dentro del dialog
                                    titulo = R.string.ley;
                                    mensaje = R.string.leyes;
                                    dialogo();
                                } else if (palabra.equals("ALKATEA")) {
                                    //Asigno a la variables titulo y mensaje su valor para que se ejecuten
                                    //dentro del dialog
                                    titulo = R.string.alca;
                                    mensaje = R.string.alcalde;
                                    dialogo();
                                } else if (palabra.equals("ZINEGOTZIA")) {
                                    //Asigno a la variables titulo y mensaje su valor para que se ejecuten
                                    //dentro del dialog
                                    titulo = R.string.conce;
                                    mensaje = R.string.concejal;
                                    dialogo();
                                } else if (palabra.equals("POLITIKA")) {
                                    //Asigno a la variables titulo y mensaje su valor para que se ejecuten
                                    //dentro del dialog
                                    titulo = R.string.pol;
                                    mensaje = R.string.politica;
                                    dialogo();
                                }
                                //Limpio el arraylist de letras seleccionadas
                                arrayListLetrasSeleccionadas.clear();
                                //Limpio el arraylist de letras anteriores
                                arrayListLetraAnterior.clear();
                                //Vacio la palabra
                                palabra = new String("");
                                //Hago un bucle recorriendo el array de letras acertadas
                                for (int g = 0; g < arrayListLetrasAcertadas.size(); g++) {
                                    //Asigno a palabra cada una de las letras de los textViews
                                    palabra = palabra + arrayListLetrasAcertadas.get(g).getText();
                                }
                                //Si los aciertos son 4, (Estan todos acertados)
                                if (aciertos == 4 && acertado == false) {
                                    if(tvZona1.getText().equals("Escucha este audio sobre el Ayuntamiento de Arrigorriaga.")){
                                        //Saco un mensaje de eres un crack por pantalla en un toast
                                        Toast.makeText(getApplicationContext(), "Has acabado, pulsa la flecha", Toast.LENGTH_LONG).show();
                                        }else{
                                        //Saco un mensaje de eres un crack por pantalla en un toast
                                        Toast.makeText(getApplicationContext(), "Amaitu duzu, gezia sakatu", Toast.LENGTH_LONG).show();
                                    }
                                    //Visibilizo el boton
                                    btnSiguiente.setVisibility(View.VISIBLE);
                                    //Pongo la variable acertado a true para que no me haga estas ordenes mas veces
                                    acertado = true;
                                }
                                break;
                            }
                        //El tercer caso es cuando sin levantar el dedo de la pantalla lo arrastro
                        case MotionEvent.ACTION_MOVE:
                            //Esta es la posición actual del dedo
                            posX[0] =event.getRawX();
                            posY[0] =event.getRawY();
                            //La transformo a entero
                            int posiX=(int)posX[0];
                            int posiY=(int)posY[0];
                            //Hago un bucle para comprobar que la posicion actual de mi dedo coincide con la posicion de alguno de los textviews
                            for(int j=0;j<99;j++){
                                //Obtengo un cuadrado posicional
                                hitRect = mHitRect;
                                //meto en mi cuadrado posicional la posicion de mi textView
                                arrayListTextView.get(j).getGlobalVisibleRect(hitRect);
                                    //Si estoy en uno cualquier de los textviews:
                                    if(hitRect.contains(posiX,posiY)){
                                        //Capturamos las coordenadas del textView sobre el que estamos
                                        posFinX[0]=hitRect.exactCenterX();
                                        posFinY[0]=hitRect.exactCenterY();
                                        //Si no es el anterior textview
                                        if(!arrayListLetraAnterior.get(arrayListLetraAnterior.size()-1).equals(arrayListTextView.get(j))){
                                            //Si la posicion x del primer toque coincide con la posicion x del textview en el que estoy y la posicion y en la que estoy
                                            //es mayor que la del primer toque y o estamos en el primer arrastre (toque) o la direccion ya está establecida hacia arriba porque
                                            //no es el primer arrastre y ya se ha fijado
                                            if(dirX[0]==posFinX[0] && posFinY[0]<dirY[0] && (PrimerToque.equals(false) || direccion.equals("arriba"))){
                                                //Asigno la direccion hacia arriba
                                                direccion=new String("arriba");
                                                //Hago un bucle en el que recorro el array de letras anteriores
                                                for(int f=0; f<arrayListLetraAnterior.size();f++){
                                                    //Si el textView sobre el que estoy coindide con alguno de los anteriores en los que estado
                                                    if(arrayListTextView.get(j).equals(arrayListLetraAnterior.get(f))){
                                                        //Declaro añadir falso para que no lo añada
                                                        añadir=false;
                                                    }
                                                }
                                                //Si añadir es verdadero (el textview sobre el que estoy no coincide con ninguno de los anteriores en los que he estado)
                                                if(añadir){
                                                    //Fijo el color del textview en el que estoy en verde
                                                    arrayListTextView.get(j).setBackgroundColor(Color.parseColor("#E4E663"));
                                                    //Meto en un array el textview en el que estoy
                                                    arrayListLetrasSeleccionadas.add(arrayListTextView.get(j));
                                                    //Añado el textview en el que estoy al arrayList de letras anteriores
                                                    arrayListLetraAnterior.add(arrayListTextView.get(j));
                                                }
                                                //Declaro primerToque true para que no vuelva a establecerse la direccion y no se vuelva loco el programa
                                                PrimerToque=true;
                                            }
                                            //Si la posicion x del primer toque coincide con la posicion x del textview en el que estoy y la posicion y en la que estoy
                                            //es menor que la del primer toque y o estamos en el primer arrastre (toque) o la direccion ya está establecida hacia abajo porque
                                            //no es el primer arrastre y ya se ha fijado
                                            if(dirX[0]==posFinX[0] && posFinY[0]>dirY[0] && (PrimerToque.equals(false) || direccion.equals("abajo"))){
                                                //Asigno la direccion hacia abajo
                                                direccion=new String("abajo");
                                                //Hago un bucle en el que recorro el array de letras anteriores
                                                for(int f=0; f<arrayListLetraAnterior.size();f++){
                                                    //Si el textView sobre el que estoy coindide con alguno de los anteriores en los que estado
                                                    if(arrayListTextView.get(j).equals(arrayListLetraAnterior.get(f))){
                                                        //Declaro añadir falso para que no lo añada
                                                        añadir=false;
                                                    }
                                                }
                                                //Si añadir es verdadero (el textview sobre el que estoy no coincide con ninguno de los anteriores en los que he estado)
                                                if(añadir){
                                                    //Fijo el color del textview en el que estoy en verde
                                                    arrayListTextView.get(j).setBackgroundColor(Color.parseColor("#E4E663"));
                                                    //Meto en un array el textview en el que estoy
                                                    arrayListLetrasSeleccionadas.add(arrayListTextView.get(j));
                                                    //Añado el textview en el que estoy al arrayList de letras anteriores
                                                    arrayListLetraAnterior.add(arrayListTextView.get(j));
                                                }
                                                //Declaro primerToque true para que no vuelva a establecerse la direccion y no se vuelva loco el programa
                                                PrimerToque=true;
                                            }
                                            //Si la posicion y del primer toque coincide con la posicion y del textview en el que estoy y la posicion x en la que estoy
                                            //es mayor que la del primer toque y o estamos en el primer arrastre (toque) o la direccion ya está establecida hacia la derecha porque
                                            //no es el primer arrastre y ya se ha fijado
                                            if(dirY[0]==posFinY[0] && posFinX[0]>dirX[0] && (PrimerToque.equals(false) || direccion.equals("derecha"))){
                                                //Asigno la direccion hacia la derecha
                                                direccion=new String("derecha");
                                                //Hago un bucle en el que recorro el array de letras anteriores
                                                for(int f=0; f<arrayListLetraAnterior.size();f++){
                                                    //Si el textView sobre el que estoy coindide con alguno de los anteriores en los que estado
                                                    if(arrayListTextView.get(j).equals(arrayListLetraAnterior.get(f))){
                                                        //Declaro añadir falso para que no lo añada
                                                        añadir=false;
                                                    }
                                                }
                                                //Si añadir es verdadero (el textview sobre el que estoy no coincide con ninguno de los anteriores en los que he estado)
                                                if(añadir){
                                                    //Fijo el color del textview en el que estoy en verde
                                                    arrayListTextView.get(j).setBackgroundColor(Color.parseColor("#E4E663"));
                                                    //Meto en un array el textview en el que estoy
                                                    arrayListLetrasSeleccionadas.add(arrayListTextView.get(j));
                                                    //Añado el textview en el que estoy al arrayList de letras anteriores
                                                    arrayListLetraAnterior.add(arrayListTextView.get(j));
                                                }
                                                //Declaro primerToque true para que no vuelva a establecerse la direccion y no se vuelva loco el programa
                                                PrimerToque=true;
                                            }
                                            //Si la posicion y del primer toque coincide con la posicion y del textview en el que estoy y la posicion x en la que estoy
                                            //es menor que la del primer toque y o estamos en el primer arrastre (toque) o la direccion ya está establecida hacia la izquierda porque
                                            //no es el primer arrastre y ya se ha fijado
                                            if(dirY[0]==posFinY[0] && posFinX[0]<dirX[0] && (PrimerToque.equals(false) || direccion.equals("izquierda"))) {
                                                //Asigno la direccion hacia la izquierda
                                                direccion = new String("izquierda");
                                                //Hago un bucle en el que recorro el array de letras anteriores
                                                for(int f=0; f<arrayListLetraAnterior.size();f++){
                                                    //Si el textView sobre el que estoy coindide con alguno de los anteriores en los que estado
                                                    if(arrayListTextView.get(j).equals(arrayListLetraAnterior.get(f))){
                                                        //Declaro añadir falso para que no lo añada
                                                        añadir=false;
                                                    }
                                                }
                                                //Si añadir es verdadero (el textview sobre el que estoy no coincide con ninguno de los anteriores en los que he estado)
                                                if(añadir){
                                                    //Fijo el color del textview en el que estoy en verde
                                                    arrayListTextView.get(j).setBackgroundColor(Color.parseColor("#E4E663"));
                                                    //Meto en un array el textview en el que estoy
                                                    arrayListLetrasSeleccionadas.add(arrayListTextView.get(j));
                                                    //Añado el textview en el que estoy al arrayList de letras anteriores
                                                    arrayListLetraAnterior.add(arrayListTextView.get(j));
                                                }
                                                //Declaro primerToque true para que no vuelva a establecerse la direccion y no se vuelva loco el programa
                                                PrimerToque=true;
                                            }
                                        }
                                }
                            }
                            break;
                        //El cuarto caso son los demas y se sale del menu simplemente
                        default:
                            break;
                    }
                    return true;
                }
            });
        }

        //Declaro las letras que son fijas en sus correspondientes TextViews
        if(tvZona1.getText().equals("Escucha este audio sobre el Ayuntamiento de Arrigorriaga.")) {
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
        }else{
            arrayListTextView.get(2).setText(String.valueOf("L").toUpperCase());
            arrayListTextView.get(3).setText(String.valueOf("E").toUpperCase());
            arrayListTextView.get(4).setText(String.valueOf("G").toUpperCase());
            arrayListTextView.get(5).setText(String.valueOf("E").toUpperCase());
            arrayListTextView.get(6).setText(String.valueOf("A").toUpperCase());
            arrayListTextView.get(7).setText(String.valueOf("K").toUpperCase());

            arrayListTextView.get(11).setText(String.valueOf("A").toUpperCase());
            arrayListTextView.get(20).setText(String.valueOf("P").toUpperCase());
            arrayListTextView.get(22).setText(String.valueOf("L").toUpperCase());
            arrayListTextView.get(31).setText(String.valueOf("O").toUpperCase());
            arrayListTextView.get(33).setText(String.valueOf("K").toUpperCase());
            arrayListTextView.get(42).setText(String.valueOf("L").toUpperCase());
            arrayListTextView.get(44).setText(String.valueOf("A").toUpperCase());
            arrayListTextView.get(53).setText(String.valueOf("I").toUpperCase());
            arrayListTextView.get(55).setText(String.valueOf("T").toUpperCase());
            arrayListTextView.get(64).setText(String.valueOf("T").toUpperCase());
            arrayListTextView.get(66).setText(String.valueOf("E").toUpperCase());
            arrayListTextView.get(75).setText(String.valueOf("I").toUpperCase());
            arrayListTextView.get(77).setText(String.valueOf("A").toUpperCase());
            arrayListTextView.get(86).setText(String.valueOf("K").toUpperCase());

            arrayListTextView.get(88).setText(String.valueOf("Z").toUpperCase());
            arrayListTextView.get(89).setText(String.valueOf("I").toUpperCase());
            arrayListTextView.get(90).setText(String.valueOf("N").toUpperCase());
            arrayListTextView.get(91).setText(String.valueOf("E").toUpperCase());
            arrayListTextView.get(92).setText(String.valueOf("G").toUpperCase());
            arrayListTextView.get(93).setText(String.valueOf("O").toUpperCase());
            arrayListTextView.get(94).setText(String.valueOf("T").toUpperCase());
            arrayListTextView.get(95).setText(String.valueOf("Z").toUpperCase());
            arrayListTextView.get(96).setText(String.valueOf("I").toUpperCase());
            arrayListTextView.get(97).setText(String.valueOf("A").toUpperCase());
        }
    }

    public void dialogo(){
        //Establecemos la ventana actual como contexto de nuestro dialog
        customDialog=new Dialog(Activity_Pantalla2.this);
        //Asignamos a nuestro dialogo el layout que hemos creado
        customDialog.setContentView(R.layout.dialog_sopaletras);
        //Accedemos a las variables del layout y las modificamos
        TextView tvPalabra=(TextView) customDialog.findViewById(R.id.tvPalabra);
        tvPalabra.setText(titulo);
        TextView tvExplicacion=(TextView) customDialog.findViewById(R.id.tvExplicacion);
        tvExplicacion.setText(mensaje);
        Button btnAceptar=(Button) customDialog.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
            }
        });
        //mostramos el dialogo
        customDialog.show();
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

//Hay una paradoja a resolver, arrayListAnterior y arrayListSeleccionado guardan lo mismo dentro, pero al sustituir all por uno solo
//el programa no funciona igual, no es importante pero ahí queda.

//Estaria bien solucionar el color amarillo

//Queda gestionar la vuelta al activity de mapa
