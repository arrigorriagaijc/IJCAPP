package com.example.ik_2dm3.ijcapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ik_2dm3 on 11/02/2018.
 */

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    final String crear_tabla_marcadores ="CREATE TABLE marcadores (title TEXT PRIMARY KEY, latitud DOUBLE, longitud DOUBLE, icon INTEGER)";
    final String crear_tabla_versiones ="CREATE TABLE  versiones (id  INTEGER PRIMARY KEY, fecha TEXT)";
    final String insertarMarcadores ="INSERT INTO marcadores  VALUES ('casa la que sea', '11.44','11.66', '22')";
    final String insertarVersiones ="INSERT INTO versiones  VALUES('1' ,'BD version vanilla')";

    public  ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(crear_tabla_marcadores);
            db.execSQL(crear_tabla_versiones);
            db.execSQL(insertarMarcadores);
            db.execSQL(insertarVersiones);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int pVersionAntigua, int pVersionNueva) {
        // solo hay que limpiar este metodo si queremos conservar los valores anteriores a la ejecucion

        db.execSQL("DROP TABLE IF EXISTS marcadores");
        db.execSQL("DROP TABLE IF EXISTS versiones");
        onCreate(db);
    }
}
