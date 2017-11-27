package com.example.ik_2dm3.ijcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class SopaLetras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sopaletras);
        Random r = new Random();

        ArrayList<Character> ArraylistLetras=new ArrayList<>();
        for (int i=0; i<72;i++){
            char c = (char)(r.nextInt(26) + 'a');
            ArraylistLetras.add(Character.toUpperCase(c));
        }

        Button btn11=(Button)findViewById(R.id.btn11);
        btn11.setText(ArraylistLetras.get(0));
        Button btn12=(Button)findViewById(R.id.btn12);
        btn12.setText(ArraylistLetras.get(1));
        //Button btn13=(Button)findViewById(R.id.btn13);
        //Button btn14=(Button)findViewById(R.id.btn14);
        //Button btn15=(Button)findViewById(R.id.btn15);
        //Button btn16=(Button)findViewById(R.id.btn16);
        //Button btn17=(Button)findViewById(R.id.btn17);
        Button btn18=(Button)findViewById(R.id.btn18);
        btn18.setText(ArraylistLetras.get(2));
        Button btn19=(Button)findViewById(R.id.btn19);
        btn19.setText(ArraylistLetras.get(3));
        Button btn110=(Button)findViewById(R.id.btn110);
        btn110.setText(ArraylistLetras.get(4));
        Button btn111=(Button)findViewById(R.id.btn111);
        btn111.setText(ArraylistLetras.get(5));

        //Button btn21=(Button)findViewById(R.id.btn21);
        Button btn22=(Button)findViewById(R.id.btn22);
        btn22.setText(ArraylistLetras.get(6));
        Button btn23=(Button)findViewById(R.id.btn23);
        btn23.setText(ArraylistLetras.get(7));
        Button btn24=(Button)findViewById(R.id.btn24);
        btn22.setText(ArraylistLetras.get(6));
        Button btn25=(Button)findViewById(R.id.btn25);
        Button btn26=(Button)findViewById(R.id.btn26);
        Button btn27=(Button)findViewById(R.id.btn27);
        Button btn28=(Button)findViewById(R.id.btn28);
        Button btn29=(Button)findViewById(R.id.btn29);
        //Button btn210=(Button)findViewById(R.id.btn210);
        Button btn211=(Button)findViewById(R.id.btn211);

        //Button btn31=(Button)findViewById(R.id.btn31);
        Button btn32=(Button)findViewById(R.id.btn32);
        Button btn33=(Button)findViewById(R.id.btn33);
        Button btn34=(Button)findViewById(R.id.btn34);
        Button btn35=(Button)findViewById(R.id.btn35);
        Button btn36=(Button)findViewById(R.id.btn36);
        Button btn37=(Button)findViewById(R.id.btn37);
        Button btn38=(Button)findViewById(R.id.btn38);
        Button btn39=(Button)findViewById(R.id.btn39);
        //Button btn310=(Button)findViewById(R.id.btn310);
        Button btn311=(Button)findViewById(R.id.btn311);

        //Button btn41=(Button)findViewById(R.id.btn41);
        Button btn42=(Button)findViewById(R.id.btn42);
        Button btn43=(Button)findViewById(R.id.btn43);
        Button btn44=(Button)findViewById(R.id.btn44);
        Button btn45=(Button)findViewById(R.id.btn45);
        Button btn46=(Button)findViewById(R.id.btn46);
        Button btn47=(Button)findViewById(R.id.btn47);
        Button btn48=(Button)findViewById(R.id.btn48);
        Button btn49=(Button)findViewById(R.id.btn49);
        //Button btn410=(Button)findViewById(R.id.btn410);
        Button btn411=(Button)findViewById(R.id.btn411);

        //Button btn51=(Button)findViewById(R.id.btn51);
        Button btn52=(Button)findViewById(R.id.btn52);
        Button btn53=(Button)findViewById(R.id.btn53);
        Button btn54=(Button)findViewById(R.id.btn54);
        Button btn55=(Button)findViewById(R.id.btn55);
        Button btn56=(Button)findViewById(R.id.btn56);
        Button btn57=(Button)findViewById(R.id.btn57);
        Button btn58=(Button)findViewById(R.id.btn58);
        Button btn59=(Button)findViewById(R.id.btn59);
        //Button btn510=(Button)findViewById(R.id.btn510);
        Button btn511=(Button)findViewById(R.id.btn511);

        //Button btn61=(Button)findViewById(R.id.btn61);
        Button btn62=(Button)findViewById(R.id.btn62);
        Button btn63=(Button)findViewById(R.id.btn63);
        Button btn64=(Button)findViewById(R.id.btn64);
        Button btn65=(Button)findViewById(R.id.btn65);
        Button btn66=(Button)findViewById(R.id.btn66);
        Button btn67=(Button)findViewById(R.id.btn67);
        Button btn68=(Button)findViewById(R.id.btn68);
        Button btn69=(Button)findViewById(R.id.btn69);
        //Button btn610=(Button)findViewById(R.id.btn610);
        Button btn611=(Button)findViewById(R.id.btn611);

        //Button btn71=(Button)findViewById(R.id.btn71);
        Button btn72=(Button)findViewById(R.id.btn72);
        Button btn73=(Button)findViewById(R.id.btn73);
        btn73.setText(ArraylistLetras.get(54));
        Button btn74=(Button)findViewById(R.id.btn74);
        btn74.setText(ArraylistLetras.get(55));
        Button btn75=(Button)findViewById(R.id.btn75);
        btn75.setText(ArraylistLetras.get(56));
        Button btn76=(Button)findViewById(R.id.btn76);
        btn76.setText(ArraylistLetras.get(57));
        Button btn77=(Button)findViewById(R.id.btn77);
        btn77.setText(ArraylistLetras.get(58));
        Button btn78=(Button)findViewById(R.id.btn78);
        btn78.setText(ArraylistLetras.get(59));
        Button btn79=(Button)findViewById(R.id.btn79);
        btn79.setText(ArraylistLetras.get(60));
        //Button btn710=(Button)findViewById(R.id.btn710);
        Button btn711=(Button)findViewById(R.id.btn711);
        btn711.setText(ArraylistLetras.get(61));

        //Button btn81=(Button)findViewById(R.id.btn81);
        Button btn82=(Button)findViewById(R.id.btn82);
        btn82.setText(ArraylistLetras.get(62));
        Button btn83=(Button)findViewById(R.id.btn83);
        btn83.setText(ArraylistLetras.get(63));
        Button btn84=(Button)findViewById(R.id.btn84);
        btn84.setText(ArraylistLetras.get(64));
        Button btn85=(Button)findViewById(R.id.btn85);
        btn85.setText(ArraylistLetras.get(65));
        Button btn86=(Button)findViewById(R.id.btn86);
        btn86.setText(ArraylistLetras.get(66));
        Button btn87=(Button)findViewById(R.id.btn87);
        btn86.setText(ArraylistLetras.get(67));
        Button btn88=(Button)findViewById(R.id.btn88);
        btn87.setText(ArraylistLetras.get(68));
        Button btn89=(Button)findViewById(R.id.btn89);
        btn89.setText(ArraylistLetras.get(68));
        //Button btn810=(Button)findViewById(R.id.btn810);
        Button btn811=(Button)findViewById(R.id.btn811);
        btn811.setText(ArraylistLetras.get(69));

        //Button btn91=(Button)findViewById(R.id.btn91);
        //Button btn92=(Button)findViewById(R.id.btn92);
        //Button btn93=(Button)findViewById(R.id.btn93);
        //Button btn94=(Button)findViewById(R.id.btn94);
        //Button btn95=(Button)findViewById(R.id.btn95);
        //Button btn96=(Button)findViewById(R.id.btn96);
        //Button btn97=(Button)findViewById(R.id.btn97);
        //Button btn98=(Button)findViewById(R.id.btn98);
        Button btn99=(Button)findViewById(R.id.btn99);
        btn99.setText(ArraylistLetras.get(70));
        //Button btn910=(Button)findViewById(R.id.btn910);
        Button btn911=(Button)findViewById(R.id.btn911);
        btn911.setText(ArraylistLetras.get(71));

    }



}
