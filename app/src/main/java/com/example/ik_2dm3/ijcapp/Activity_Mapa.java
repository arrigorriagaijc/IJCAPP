package com.example.ik_2dm3.ijcapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.LayerDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.maps.android.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class Activity_Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private final static int MY_PERMISSION_FINE_LOCATION = 101;
    private static final String TAG = Activity_Mapa.class.getSimpleName();
    private static final String TAG1 = "ERROR";
    private FusedLocationProviderClient mFusedLocationClient;
    private double latitude;
    private double longitude;

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

        //Lo primero que ejecuto son los permisos.
        EstablecerPermisos();

        //Añadimos los marcadores que se soliciten:
        //Arrigorriaga:
        LatLng AyuntamientoArrigorriaga = new LatLng(43.205889, -2.887724);
        mMap.addMarker(new MarkerOptions().position(AyuntamientoArrigorriaga).title("Ayuntamiento de Arrigorriaga").icon(BitmapDescriptorFactory.fromResource(R.drawable.pregunta)));


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
        //Este código es para añadir la capa que muestra hasta donde llega Arrigorriaga:
        try {
            KmlLayer layer = new KmlLayer(mMap, R.raw.arrigorriagamunicipio, getApplicationContext());
            layer.addLayerToMap();
        } catch (XmlPullParserException | IOException e) {
            Log.e(TAG, " Error: ", e);
        }

        //Ponemos un código para que si hacemos click en el boton my location nos deje en el mismo zoom que con el fusedlocation(sino nos
        //deja mas arriba):
        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                ObtenerLocalizacion();
                return false;
            }
        });


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
                    finish();
                }
                break;
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

    //
    
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
                                LatLng UbicacionActual = new LatLng(latitude, longitude);
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionActual, 16f));
                            } else {
                                Log.d(TAG, "No recoge nada");
                            }
                        }
                    });
        }
    }

}
