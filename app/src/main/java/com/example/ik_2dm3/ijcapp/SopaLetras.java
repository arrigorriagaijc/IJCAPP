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
        for (int i=0; i<71;i++){
            char c = (char)(r.nextInt(26) + 'a');
            ArraylistLetras.add(Character.toUpperCase(c));
        }

        Button btn11=(Button)findViewById(R.id.btn11);
        btn11.setText(ArraylistLetras.get(0).toString());
        Button btn12=(Button)findViewById(R.id.btn12);
        btn12.setText(ArraylistLetras.get(1).toString());
        Button btn13=(Button)findViewById(R.id.btn13);
        btn13.setText("L");
        Button btn14=(Button)findViewById(R.id.btn14);
        btn14.setText("E");
        Button btn15=(Button)findViewById(R.id.btn15);
        btn15.setText("Y");
        Button btn16=(Button)findViewById(R.id.btn16);
        btn16.setText("E");
        Button btn17=(Button)findViewById(R.id.btn17);
        btn17.setText("S");
        Button btn18=(Button)findViewById(R.id.btn18);
        btn18.setText(ArraylistLetras.get(2).toString());
        Button btn19=(Button)findViewById(R.id.btn19);
        btn19.setText(ArraylistLetras.get(3).toString());
        Button btn110=(Button)findViewById(R.id.btn110);
        btn110.setText(ArraylistLetras.get(4).toString());
        Button btn111=(Button)findViewById(R.id.btn111);
        btn111.setText(ArraylistLetras.get(5).toString());

        Button btn21=(Button)findViewById(R.id.btn21);
        btn21.setText("A");
        Button btn22=(Button)findViewById(R.id.btn22);
        btn22.setText(ArraylistLetras.get(6).toString());
        Button btn23=(Button)findViewById(R.id.btn23);
        btn23.setText(ArraylistLetras.get(7).toString());
        Button btn24=(Button)findViewById(R.id.btn24);
        btn24.setText(ArraylistLetras.get(8).toString());
        Button btn25=(Button)findViewById(R.id.btn25);
        btn25.setText(ArraylistLetras.get(9).toString());
        Button btn26=(Button)findViewById(R.id.btn26);
        btn26.setText(ArraylistLetras.get(10).toString());
        Button btn27=(Button)findViewById(R.id.btn27);
        btn27.setText(ArraylistLetras.get(11).toString());
        Button btn28=(Button)findViewById(R.id.btn28);
        btn28.setText(ArraylistLetras.get(12).toString());
        Button btn29=(Button)findViewById(R.id.btn29);
        btn29.setText(ArraylistLetras.get(13).toString());
        Button btn210=(Button)findViewById(R.id.btn210);
        btn210.setText("P");
        Button btn211=(Button)findViewById(R.id.btn211);
        btn211.setText(ArraylistLetras.get(14).toString());

        Button btn31=(Button)findViewById(R.id.btn31);
        btn31.setText("L");
        Button btn32=(Button)findViewById(R.id.btn32);
        btn32.setText(ArraylistLetras.get(15).toString());
        Button btn33=(Button)findViewById(R.id.btn33);
        btn33.setText(ArraylistLetras.get(16).toString());
        Button btn34=(Button)findViewById(R.id.btn34);
        btn34.setText(ArraylistLetras.get(17).toString());
        Button btn35=(Button)findViewById(R.id.btn35);
        btn35.setText(ArraylistLetras.get(18).toString());
        Button btn36=(Button)findViewById(R.id.btn36);
        btn36.setText(ArraylistLetras.get(19).toString());
        Button btn37=(Button)findViewById(R.id.btn37);
        btn37.setText(ArraylistLetras.get(20).toString());
        Button btn38=(Button)findViewById(R.id.btn38);
        btn38.setText(ArraylistLetras.get(21).toString());
        Button btn39=(Button)findViewById(R.id.btn39);
        btn39.setText(ArraylistLetras.get(22).toString());
        Button btn310=(Button)findViewById(R.id.btn310);
        btn310.setText("O");
        Button btn311=(Button)findViewById(R.id.btn311);
        btn311.setText(ArraylistLetras.get(23).toString());

        Button btn41=(Button)findViewById(R.id.btn41);
        btn41.setText("C");
        Button btn42=(Button)findViewById(R.id.btn42);
        btn42.setText(ArraylistLetras.get(24).toString());
        Button btn43=(Button)findViewById(R.id.btn43);
        btn43.setText(ArraylistLetras.get(25).toString());
        Button btn44=(Button)findViewById(R.id.btn44);
        btn44.setText(ArraylistLetras.get(26).toString());
        Button btn45=(Button)findViewById(R.id.btn45);
        btn45.setText(ArraylistLetras.get(27).toString());
        Button btn46=(Button)findViewById(R.id.btn46);
        btn46.setText(ArraylistLetras.get(28).toString());
        Button btn47=(Button)findViewById(R.id.btn47);
        btn47.setText(ArraylistLetras.get(29).toString());
        Button btn48=(Button)findViewById(R.id.btn48);
        btn48.setText(ArraylistLetras.get(30).toString());
        Button btn49=(Button)findViewById(R.id.btn49);
        btn49.setText(ArraylistLetras.get(31).toString());
        Button btn410=(Button)findViewById(R.id.btn410);
        btn410.setText("L");
        Button btn411=(Button)findViewById(R.id.btn411);
        btn411.setText(ArraylistLetras.get(32).toString());

        Button btn51=(Button)findViewById(R.id.btn51);
        btn51.setText("A");
        Button btn52=(Button)findViewById(R.id.btn52);
        btn52.setText(ArraylistLetras.get(33).toString());
        Button btn53=(Button)findViewById(R.id.btn53);
        btn53.setText(ArraylistLetras.get(34).toString());
        Button btn54=(Button)findViewById(R.id.btn54);
        btn54.setText(ArraylistLetras.get(35).toString());
        Button btn55=(Button)findViewById(R.id.btn55);
        btn55.setText(ArraylistLetras.get(36).toString());
        Button btn56=(Button)findViewById(R.id.btn56);
        btn56.setText(ArraylistLetras.get(37).toString());
        Button btn57=(Button)findViewById(R.id.btn57);
        btn57.setText(ArraylistLetras.get(38).toString());
        Button btn58=(Button)findViewById(R.id.btn58);
        btn58.setText(ArraylistLetras.get(39).toString());
        Button btn59=(Button)findViewById(R.id.btn59);
        btn59.setText(ArraylistLetras.get(40).toString());
        Button btn510=(Button)findViewById(R.id.btn510);
        btn510.setText("I");
        Button btn511=(Button)findViewById(R.id.btn511);
        btn511.setText(ArraylistLetras.get(41).toString());

        Button btn61=(Button)findViewById(R.id.btn61);
        btn61.setText("L");
        Button btn62=(Button)findViewById(R.id.btn62);
        btn62.setText(ArraylistLetras.get(42).toString());
        Button btn63=(Button)findViewById(R.id.btn63);
        btn63.setText(ArraylistLetras.get(43).toString());
        Button btn64=(Button)findViewById(R.id.btn64);
        btn64.setText(ArraylistLetras.get(44).toString());
        Button btn65=(Button)findViewById(R.id.btn65);
        btn65.setText(ArraylistLetras.get(45).toString());
        Button btn66=(Button)findViewById(R.id.btn66);
        btn66.setText(ArraylistLetras.get(46).toString());
        Button btn67=(Button)findViewById(R.id.btn67);
        btn67.setText(ArraylistLetras.get(47).toString());
        Button btn68=(Button)findViewById(R.id.btn68);
        btn68.setText(ArraylistLetras.get(48).toString());
        Button btn69=(Button)findViewById(R.id.btn69);
        btn69.setText(ArraylistLetras.get(49).toString());
        Button btn610=(Button)findViewById(R.id.btn610);
        btn610.setText("T");
        Button btn611=(Button)findViewById(R.id.btn611);
        btn611.setText(ArraylistLetras.get(50).toString());

        Button btn71=(Button)findViewById(R.id.btn71);
        btn71.setText("D");
        Button btn72=(Button)findViewById(R.id.btn72);
        btn72.setText(ArraylistLetras.get(51).toString());
        Button btn73=(Button)findViewById(R.id.btn73);
        btn73.setText(ArraylistLetras.get(52).toString());
        Button btn74=(Button)findViewById(R.id.btn74);
        btn74.setText(ArraylistLetras.get(53).toString());
        Button btn75=(Button)findViewById(R.id.btn75);
        btn75.setText(ArraylistLetras.get(54).toString());
        Button btn76=(Button)findViewById(R.id.btn76);
        btn76.setText(ArraylistLetras.get(55).toString());
        Button btn77=(Button)findViewById(R.id.btn77);
        btn77.setText(ArraylistLetras.get(56).toString());
        Button btn78=(Button)findViewById(R.id.btn78);
        btn78.setText(ArraylistLetras.get(57).toString());
        Button btn79=(Button)findViewById(R.id.btn79);
        btn79.setText(ArraylistLetras.get(58).toString());
        Button btn710=(Button)findViewById(R.id.btn710);
        btn710.setText("I");
        Button btn711=(Button)findViewById(R.id.btn711);
        btn711.setText(ArraylistLetras.get(59).toString());

        Button btn81=(Button)findViewById(R.id.btn81);
        btn81.setText("E");
        Button btn82=(Button)findViewById(R.id.btn82);
        btn82.setText(ArraylistLetras.get(60).toString());
        Button btn83=(Button)findViewById(R.id.btn83);
        btn83.setText(ArraylistLetras.get(61).toString());
        Button btn84=(Button)findViewById(R.id.btn84);
        btn84.setText(ArraylistLetras.get(62).toString());
        Button btn85=(Button)findViewById(R.id.btn85);
        btn85.setText(ArraylistLetras.get(63).toString());
        Button btn86=(Button)findViewById(R.id.btn86);
        btn86.setText(ArraylistLetras.get(64).toString());
        Button btn87=(Button)findViewById(R.id.btn87);
        btn87.setText(ArraylistLetras.get(65).toString());
        Button btn88=(Button)findViewById(R.id.btn88);
        btn88.setText(ArraylistLetras.get(66).toString());
        Button btn89=(Button)findViewById(R.id.btn89);
        btn89.setText(ArraylistLetras.get(67).toString());
        Button btn810=(Button)findViewById(R.id.btn810);
        btn810.setText("C");
        Button btn811=(Button)findViewById(R.id.btn811);
        btn811.setText(ArraylistLetras.get(68).toString());

        Button btn91=(Button)findViewById(R.id.btn91);
        btn91.setText("C");
        Button btn92=(Button)findViewById(R.id.btn92);
        btn92.setText("O");
        Button btn93=(Button)findViewById(R.id.btn93);
        btn93.setText("N");
        Button btn94=(Button)findViewById(R.id.btn94);
        btn94.setText("C");
        Button btn95=(Button)findViewById(R.id.btn95);
        btn95.setText("E");
        Button btn96=(Button)findViewById(R.id.btn96);
        btn96.setText("J");
        Button btn97=(Button)findViewById(R.id.btn97);
        btn97.setText("A");
        Button btn98=(Button)findViewById(R.id.btn98);
        btn98.setText("L");
        Button btn99=(Button)findViewById(R.id.btn99);
        btn99.setText(ArraylistLetras.get(69).toString());
        Button btn910=(Button)findViewById(R.id.btn910);
        btn910.setText("A");
        Button btn911=(Button)findViewById(R.id.btn911);
        btn911.setText(ArraylistLetras.get(70).toString());

        btn11.setOn

    }



}
