package com.example.ik_2dm3.ijcapp;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ik_2dm3 on 14/12/2017.
 */

public class JsonResquest extends AsyncTask<Void, Void, Void> {
    private String url = "http://10.9.53.168:80/ProjectsFile/listas.json";
    String result ="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL urla = new URL(url);
            HttpURLConnection httpUrlC = (HttpURLConnection) urla.openConnection();
            InputStream inps = httpUrlC.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inps));
            String line ="";
            while (line != null){
                line = bufferedReader.readLine();
                result = result+line;
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }

  public String getResult(){
        return result;
  }


}
