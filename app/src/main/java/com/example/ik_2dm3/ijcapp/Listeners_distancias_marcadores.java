package com.example.ik_2dm3.ijcapp;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by Jon Andoni on 09/02/2018.
 */

public class Listeners_distancias_marcadores extends Thread {
    private GoogleMap googleMap;
    private Activity_Mapa activity_mapa;
    private double hipotenusa1;
    private double hipotenusa2;
    private double hipotenusa3;
    private double hipotenusa4;
    private double hipotenusa5;
    private double hipotenusa6;
    private boolean salir = false;
    private boolean activar = false;
    private static final String TAG = "TAG";

    public Listeners_distancias_marcadores() {
        this.activity_mapa = null;
    }

    public Listeners_distancias_marcadores(Activity_Mapa am) {
        this.activity_mapa = am;
    }

    public void run() {
        while (salir == false) {
            activity_mapa.ObtenerCoordenadas();
            hipotenusa1 = Math.sqrt((43.206097 - activity_mapa.getLatitude()) * (43.206097 - activity_mapa.getLatitude()) + (-2.88804 - activity_mapa.getLongitude()) * (-2.88804 - activity_mapa.getLongitude()));
            hipotenusa2 = Math.sqrt((43.205918 - activity_mapa.getLatitude()) * (43.205918 - activity_mapa.getLatitude()) + (-2.887718 - activity_mapa.getLongitude()) * (-2.887718 - activity_mapa.getLongitude()));
            hipotenusa3 = Math.sqrt((43.2056 - activity_mapa.getLatitude()) * (43.2056 - activity_mapa.getLatitude()) + (-2.88866 - activity_mapa.getLongitude()) * (-2.88866 - activity_mapa.getLongitude()));
            hipotenusa4 = Math.sqrt((43.211879 - activity_mapa.getLatitude()) * (43.211879 - activity_mapa.getLatitude()) + (-2.888431 - activity_mapa.getLongitude()) * (-2.888431 - activity_mapa.getLongitude()));
            hipotenusa5 = Math.sqrt((43.209679 - activity_mapa.getLatitude()) * (43.209679 - activity_mapa.getLatitude()) + (-2.888369 - activity_mapa.getLongitude()) * (-2.888369 - activity_mapa.getLongitude()));
            hipotenusa6 = Math.sqrt((43.209462 - activity_mapa.getLatitude()) * (43.209462 - activity_mapa.getLatitude()) + (-2.888372 - activity_mapa.getLongitude()) * (-2.888372 - activity_mapa.getLongitude()));
            //Log.d(TAG,String.valueOf(hipotenusa));
            if (hipotenusa1 <= 0.000282 && activity_mapa.isActivado1() == false) {
                Log.d(TAG,"Activamos 1");
                activity_mapa.setActivado1(true);
                salir = true;
            }
            if (hipotenusa2 <= 0.000282 && activity_mapa.isActivado2() == false) {
                Log.d(TAG,"Ativamos 2");
                activity_mapa.setActivado2(true);
                salir = true;
            }
            if (hipotenusa3 <= 0.000282 && activity_mapa.isActivado3() == false) {
                activity_mapa.setActivado3(true);
                salir = true;
            }
            if (hipotenusa4 <= 0.000282 && activity_mapa.isActivado4() == false) {
                activity_mapa.setActivado4(true);
                salir = true;
            }
            if (hipotenusa5 <= 0.000282 && activity_mapa.isActivado5() == false) {
                activity_mapa.setActivado5(true);
                salir = true;
            }
            if (hipotenusa6 <= 0.000282 && activity_mapa.isActivado6() == false) {
                activity_mapa.setActivado6(true);
                salir = true;
            }
            if(salir) {
                //android.os.Process.killProcess((int)this.getId());
            }
        }
    }

    public void setSalir(boolean salir) {
        this.salir = salir;
    }



}
