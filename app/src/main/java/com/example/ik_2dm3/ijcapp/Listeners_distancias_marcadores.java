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
  /*  private GoogleMap googleMap;
    private Activity_Mapa activity_mapa;
    private double hipotenusa1;
    private double hipotenusa2;
    private double hipotenusa3;
    private double hipotenusa4;
    private double hipotenusa5;
    private double hipotenusa6;
    private int activity;
    private boolean salir = false;
    private static final String TAG = "TAG";

    public Listeners_distancias_marcadores() {
        this.activity_mapa = null;
        this.activity=0;
    }

    public Listeners_distancias_marcadores(Activity_Mapa am,int activity) {
        this.activity_mapa = am;
        this.activity=activity;
    }

    public void run() {
            while (salir == false) {
                //Log.d(TAG, "hilo");

                activity_mapa.ObtenerCoordenadas();
                if(this.activity==1){
                    hipotenusa1 = Math.sqrt((43.206097 - activity_mapa.getLatitude()) * (43.206097 - activity_mapa.getLatitude()) + (-2.88804 - activity_mapa.getLongitude()) * (-2.88804 - activity_mapa.getLongitude()));
                    if (hipotenusa1 <= 0.000282 && activity_mapa.isActivado1() == false) {
                        Log.d(TAG, "Activamos 1");
                        activity_mapa.setActivado1(true);
                        salir = true;
                    }
                }else if(this.activity==2){
                    hipotenusa2 = Math.sqrt((43.205918 - activity_mapa.getLatitude()) * (43.205918 - activity_mapa.getLatitude()) + (-2.887718 - activity_mapa.getLongitude()) * (-2.887718 - activity_mapa.getLongitude()));
                    if (hipotenusa2 <= 0.000282 && activity_mapa.isActivado2() == false) {
                        Log.d(TAG, "Activamos 2");
                        activity_mapa.setActivado2(true);
                        salir = true;
                    }
                }else if(this.activity==3){
                    hipotenusa3 = Math.sqrt((43.2056 - activity_mapa.getLatitude()) * (43.2056 - activity_mapa.getLatitude()) + (-2.88866 - activity_mapa.getLongitude()) * (-2.88866 - activity_mapa.getLongitude()));
                    if (hipotenusa3 <= 0.000282 && activity_mapa.isActivado3() == false) {
                        Log.d(TAG, "Activamos 3");
                        activity_mapa.setActivado3(true);
                        salir = true;
                    }
                }else if(this.activity==4){
                    hipotenusa4 = Math.sqrt((43.211879 - activity_mapa.getLatitude()) * (43.211879 - activity_mapa.getLatitude()) + (-2.888431 - activity_mapa.getLongitude()) * (-2.888431 - activity_mapa.getLongitude()));
                    if (hipotenusa4 <= 0.000282 && activity_mapa.isActivado4() == false) {
                        Log.d(TAG, "Activamos 4");
                        activity_mapa.setActivado4(true);
                        salir = true;
                    }
                }else if(this.activity==5){
                    hipotenusa5 = Math.sqrt((43.209679 - activity_mapa.getLatitude()) * (43.209679 - activity_mapa.getLatitude()) + (-2.888369 - activity_mapa.getLongitude()) * (-2.888369 - activity_mapa.getLongitude()));
                    if (hipotenusa5 <= 0.000282 && activity_mapa.isActivado5() == false) {
                        Log.d(TAG, "Activamos 5");
                        activity_mapa.setActivado5(true);
                        salir = true;
                    }
                }else if(this.activity==6){
                    hipotenusa6 = Math.sqrt((43.209462 - activity_mapa.getLatitude()) * (43.209462 - activity_mapa.getLatitude()) + (-2.888372 - activity_mapa.getLongitude()) * (-2.888372 - activity_mapa.getLongitude()));
                    if (hipotenusa6 <= 0.000282 && activity_mapa.isActivado6() == false) {
                        Log.d(TAG, "Activamos 6");
                        activity_mapa.setActivado6(true);
                        salir = true;
                    }
                }
            }
    }


    public void setSalir(boolean salir) {
        this.salir = salir;
    }
*/

}
