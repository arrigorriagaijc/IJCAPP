package com.example.ik_2dm3.ijcapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ik_2dm3 on 11/02/2018.
 */

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    final String crear_tabla_marcadores ="CREATE TABLE marcadores (title TEXT PRIMARY KEY, latitud DOUBLE, longitud DOUBLE, icon INTEGER)";
    final String crear_tabla_versiones ="CREATE TABLE  versiones (id  INTEGER , fecha TEXT)";
    final String insertarMarcador1 ="INSERT INTO marcadores  VALUES ('Arrigorriagako plaza', '43.206097', '-2.888043', '22')";
    final String insertarMarcador2 ="INSERT INTO marcadores  VALUES ('Arrigorriagako Udaletxea', '43.205918', '-2.887718', '22')";
    final String insertarMarcador3 ="INSERT INTO marcadores  VALUES ('Santa Maria Magdalena eliza', '43.2056', '-2.88866', '22')";
    final String insertarMarcador4 ="INSERT INTO marcadores  VALUES ('Lonbo Aretoa', '43.211879', '-2.888431', '22')";
    final String insertarMarcador5 ="INSERT INTO marcadores  VALUES ('Arrigorriagako Etxetzarrak', '43.209679', '-2.888369', '22')";
    final String insertarMarcador6 ="INSERT INTO marcadores  VALUES ('Baruako Jauregia (Kultur Etxea)', '43.209462', '-2.888372', '22')";
    final String insertarVersiones ="INSERT INTO versiones  VALUES('1' ,'BD version vanilla')";
    public  ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(crear_tabla_marcadores);
            db.execSQL(crear_tabla_versiones);
            db.execSQL(insertarMarcador1);
            db.execSQL(insertarMarcador2);
            db.execSQL(insertarMarcador3);
            db.execSQL(insertarMarcador4);
            db.execSQL(insertarMarcador5);
            db.execSQL(insertarMarcador6);
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
