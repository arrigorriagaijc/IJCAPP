package com.example.ik_2dm3.ijcapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.maps.android.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class Activity_Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private final static int MY_PERMISSION_FINE_LOCATION = 101;
    private final static int REQUEST_CHECK_SETTINGS=102;
    private static final String TAG = "TAG";
    private static final String TAG1 = "ERROR";
    private FusedLocationProviderClient mFusedLocationClient;
    private double latitude;
    private double longitude;
    private LatLng UbicacionActual;
    private boolean activado1=false;
    private boolean activado2=false;
    private boolean activado3=false;
    private boolean activado4=false;
    private boolean activado5=false;
    private boolean activado6=false;
    private Handler handler=new Handler();
    private  Listeners_distancias_marcadores ldm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Si queremos cambiar el icono al buscador de ubicacion:
        //ImageView boton=(ImageView) mapFragment.getView().findViewById(2);
        //boton.setImageIcon(R.drawable.pregunta);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        //Lo primero pido que activen el Gps
        ActivarGps();
        //Lo segundo pido los permisos.
        EstablecerPermisos();

        //Codigo para instanciar el navegador de google maps, en desuso

        /*Uri gmmIntentUri = Uri.parse("google.navigation:q=43.256998, -2.903901&mode=w");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }*/


        /*String url = obtenerDireccionesURL(UbicacionActual, AyuntamientoArrigorriaga);
        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute(url);*/

        //Añadimos los marcadores que se soliciten:
        //Arrigorriagako Plaza
        LatLng PlazaArrigorriaga = new LatLng(Utilidades.getLMarcadores().getListaMarcadores().get(0).getLatitud(), Utilidades.getLMarcadores().getListaMarcadores().get(0).getLongitud());
        final Marker PlArrigo= mMap.addMarker(new  MarkerOptions().position(PlazaArrigorriaga).title(Utilidades.getLMarcadores().getListaMarcadores().get(0).getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.pregunta)));
        PlArrigo.setVisible(false);

        //Arrigorriagako Udaletxea:
        LatLng AyuntamientoArrigorriaga = new LatLng(Utilidades.getLMarcadores().getListaMarcadores().get(1).getLatitud(), Utilidades.getLMarcadores().getListaMarcadores().get(1).getLongitud());
        final Marker AyArrigo= mMap.addMarker(new  MarkerOptions().position(AyuntamientoArrigorriaga).title(Utilidades.getLMarcadores().getListaMarcadores().get(1).getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.pregunta)));
        AyArrigo.setVisible(false);

        //Santa Maria Magdalena eliza
        LatLng SantaMariaMagdalenaEliza = new LatLng(Utilidades.getLMarcadores().getListaMarcadores().get(2).getLatitud(), Utilidades.getLMarcadores().getListaMarcadores().get(2).getLongitud());
        final Marker MariaEliza=mMap.addMarker(new MarkerOptions().position(SantaMariaMagdalenaEliza).title(Utilidades.getLMarcadores().getListaMarcadores().get(2).getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.pregunta)));
        MariaEliza.setVisible(false);

        //Lonbo Aretoa poner coordenadas
        LatLng LonboAretoa = new LatLng(Utilidades.getLMarcadores().getListaMarcadores().get(3).getLatitud(), Utilidades.getLMarcadores().getListaMarcadores().get(3).getLongitud());
        final Marker LonAretoa=mMap.addMarker(new MarkerOptions().position(LonboAretoa).title(Utilidades.getLMarcadores().getListaMarcadores().get(3).getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.pregunta)));
        LonAretoa.setVisible(false);

        //Arrigorriagako Etxetzarrak
        LatLng ArrigorriagakoEtxetzarrak = new LatLng(Utilidades.getLMarcadores().getListaMarcadores().get(4).getLatitud(), Utilidades.getLMarcadores().getListaMarcadores().get(4).getLongitud());
        final Marker ArrigoEtxe=mMap.addMarker(new MarkerOptions().position(ArrigorriagakoEtxetzarrak).title(Utilidades.getLMarcadores().getListaMarcadores().get(4).getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.pregunta)));
        ArrigoEtxe.setVisible(false);

        //Baruako Jauregia(Kultur Extea)
        LatLng KulturEtxea = new LatLng(Utilidades.getLMarcadores().getListaMarcadores().get(5).getLatitud(), Utilidades.getLMarcadores().getListaMarcadores().get(5).getLongitud());
        final Marker KulturEtxe=mMap.addMarker(new MarkerOptions().position(KulturEtxea).title(Utilidades.getLMarcadores().getListaMarcadores().get(5).getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.pregunta)));
        KulturEtxe.setVisible(false);

        //Creamos un intent en el que recogeremos el intent del que vengamos ya que
        //Siempre que llegamos al mapa llegamos desde una pista
        final Intent intent = getIntent();

        /*
        if(ldm==null){
        ldm=new Listeners_distancias_marcadores(this);
        ldm.start();
        }else{
            ldm.setSalir(false);
        }*/


        if(intent.getStringExtra("Pista1")!=null && intent.getStringExtra("Pista1").equals("Pista1")) {
            ldm = new Listeners_distancias_marcadores(this, 1);
            ldm.start();
        }else if(intent.getStringExtra("Pista2")!=null && intent.getStringExtra("Pista2").equals("Pista2")) {
            ldm = new Listeners_distancias_marcadores(this, 2);
            ldm.start();
        }else if(intent.getStringExtra("Pista3")!=null && intent.getStringExtra("Pista3").equals("Pista3")) {
            ldm = new Listeners_distancias_marcadores(this, 3);
            ldm.start();
        }else if(intent.getStringExtra("Pista4")!=null && intent.getStringExtra("Pista4").equals("Pista4")) {
            ldm = new Listeners_distancias_marcadores(this, 4);
            ldm.start();
        }else if(intent.getStringExtra("Pista5")!=null && intent.getStringExtra("Pista5").equals("Pista5")) {
            ldm = new Listeners_distancias_marcadores(this, 5);
            ldm.start();
        }else if(intent.getStringExtra("Pista6")!=null && intent.getStringExtra("Pista6").equals("Pista6")) {
            ldm = new Listeners_distancias_marcadores(this, 6);
            ldm.start();
        }


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getTitle().equals(Utilidades.getLMarcadores().getListaMarcadores().get(0).getTitle()) && activado1) {
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.plazaarrigorriagaredondo));
                    Intent intent = new Intent(getApplicationContext(), Activity_Pantalla1.class);
                    startActivity(intent);
                }
                if (marker.getTitle().equals(Utilidades.getLMarcadores().getListaMarcadores().get(1).getTitle()) && activado2) {
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ayunatmientoarrigorriagaredondo));
                    Intent intent = new Intent(getApplicationContext(), Activity_Pantalla2.class);
                    startActivity(intent);
                }
                if (marker.getTitle().equals(Utilidades.getLMarcadores().getListaMarcadores().get(2).getTitle()) && activado3) {
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.santamariamagdalenaredondo));
                    Intent intent = new Intent(getApplicationContext(), Activity_Pantalla3.class);
                    startActivity(intent);
                }
                if (marker.getTitle().equals(Utilidades.getLMarcadores().getListaMarcadores().get(3).getTitle()) && activado4) {
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.lonboaretoaredondo));
                    Intent intent = new Intent(getApplicationContext(), Activity_Pantalla4.class);
                    startActivity(intent);
                }
                if (marker.getTitle().equals(Utilidades.getLMarcadores().getListaMarcadores().get(4).getTitle()) && activado5) {
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.arrigorriagakoetxetzarrrakredondo));
                    Intent intent = new Intent(getApplicationContext(), Activity_Pantalla5.class);
                    startActivity(intent);
                }
                if (marker.getTitle().equals(Utilidades.getLMarcadores().getListaMarcadores().get(5).getTitle()) && activado6) {
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.baruakojauregiaredondo));
                    Intent intent = new Intent(getApplicationContext(), Activity_Pantalla6.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        /* Este es el codigo de activar el marcador si estamos a la distancia correcta
        //Si vengo de la pista 1...
        if(intent.getStringExtra("Pista1")!=null && intent.getStringExtra("Pista1").equals("Pista1")) {
            ldm=new Listeners_distancias_marcadores(mMap,this,43.206097,-2.888043);
            ldm.start();
        }
        else if(intent.getStringExtra("Pista2")!=null && intent.getStringExtra("Pista2").equals("Pista2")) {
            ldm=new Listeners_distancias_marcadores(mMap,this,43.205918,-2.887718);
            ldm.start();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(ldm.isActivar()==true){
                        ldm.setSalir(true);
                        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                if (marker.getTitle().equals("Arrigorriagako Udaletxea")) {
                                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ayunatmientoarrigorriagaredondo));
                                    Intent intent = new Intent(getApplicationContext(), Activity_Pantalla2.class);
                                    startActivity(intent);
                                }
                                return false;
                            }
                        });
                    }
                }
            },500);

        }
        else if(intent.getStringExtra("Pista3")!=null && intent.getStringExtra("Pista3").equals("Pista3")) {
            ldm=new Listeners_distancias_marcadores(mMap,this,43.2056,-2.88866);
            ldm.start();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(ldm.isActivar()==true){
                        ldm.setSalir(true);
                        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                if (marker.getTitle().equals("Santa Maria Magdalena eliza")) {
                                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.santamariamagdalenaredondo));
                                    Intent intent = new Intent(getApplicationContext(), Activity_Pantalla3.class);
                                    startActivity(intent);
                                }
                                return false;
                            }
                        });
                    }
                }
            },500);

        }
        else if(intent.getStringExtra("Pista4")!=null && intent.getStringExtra("Pista4").equals("Pista4")) {
            ldm=new Listeners_distancias_marcadores(mMap,this,43.211879,-2.888431);
            ldm.start();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(ldm.isActivar()==true){
                        ldm.setSalir(true);
                        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                if (marker.getTitle().equals("Lonbo Aretoa")) {
                                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.lonboaretoaredondo));
                                    Intent intent = new Intent(getApplicationContext(), Activity_Pantalla4.class);
                                    startActivity(intent);
                                }
                                return false;
                            }
                        });
                    }
                }
            },500);
        }
        else if(intent.getStringExtra("Pista5")!=null && intent.getStringExtra("Pista5").equals("Pista5")) {
            ldm=new Listeners_distancias_marcadores(mMap,this,43.209679,-2.888369);
            ldm.start();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(ldm.isActivar()==true){
                        ldm.setSalir(true);
                        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                if (marker.getTitle().equals("Arrigorriagako Etxetzarrak")) {
                                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.arrigorriagakoetxetzarrrakredondo));
                                    Intent intent = new Intent(getApplicationContext(), Activity_Pantalla5.class);
                                    startActivity(intent);
                                }
                                return false;
                            }
                        });
                    }
                }
            },500);
        }
        else if(intent.getStringExtra("Pista6")!=null && intent.getStringExtra("Pista6").equals("Pista6")) {
            ldm=new Listeners_distancias_marcadores(mMap,this,43.209462,-2.888372);
            ldm.start();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(ldm.isActivar()==true){
                        ldm.setSalir(true);
                        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                if (marker.getTitle().equals("Baruako Jauregia (Kultur Etxea)")) {
                                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.baruakojauregiaredondo));
                                    Intent intent = new Intent(getApplicationContext(), Activity_Pantalla6.class);
                                    startActivity(intent);
                                }
                                return false;
                            }
                        });
                    }
                }
            },500);
        }
        //Solo añadiremos los listener en los marcadores que correspondan, por ejemplo,
        //si venimos de pista3 activariamos el marcador de activity_pantalla3, que
        //seria el marcador 3.
        //El resto no tendrán el listener ya que este codigo se cativa cada vez que se llama a
        //Activity_Mapa
        */

        /*
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(intent.getStringExtra("Pista1")!=null && intent.getStringExtra("Pista1").equals("Pista1") && marker.getTitle().equals(Utilidades.getLMarcadores().getListaMarcadores().get(0).getTitle())) {
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.plazaarrigorriagaredondo));
                    Intent intent=new Intent(getApplicationContext(), Activity_Pantalla1.class);
                    startActivity(intent);
                }
                else if(intent.getStringExtra("Pista2")!=null && intent.getStringExtra("Pista2").equals("Pista2") && marker.getTitle().equals(Utilidades.getLMarcadores().getListaMarcadores().get(1).getTitle())) {
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ayunatmientoarrigorriagaredondo));
                    Intent intent=new Intent(getApplicationContext(), Activity_Pantalla2.class);
                    startActivity(intent);
                }
                else if(intent.getStringExtra("Pista3")!=null && intent.getStringExtra("Pista3").equals("Pista3") && marker.getTitle().equals(Utilidades.getLMarcadores().getListaMarcadores().get(2).getTitle())) {
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.santamariamagdalenaredondo));
                    Intent intent=new Intent(getApplicationContext(), Activity_Pantalla3.class);
                    startActivity(intent);
                }
                else if(intent.getStringExtra("Pista4")!=null && intent.getStringExtra("Pista4").equals("Pista4") && marker.getTitle().equals(Utilidades.getLMarcadores().getListaMarcadores().get(3).getTitle())) {
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.lonboaretoaredondo));
                    Intent intent=new Intent(getApplicationContext(), Activity_Pantalla4.class);
                    startActivity(intent);
                }
                else if(intent.getStringExtra("Pista5")!=null && intent.getStringExtra("Pista5").equals("Pista5") && marker.getTitle().equals(Utilidades.getLMarcadores().getListaMarcadores().get(4).getTitle())) {
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.arrigorriagakoetxetzarrrakredondo));
                    Intent intent=new Intent(getApplicationContext(), Activity_Pantalla5.class);
                    startActivity(intent);
                }
                else if(intent.getStringExtra("Pista6")!=null && intent.getStringExtra("Pista6").equals("Pista6") && marker.getTitle().equals(Utilidades.getLMarcadores().getListaMarcadores().get(5).getTitle())) {
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.baruakojauregiaredondo));
                    Intent intent=new Intent(getApplicationContext(), Activity_Pantalla6.class);
                    startActivity(intent);
                }
                return false;

            }
        });
*/
        //Este código es para meter el json al mapa:
       /*
       try {
           // Customise the styling of the base map using a JSON object defined
           // in a raw resource file.
           boolean success = googleMap.setMapStyle(
                   MapStyleOptions.loadRawResourceStyle(
                           this, R.raw.style_json));

           if (!success) {
               Log.e(TAG, "Style parsing failed.");
           }

       } catch (Resources.NotFoundException e) {
           Log.e(TAG, "Can't find style. Error: ", e);
       }
       */

        //Ponemos un código para que si hacemos click en el boton my location nos deje en el mismo zoom que con el fusedlocation(sino nos
        //deja mas arriba):
        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                ObtenerLocalizacion();
                return false;
            }
        });

        //Aqui los marcadores que ya deben estar resueltos se les cambiará el icono de la
        //pregunta por su icono propio.
        //Se haran visibles éstos últimos y el que vamos a ejecutar.
        handler.post(new Runnable() {
                         @Override
                         public void run() {
                             if (intent.getStringExtra("Pista1")!=null && intent.getStringExtra("Pista1").equals("Pista1")) {
                                 PlArrigo.setVisible(true);
                             }
                             else if (intent.getStringExtra("Pista2")!=null && intent.getStringExtra("Pista2").equals("Pista2")) {
                                 PlArrigo.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.plazaarrigorriagaredondo));
                                 PlArrigo.setVisible(true);
                                 AyArrigo.setVisible(true);
                             }
                             else if (intent.getStringExtra("Pista3")!=null && intent.getStringExtra("Pista3").equals("Pista3")) {
                                 PlArrigo.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.plazaarrigorriagaredondo));
                                 PlArrigo.setVisible(true);
                                 AyArrigo.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ayunatmientoarrigorriagaredondo));
                                 AyArrigo.setVisible(true);
                                 MariaEliza.setVisible(true);
                             }
                             else if (intent.getStringExtra("Pista4")!=null && intent.getStringExtra("Pista4").equals("Pista4")) {
                                 PlArrigo.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.plazaarrigorriagaredondo));
                                 PlArrigo.setVisible(true);
                                 AyArrigo.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ayunatmientoarrigorriagaredondo));
                                 AyArrigo.setVisible(true);
                                 MariaEliza.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.santamariamagdalenaredondo));
                                 MariaEliza.setVisible(true);
                                 LonAretoa.setVisible(true);
                             }
                             else if (intent.getStringExtra("Pista5")!=null && intent.getStringExtra("Pista5").equals("Pista5")) {
                                 PlArrigo.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.plazaarrigorriagaredondo));
                                 PlArrigo.setVisible(true);
                                 AyArrigo.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ayunatmientoarrigorriagaredondo));
                                 AyArrigo.setVisible(true);
                                 MariaEliza.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.santamariamagdalenaredondo));
                                 MariaEliza.setVisible(true);
                                 LonAretoa.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.lonboaretoaredondo));
                                 LonAretoa.setVisible(true);
                                 ArrigoEtxe.setVisible(true);
                             }
                             else if (intent.getStringExtra("Pista6")!=null && intent.getStringExtra("Pista6").equals("Pista6")) {
                                 PlArrigo.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.plazaarrigorriagaredondo));
                                 PlArrigo.setVisible(true);
                                 AyArrigo.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ayunatmientoarrigorriagaredondo));
                                 AyArrigo.setVisible(true);
                                 MariaEliza.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.santamariamagdalenaredondo));
                                 MariaEliza.setVisible(true);
                                 LonAretoa.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.lonboaretoaredondo));
                                 LonAretoa.setVisible(true);
                                 ArrigoEtxe.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.arrigorriagakoetxetzarrrakredondo));
                                 ArrigoEtxe.setVisible(true);
                                 KulturEtxe.setVisible(true);
                             }

                         }
                     });

        //Este código es para añadir la capa que muestra hasta donde llega Arrigorriaga:
        try {
            KmlLayer layer = new KmlLayer(mMap, R.raw.arrigorriagamunicipio, getApplicationContext());
            layer.addLayerToMap();
        } catch (XmlPullParserException | IOException e) {
            Log.e(TAG, " Error: ", e);
        }


    }

    @Override
    public void onBackPressed (){

    }

    //Creamos una sentencia para activar el GPS si es necesario
    public void ActivarGps(){
        //y le damos unos valores óptimos para las aplicaciones en tiempo real.
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        //Envíamos la sentencia al settingsrequest para que haga lo pertinente:
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest);
        //Comprobamos cuales de las solicitudes estan satisfechas:
        Task<LocationSettingsResponse> result =
                LocationServices.getSettingsClient(this).checkLocationSettings(builder.build());
        //Analizamos el código de estado recibido en la task anterior cuando ésta se completa:
        result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(Task<LocationSettingsResponse> task) {
                try {
                    LocationSettingsResponse response = task.getResult(ApiException.class);
                    // Todos los ajustes están satisfechos. El cliente
                    //puede empezar la consulta de localización aquí:

                } catch (ApiException exception) {
                    switch (exception.getStatusCode()) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            // Los ajustes no están satisfechos. Pero pueden solucionarse mostrando
                            // un cuadro de diálogo
                            try {
                                // Hacemos cast a una excepcion resoluble
                                ResolvableApiException resolvable = (ResolvableApiException) exception;
                                // Mostramos el diálogo llamando a startResolutionForResult(),
                                // y miramos el resultado en onActivityResult(). Que está más abajo
                                resolvable.startResolutionForResult(Activity_Mapa.this,REQUEST_CHECK_SETTINGS);
                            } catch (IntentSender.SendIntentException e) {
                                // Ignorar el error.
                            } catch (ClassCastException e) {
                                // Ignorar, debería ser un error imposible.
                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            //Los ajustes no están satisfechos. De todas formas, no tenemos
                            //manera de solucionarlos por lo que no mostramos el diálogo.
                            break;
                    }
                }
            }
        });
    }

    //Recogemos el resultado del startResolutionForResult anterior y si el usuario no ha aceptadp cerramos la app y le mostramos
    //un toast que dice que "Esta app requiere que se active el GPS"
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final LocationSettingsStates states = LocationSettingsStates.fromIntent(data);
        switch (requestCode) {
            case REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        // All required changes were successfully made
                        Log.d(TAG,"Todos los cambios bien hechos");
                        break;
                    case Activity.RESULT_CANCELED:
                        // The user was asked to change settings, but chose not to
                        Toast.makeText(getApplicationContext(), "Esta app requiere que se active el GPS", Toast.LENGTH_LONG).show();
                        finish();
                        Log.d(TAG,"El usuario ha elegido no hacer los cambios");
                        break;
                    default:
                        break;
                }
                break;
        }
    }

    //Aqui obtengo la ubicación y voy a ella.
    //Con el provider de FusedLocation obtenemos la última ubicación conocida. Hemos tenido que meterle en una comprobación de permisos
    //porque los necesita y sino puede dar un error.
    public void ObtenerLocalizacion(){
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Obtiene la última ubicación, en algunos casos es nula (es raro)
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                                UbicacionActual = new LatLng(latitude, longitude);
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionActual, 16f));
                            } else {
                                Log.d(TAG, "No recoge nada");
                            }
                        }
                    });
        }
    }

    //Creo una funcion para obtener coordenadas y usarlas en el hilo
    public void ObtenerCoordenadas(){
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Obtiene la última ubicación, en algunos casos es nula (es raro)
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            } else {
                                Log.d(TAG, "No recoge nada");
                            }
                        }
                    });
        }
    }

    //Aquí le digo a la app que si los permisos están activados active la capa mylocation para que me encuentre la ubicación y me ponga
    //el botón my location. Si no están activados los pedimos pasandole una variable static int creada y el permido requerido, los activa. Esto
    //saltará a la función pública onRequestPermissionsResult:
    public void EstablecerPermisos(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            mMap.setMyLocationEnabled(true);

            //Situo la cámara en mi ubicación actual
            ObtenerLocalizacion();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_FINE_LOCATION);
            }
        }
    }

    //Aquí venimos desde la comprobación de los permisos, el requestcode que le pasamos es el static int de antes, los permisos los que le hemos
    //especificado y grantresult que nos dice si los permisos están activado o no. Si el permiso está activado activa la capa my location y sino muestra
    //un muensaje de que es necesario dar permisos de localización y cierra la app.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSION_FINE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        mMap.setMyLocationEnabled(true);
                        //Situo la cámara en mi ubicación actual
                        ObtenerLocalizacion();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Esta app requiere que se concedan los permisos de localización", Toast.LENGTH_LONG).show();
                    Log.d(TAG,"El usuario NO ha querido dar los permisos");
                    finish();
                }
                break;
        }
    }

    /*@Override
    public void onBackPressed(){

    }*/

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public  boolean isActivado1() {
        return activado1;
    }

    public  void setActivado1(boolean activado1) {
        this.activado1 = activado1;
    }

    public  boolean isActivado2() {
        return activado2;
    }

    public  void setActivado2(boolean activado2) {
        this.activado2 = activado2;
    }

    public  boolean isActivado3() {
        return activado3;
    }

    public  void setActivado3(boolean activado3) {
       this.activado3 = activado3;
    }

    public  boolean isActivado4() {
        return activado4;
    }

    public  void setActivado4(boolean activado4) {
        this.activado4 = activado4;
    }

    public  boolean isActivado5() {
        return activado5;
    }

    public  void setActivado5(boolean activado5) {
        this.activado5 = activado5;
    }

    public  boolean isActivado6() {
        return activado6;
    }

    public  void setActivado6(boolean activado6) {
        this.activado6 = activado6;
    }
    /*private String obtenerDireccionesURL(LatLng origin,LatLng dest){

        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        String str_dest = "destination="+dest.latitude+","+dest.longitude;

        String sensor = "sensor=false";

        String parameters = str_origin+"&"+str_dest+"&"+sensor;

        String output = "json";

        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;

        return url;
    }

    private class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... url) {

            String data = "";

            try{
                data = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("ERROR AL OBTENER WS",e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            parserTask.execute(result);
        }
    }

    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try{
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                routes = parser.parse(jObject);
            }catch(Exception e){
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            for(int i=0;i<result.size();i++){
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                List<HashMap<String, String>> path = result.get(i);

                for(int j=0;j<path.size();j++){
                    HashMap<String,String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                lineOptions.addAll(points);
                lineOptions.width(4);
                lineOptions.color(Color.rgb(0,0,255));
            }
            if(lineOptions!=null) {
                mMap.addPolyline(lineOptions);
            }
        }
    }

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);

            // Creamos una conexion http
            urlConnection = (HttpURLConnection) url.openConnection();

            // Conectamos
            urlConnection.connect();

            // Leemos desde URL
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while( ( line = br.readLine()) != null){
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        }catch(Exception e){
            Log.d("Exception", e.toString());
        }finally{
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
*/

}
