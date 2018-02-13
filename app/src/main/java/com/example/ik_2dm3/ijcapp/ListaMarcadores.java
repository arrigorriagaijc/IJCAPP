package com.example.ik_2dm3.ijcapp;

import java.util.ArrayList;

/**
 * Created by ik_2dm3 on 10/02/2018.
 */

public class ListaMarcadores {
    private int id;
    private ArrayList<Marcador> lista = new ArrayList<Marcador>();

    public ListaMarcadores(){

    }

    public int getVersion(){
        return this.id;
    }
    public ArrayList<Marcador> getListaMarcadores(){
        return this.lista;
    }

    public void setVersion(int version) {
        this.id = version;
    }

    public static class Marcador{
        private String title;
        private double latitud;
        private double longitud;
        private int icon;


        public Marcador(){

        }
        public Marcador (String pNombre, double pLati, double pLongi, int icon){
            this.title = pNombre;
            this.icon = icon;
            this.latitud = pLati;
            this.longitud = pLongi;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getLatitud() {
            return latitud;
        }

        public void setLatitud(double latitud) {
            this.latitud = latitud;
        }

        public double getLongitud() {
            return longitud;
        }

        public void setLongitud(double longitud) {
            this.longitud = longitud;
        }

        public int getIcon() {
            return this.icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }
    }
}
