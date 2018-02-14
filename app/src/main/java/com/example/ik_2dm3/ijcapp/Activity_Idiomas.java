package com.example.ik_2dm3.ijcapp;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Locale;

import xdroid.toaster.Toaster;

public class Activity_Idiomas extends AppCompatActivity {

    private Locale myLocale;
    ProgressDialog mProgressDialog;
    String response ="";



    public Activity_Idiomas() throws FileNotFoundException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__idiomas);

        Button btnEuskera=(Button) findViewById(R.id.btnEuskera);
        Button btnCastellano=(Button) findViewById(R.id.btnEspañol);

        btnEuskera.setWidth(btnCastellano.getWidth());

        // el numero de la version es solo una forma de controlar la informacion de la bd en caso de tener que resetear
        Utilidades.setConn( new ConexionSQLiteHelper(this, "BDMarcadores",null,9));
        Utilidades.EmpezarLMarcadores();


        btnCastellano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Activity_Inicio.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        btnEuskera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("fr");
                Intent intent=new Intent(getApplicationContext(), Activity_Inicio.class);
                startActivity(intent);
            }
        });


        Comprobando js = new Comprobando(new JsonResquest());
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }
    @Override
    public void onBackPressed (){

    }

    public void setLocale(String lang) {
        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(myLocale);
        res.updateConfiguration(conf, dm);
    }

    // private Gson gson;

    public Locale getMyLocale() {
        return myLocale;
    }

    ////clases del json

    public class Comprobando extends Thread{
        private JsonResquest json;
        private boolean running = true;
        private int segundos=0;
        private String result;
        public Comprobando(JsonResquest pJson){
            json = pJson;
            json.execute();
            this.start();
        }
        private void controlVersion(String Json){
            int temp = Json.compareToIgnoreCase("");
            switch (temp){
                case 0:
                        response ="No se ha podido Actualizar";
                    break;
                default:
                    Gson gson = new Gson();
                    ListaMarcadores lista = gson.fromJson(Json, ListaMarcadores.class);
                    if(lista.getVersion()> Utilidades.getLMarcadores().getVersion()){
                        Utilidades.actualizarMarcadores(lista);
                    }
                    response = "Actualizado version:"+Utilidades.getLMarcadores().getVersion();
                    break;
            }
        }
        public void run(){
            result = json.getResult();
            while(running){
                segundos++;
                if(segundos <10 && result.compareToIgnoreCase("")==0){
                    result = json.getResult();
                }else{
                    //comprobamos si tenemos json
                    controlVersion(result);
                    running = false;
                }
                try {
                    sleep(1000);
                }catch (Exception e){
                }
                mProgressDialog.dismiss();
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(getApplicationContext())
                                .setSmallIcon(R.mipmap.ijcappico)
                                .setContentTitle("Estado de Actualización")
                                .setShowWhen(!running)
                                .setContentText(response);

                int mNotificationId = 001;
                NotificationManager mNotifyMgr =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if(!running){
                    mNotifyMgr.notify(mNotificationId, mBuilder.build());
                }
            }
        }
    }
    ///////asynctask

    public class JsonResquest extends AsyncTask<Void, Void, Void> {


        private String url = "http://192.168.0.26:80/ProjectsFile/Marcadores.json";
        String result ="";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(Activity_Idiomas.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Buscando actualizaciones");
            // Set progressdialog message
            mProgressDialog.setMessage("conectando...");
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL urla = new URL(url);
                HttpURLConnection httpUrlC = (HttpURLConnection) urla.openConnection();
                InputStream inps = httpUrlC.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inps));
                String line;
                while ((line = bufferedReader.readLine())!=null ){
                    result = result+line;
                }
                bufferedReader.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        public String getResult(){
            return result;
        }

    }




}

