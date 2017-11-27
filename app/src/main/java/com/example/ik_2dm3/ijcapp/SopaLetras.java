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
        btn24.setText(ArraylistLetras.get(8));
        Button btn25=(Button)findViewById(R.id.btn25);
        btn25.setText(ArraylistLetras.get(9));
        Button btn26=(Button)findViewById(R.id.btn26);
        btn26.setText(ArraylistLetras.get(10));
        Button btn27=(Button)findViewById(R.id.btn27);
        btn27.setText(ArraylistLetras.get(11));
        Button btn28=(Button)findViewById(R.id.btn28);
        btn28.setText(ArraylistLetras.get(12));
        Button btn29=(Button)findViewById(R.id.btn29);
        btn29.setText(ArraylistLetras.get(13));
        //Button btn210=(Button)findViewById(R.id.btn210);
        Button btn211=(Button)findViewById(R.id.btn211);
        btn211.setText(ArraylistLetras.get(14));

        //Button btn31=(Button)findViewById(R.id.btn31);
        Button btn32=(Button)findViewById(R.id.btn32);
        btn32.setText(ArraylistLetras.get(15));
        Button btn33=(Button)findViewById(R.id.btn33);
        btn33.setText(ArraylistLetras.get(16));
        Button btn34=(Button)findViewById(R.id.btn34);
        btn34.setText(ArraylistLetras.get(17));
        Button btn35=(Button)findViewById(R.id.btn35);
        btn35.setText(ArraylistLetras.get(18));
        Button btn36=(Button)findViewById(R.id.btn36);
        btn36.setText(ArraylistLetras.get(19));
        Button btn37=(Button)findViewById(R.id.btn37);
        btn37.setText(ArraylistLetras.get(20));
        Button btn38=(Button)findViewById(R.id.btn38);
        btn38.setText(ArraylistLetras.get(21));
        Button btn39=(Button)findViewById(R.id.btn39);
        btn39.setText(ArraylistLetras.get(22));
        //Button btn310=(Button)findViewById(R.id.btn310);
        Button btn311=(Button)findViewById(R.id.btn311);
        btn311.setText(ArraylistLetras.get(23));

        //Button btn41=(Button)findViewById(R.id.btn41);
        Button btn42=(Button)findViewById(R.id.btn42);
        btn42.setText(ArraylistLetras.get(24));
        Button btn43=(Button)findViewById(R.id.btn43);
        btn43.setText(ArraylistLetras.get(25));
        Button btn44=(Button)findViewById(R.id.btn44);
        btn44.setText(ArraylistLetras.get(26));
        Button btn45=(Button)findViewById(R.id.btn45);
        btn45.setText(ArraylistLetras.get(27));
        Button btn46=(Button)findViewById(R.id.btn46);
        btn46.setText(ArraylistLetras.get(28));
        Button btn47=(Button)findViewById(R.id.btn47);
        btn47.setText(ArraylistLetras.get(29));
        Button btn48=(Button)findViewById(R.id.btn48);
        btn48.setText(ArraylistLetras.get(30));
        Button btn49=(Button)findViewById(R.id.btn49);
        btn49.setText(ArraylistLetras.get(31));
        //Button btn410=(Button)findViewById(R.id.btn410);
        Button btn411=(Button)findViewById(R.id.btn411);
        btn411.setText(ArraylistLetras.get(32));

        //Button btn51=(Button)findViewById(R.id.btn51);
        Button btn52=(Button)findViewById(R.id.btn52);
        btn52.setText(ArraylistLetras.get(33));
        Button btn53=(Button)findViewById(R.id.btn53);
        btn53.setText(ArraylistLetras.get(34));
        Button btn54=(Button)findViewById(R.id.btn54);
        btn54.setText(ArraylistLetras.get(35));
        Button btn55=(Button)findViewById(R.id.btn55);
        btn55.setText(ArraylistLetras.get(36));
        Button btn56=(Button)findViewById(R.id.btn56);
        btn56.setText(ArraylistLetras.get(37));
        Button btn57=(Button)findViewById(R.id.btn57);
        btn57.setText(ArraylistLetras.get(38));
        Button btn58=(Button)findViewById(R.id.btn58);
        btn58.setText(ArraylistLetras.get(39));
        Button btn59=(Button)findViewById(R.id.btn59);
        btn59.setText(ArraylistLetras.get(40));
        //Button btn510=(Button)findViewById(R.id.btn510);
        Button btn511=(Button)findViewById(R.id.btn511);
        btn511.setText(ArraylistLetras.get(41));

        //Button btn61=(Button)findViewById(R.id.btn61);
        Button btn62=(Button)findViewById(R.id.btn62);
        btn62.setText(ArraylistLetras.get(42));
        Button btn63=(Button)findViewById(R.id.btn63);
        btn63.setText(ArraylistLetras.get(43));
        Button btn64=(Button)findViewById(R.id.btn64);
        btn64.setText(ArraylistLetras.get(44));
        Button btn65=(Button)findViewById(R.id.btn65);
        btn65.setText(ArraylistLetras.get(45));
        Button btn66=(Button)findViewById(R.id.btn66);
        btn66.setText(ArraylistLetras.get(46));
        Button btn67=(Button)findViewById(R.id.btn67);
        btn67.setText(ArraylistLetras.get(47));
        Button btn68=(Button)findViewById(R.id.btn68);
        btn68.setText(ArraylistLetras.get(48));
        Button btn69=(Button)findViewById(R.id.btn69);
        btn69.setText(ArraylistLetras.get(49));
        //Button btn610=(Button)findViewById(R.id.btn610);
        Button btn611=(Button)findViewById(R.id.btn611);
        btn611.setText(ArraylistLetras.get(50));

        //Button btn71=(Button)findViewById(R.id.btn71);
        Button btn72=(Button)findViewById(R.id.btn72);
        btn72.setText(ArraylistLetras.get(51));
        Button btn73=(Button)findViewById(R.id.btn73);
        Button btn74=(Button)findViewById(R.id.btn74);
        Button btn75=(Button)findViewById(R.id.btn75);
        Button btn76=(Button)findViewById(R.id.btn76);
        Button btn77=(Button)findViewById(R.id.btn77);
        Button btn78=(Button)findViewById(R.id.btn78);
        Button btn79=(Button)findViewById(R.id.btn79);
        //Button btn710=(Button)findViewById(R.id.btn710);
        Button btn711=(Button)findViewById(R.id.btn711);

        //Button btn81=(Button)findViewById(R.id.btn81);
        Button btn82=(Button)findViewById(R.id.btn82);
        Button btn83=(Button)findViewById(R.id.btn83);
        Button btn84=(Button)findViewById(R.id.btn84);
        Button btn85=(Button)findViewById(R.id.btn85);
        Button btn86=(Button)findViewById(R.id.btn86);
        Button btn87=(Button)findViewById(R.id.btn87);
        Button btn88=(Button)findViewById(R.id.btn88);
        Button btn89=(Button)findViewById(R.id.btn89);
        //Button btn810=(Button)findViewById(R.id.btn810);
        Button btn811=(Button)findViewById(R.id.btn811);

        //Button btn91=(Button)findViewById(R.id.btn91);
        //Button btn92=(Button)findViewById(R.id.btn92);
        //Button btn93=(Button)findViewById(R.id.btn93);
        //Button btn94=(Button)findViewById(R.id.btn94);
        //Button btn95=(Button)findViewById(R.id.btn95);
        //Button btn96=(Button)findViewById(R.id.btn96);
        //Button btn97=(Button)findViewById(R.id.btn97);
        //Button btn98=(Button)findViewById(R.id.btn98);
        Button btn99=(Button)findViewById(R.id.btn99);
        //Button btn910=(Button)findViewById(R.id.btn910);
        Button btn911=(Button)findViewById(R.id.btn911);

    }



}
