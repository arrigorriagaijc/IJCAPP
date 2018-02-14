package com.example.ik_2dm3.ijcapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ik_2dm3 on 11/02/2018.
 */

public class Utilidades {
    private static ListaMarcadores LMarcadores;
    private static ConexionSQLiteHelper conn;
    public static ConexionSQLiteHelper getConn(){
        return conn;
    }
    public static void setConn (ConexionSQLiteHelper pConn){
        conn = pConn;

    }

    public static ListaMarcadores getLMarcadores(){
        return LMarcadores;
    }
    public int getVersionBD(){
        return LMarcadores.getVersion();
    }

    public static void EmpezarLMarcadores() {
        LMarcadores=new ListaMarcadores();
        ListaMarcadores temp = new ListaMarcadores();
        String[] campos= {"title","latitud","longitud","icon"};
        Cursor miCursor = conn.getReadableDatabase().query("marcadores",campos, null,null,null,null,null);
        miCursor.moveToFirst();
        do{
            temp.getListaMarcadores().add(
                    new ListaMarcadores.Marcador(
                    miCursor.getString(0),
                    miCursor.getDouble(1),
                    miCursor.getDouble(2),
                    miCursor.getInt(3)));


        }while(miCursor.moveToNext());
        Cursor miCursor2;

        miCursor2 = conn.getReadableDatabase().rawQuery("SELECT MAX ('id') FROM versiones",null);
        miCursor2.moveToFirst();
        LMarcadores.setVersion( miCursor2.getInt(0));

        LMarcadores = temp;
        miCursor.close();
        conn.close();
    }
    public static void  actualizarMarcadores(ListaMarcadores temporal){
        LMarcadores = temporal;
        SQLiteDatabase db = conn.getWritableDatabase();
        for (int i =0; i< LMarcadores.getListaMarcadores().size(); i++){
            db.execSQL("INSERT OR REPLACE INTO marcadores VALUES ('"+
                    LMarcadores.getListaMarcadores().get(i).getTitle()+"', '"+
                    LMarcadores.getListaMarcadores().get(i).getLatitud()+"','"+
                    LMarcadores.getListaMarcadores().get(i).getLongitud()+"','"+
                    LMarcadores.getListaMarcadores().get(i).getIcon()+"')"
            );
        }
        db.execSQL("INSERT INTO versiones VALUES ('"+temporal.getVersion()+ "', '"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ "')");
        db.close();
        conn.close();
    }


}
