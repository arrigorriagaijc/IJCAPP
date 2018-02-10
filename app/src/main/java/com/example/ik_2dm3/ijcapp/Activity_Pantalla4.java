package com.example.ik_2dm3.ijcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Pantalla4 extends AppCompatActivity implements View.OnDragListener, OnTouchListener {
    private Button btnSiguiente;
    private TextView txtLonbo1,txtLonbo2,txtLonbo3,txtLonbo4,txtLonbo5,txtLonbo6;
    private ImageView imgIndus,imgTrabajo,imgTeatro,imgInfor;
    private int cont =0;
    @Override
    public boolean onDrag(View v , DragEvent event){
        if (event.getAction()==DragEvent.ACTION_DROP)
        {
            TextView dropped = (TextView)event.getLocalState();
            ImageView dropTarget = (ImageView) v;
            if (dropTarget.getContentDescription().toString().compareToIgnoreCase(txtLonbo1.getText().toString())==0){
                if(dropped.getText().toString().compareToIgnoreCase(getString(R.string.txtlonbo1))==0){
                 dropTarget.setImageResource(R.drawable.imgindus);
                    txtLonbo1.setVisibility(View.INVISIBLE);
                    cont++;
                    comprobarfin();
                }
            }
            if(dropTarget.getId() == R.id.imgInformatica){
                if(dropped.getText().toString().compareToIgnoreCase(getString(R.string.txtlonbo4))==0){
                    dropTarget.setImageResource(R.drawable.imginforma);
                    txtLonbo4.setVisibility(View.INVISIBLE);
                    cont++;
                    comprobarfin();
                }
            }
            if(dropTarget.getId() == R.id.imgTeatro){
                if(dropped.getText().toString().compareToIgnoreCase(getString(R.string.txtlonbo2))==0){
                    dropTarget.setImageResource(R.drawable.imgteatro);
                    txtLonbo2.setVisibility(View.INVISIBLE);
                    cont++;
                    comprobarfin();
                }
            }
            if(dropTarget.getId() == R.id.imgTrabajos){
                if(dropped.getText().toString().compareToIgnoreCase(getString(R.string.txtlonbo5))==0){
                    dropTarget.setImageResource(R.drawable.imbtrabajo);
                    txtLonbo5.setVisibility(View.INVISIBLE);
                    cont++;
                    comprobarfin();
                }
            }
        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

       if(v.getVisibility()== View.VISIBLE){
            if (event.getAction()==MotionEvent.ACTION_DOWN)
            {
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(null, shadowBuilder, v, 0);
            }
        }
        return true;

    }

    private void comprobarfin(){

        if(cont ==4){
            btnSiguiente.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(getApplicationContext(),"Enhora buena",Toast.LENGTH_LONG);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pantalla4);
        //creacion de los textos y asignacion de eventos
        txtLonbo1 = findViewById(R.id.txtlonbo1);
        txtLonbo2 = findViewById(R.id.txtlonbo2);
        txtLonbo3 = findViewById(R.id.txtlonbo3);
        txtLonbo4 = findViewById(R.id.txtlonbo4);
        txtLonbo5 = findViewById(R.id.txtlonbo5);
        txtLonbo6 = findViewById(R.id.txtlonbo6);

        txtLonbo1.setOnTouchListener(this);
        txtLonbo2.setOnTouchListener(this);
        txtLonbo3.setOnTouchListener(this);
        txtLonbo4.setOnTouchListener(this);
        txtLonbo5.setOnTouchListener(this);
        txtLonbo6.setOnTouchListener(this);

        imgIndus = findViewById(R.id.imgIndus);
        imgInfor = findViewById(R.id.imgInformatica);
        imgTeatro = findViewById(R.id.imgTeatro);
        imgTrabajo = findViewById(R.id.imgTrabajos);

        imgIndus.setOnDragListener(this);
        imgInfor.setOnDragListener(this);
        imgTeatro.setOnDragListener(this);
        imgTrabajo.setOnDragListener(this);

        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Pista5.class);
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
