package com.example.ik_2dm3.ijcapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Pantalla5 extends AppCompatActivity {

    private Dialog customDialog = null;
    private String titulo;
    private Drawable imagen;
    private Button btnSiguiente;
    private Button btnPista1;
    private Button btnPista2;
    private Button btnPista3;
    private RadioButton rbRespuesta11;
    private RadioButton rbRespuesta12;
    private RadioButton rbRespuesta13;
    private RadioButton rbRespuesta21;
    private RadioButton rbRespuesta22;
    private RadioButton rbRespuesta23;
    private RadioButton rbRespuesta31;
    private RadioButton rbRespuesta32;
    private RadioButton rbRespuesta33;
    private boolean pregunta1Acertada=false;
    private boolean pregunta2Acertada=false;
    private boolean pregunta3Acertada=false;
    private Toast toast;

    //Creamos una etiqueta para busqueda de errores
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla5);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnPista1 = (Button) findViewById(R.id.btnPista1);
        btnPista2 = (Button) findViewById(R.id.btnPista2);
        btnPista3 = (Button) findViewById(R.id.btnPista3);
        rbRespuesta11 = (RadioButton) findViewById(R.id.rbRespuesta11);
        rbRespuesta12 = (RadioButton) findViewById(R.id.rbRespuesta12);
        rbRespuesta13 = (RadioButton) findViewById(R.id.rbRespuesta13);
        rbRespuesta21 = (RadioButton) findViewById(R.id.rbRespuesta21);
        rbRespuesta22 = (RadioButton) findViewById(R.id.rbRespuesta22);
        rbRespuesta23 = (RadioButton) findViewById(R.id.rbRespuesta23);
        rbRespuesta31 = (RadioButton) findViewById(R.id.rbRespuesta31);
        rbRespuesta32 = (RadioButton) findViewById(R.id.rbRespuesta32);
        rbRespuesta33 = (RadioButton) findViewById(R.id.rbRespuesta33);

        //codigo para corregir las preguntas
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbRespuesta11.isChecked()) {
                    pregunta1Acertada=false;
                    rbRespuesta11.setBackgroundColor(Color.RED);
                    btnPista1.setVisibility(View.VISIBLE);
                }else if (rbRespuesta12.isChecked()) {
                    pregunta1Acertada=true;
                    rbRespuesta12.setBackgroundColor(Color.GREEN);
                } else if (rbRespuesta13.isChecked()) {
                    pregunta1Acertada=false;
                    rbRespuesta13.setBackgroundColor(Color.RED);
                    btnPista1.setVisibility(View.VISIBLE);
                }

                if (rbRespuesta21.isChecked()) {
                    pregunta2Acertada=false;
                    rbRespuesta21.setBackgroundColor(Color.RED);
                    btnPista2.setVisibility(View.VISIBLE);
                } else if (rbRespuesta22.isChecked()) {
                    pregunta2Acertada=false;
                    rbRespuesta22.setBackgroundColor(Color.RED);
                    btnPista2.setVisibility(View.VISIBLE);
                } else if (rbRespuesta23.isChecked()) {
                    pregunta2Acertada=true;
                    rbRespuesta23.setBackgroundColor(Color.GREEN);
                }

                if (rbRespuesta31.isChecked()) {
                    pregunta3Acertada=false;
                    rbRespuesta31.setBackgroundColor(Color.RED);
                    btnPista3.setVisibility(View.VISIBLE);
                } else if (rbRespuesta32.isChecked()) {
                    pregunta3Acertada=true;
                    rbRespuesta32.setBackgroundColor(Color.GREEN);
                } else if (rbRespuesta33.isChecked()) {
                    pregunta3Acertada=false;
                    Log.d(TAG,"Funciona");
                    rbRespuesta33.setBackgroundColor(Color.RED);
                    btnPista3.setVisibility(View.VISIBLE);
                }
                if(pregunta1Acertada==true && pregunta2Acertada==true && pregunta3Acertada==true){
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.acierto,
                            (ViewGroup) findViewById(R.id.clAcierto));


                    //Creamos el toast
                    toast = new Toast(getApplicationContext());
                    //Lo centramos
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    //Le ponemos duración corta
                    toast.setDuration(Toast.LENGTH_SHORT);
                    //Le asignamos el layout
                    toast.setView(layout);
                    //Lo mostramos
                    toast.show();
                    Intent intent=new Intent(getApplicationContext(), Pista6.class);
                    startActivity(intent);
                }
            }
        });

        btnPista1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulo="Pista 1:";
                imagen=getResources().getDrawable(R.drawable.pista1);
                dialogo();
            }
        });

        btnPista2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulo="Pista 2:";
                imagen=getResources().getDrawable(R.drawable.fondopista5);
                dialogo();
            }
        });

        btnPista3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulo="Pista 3:";
                imagen=getResources().getDrawable(R.drawable.pista3);
                dialogo();
            }
        });

    }

    // codigo para crear el dialog
        public void dialogo () {
            //Establecemos la ventana actual como contexto de nuestro dialog
            customDialog = new Dialog(Activity_Pantalla5.this);
            //Asignamos a nuestro dialogo el layout que hemos creado
            customDialog.setContentView(R.layout.dialog_pista);
            //Accedemos a las variables del layout y las modificamos
            TextView tvPalabra = (TextView) customDialog.findViewById(R.id.tvPalabra);
            tvPalabra.setText(titulo);
            TextView tvPista = (TextView) customDialog.findViewById(R.id.tvPista);
            ImageView ivImagenPista=(ImageView) customDialog.findViewById(R.id.ivImagenPista);
            if (titulo.equals("Pista 1:")) {
                tvPista.setText(R.string.pista1pregunta4);
                ivImagenPista.setVisibility(View.GONE);
            }else{
                tvPista.setVisibility(View.GONE);
                ivImagenPista.setImageDrawable(imagen);
            }
            Button btnAceptar = (Button) customDialog.findViewById(R.id.btnAceptar);
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

