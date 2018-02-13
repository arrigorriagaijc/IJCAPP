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
    private double latitude;
    private double longitude;
    private double hipotenusa;
    private boolean salir=false;
    private boolean activar=false;
    private static final String TAG = "TAG";
    private boolean unavez=false;

    public Listeners_distancias_marcadores(){
        this.googleMap=null;
        this.activity_mapa=null;
        this.longitude=0;
        this.latitude=0;
    }

    public Listeners_distancias_marcadores(GoogleMap gm, Activity_Mapa am, double latitud, double longitud){
        this.googleMap=gm;
        this.activity_mapa=am;
        this.longitude=longitud;
        this.latitude=latitud;
    }

    public void run(){
        while(salir==false) {
            activity_mapa.ObtenerCoordenadas();
            hipotenusa=Math.sqrt((latitude - activity_mapa.getLatitude())*(latitude - activity_mapa.getLatitude())+(longitude - activity_mapa.getLongitude())*(longitude - activity_mapa.getLongitude()));
            //Log.d(TAG,String.valueOf(hipotenusa));
            if (hipotenusa<=0.000282 && unavez==false){
                /*activar=true;
                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        if (marker.getTitle().equals("Arrigorriagako plaza")) {
                            //CAmbio la imagen al marcador
                            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.plazaarrigorriagaredondo));
                            //CReo el intent
                            Intent intent = new Intent(activity_mapa, Activity_Pantalla1.class);
                            //Inicio el activity nuevo
                            startActivity(intent);
                        }
                        return false;
                    }
                });*/
                unavez=true;
                salir=true;
            }
        }
    }

    public void setSalir(boolean salir) {
        this.salir = salir;
    }

    public boolean isActivar() {
        return activar;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
