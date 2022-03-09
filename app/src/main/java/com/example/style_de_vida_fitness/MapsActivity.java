package com.example.style_de_vida_fitness;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    // private LocationManager locationManager;
    LatLng myPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }





    // Obtain the SupportMapFragment and get notified when the map is ready to be used.




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


      //  locationManager = (LocationManager) getApplication().getSystemService(Context.LOCATION_SERVICE);
      //  Criteria criteria = new Criteria();
        //String provider = locationManager.getBestProvider(criteria, true);
       // Toast.makeText(getApplication(), "Provider" + provider, Toast.LENGTH_LONG).show();

        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions

            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
       mMap.setMyLocationEnabled(true);




          mMap.getUiSettings().setZoomControlsEnabled(true);
     // Getting LocationManager object from System Service LOCATION_SERVICE
     LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

     // Creating a criteria object to retrieve provider
     Criteria criteria = new Criteria();

     // Getting the name of the best provider
     String provider = locationManager.getBestProvider(criteria, true);

     // Getting Current Location
     Location location = locationManager.getLastKnownLocation(provider);

     if (location != null) {
      // Getting latitude of the current location
      double latitude = location.getLatitude();

      // Getting longitude of the current location
      double longitude = location.getLongitude();

      // Creating a LatLng object for the current location
      LatLng latLng = new LatLng(latitude, longitude);

      myPosition = new LatLng(latitude, longitude);
      Toast.makeText(getApplication(), "Provider" + myPosition, Toast.LENGTH_LONG).show();


     Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
             .clickable(true)
             .add(

                     myPosition,
                     new LatLng(-34.364, 147.891),
                     new LatLng(-33.501, 150.217),
                     new LatLng(-32.306, 149.248),
                     new LatLng(-32.491, 147.309)));


     }

       // Add a marker in Sydney and move the camera
        LatLng jacui = new LatLng(-23.485843, -46.454884);
        mMap.addMarker(new MarkerOptions().position(jacui).title("Parque Jacuí"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jacui));


        LatLng eco = new LatLng(-23.495518, -46.520040);
        MarkerOptions marker1 = new MarkerOptions();
        marker1.position(eco);
        marker1.title(("Parque Ecológico"));
        mMap.addMarker(marker1);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(eco));

        LatLng linear = new LatLng(-23.496454, -46.479280);
        MarkerOptions marker2 = new MarkerOptions();
        marker2.position(linear);
        marker2.title(("Parque Linear Mongaguá Francisco Menegolo"));
        mMap.addMarker(marker2);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(linear));

        LatLng verde = new LatLng(-23.543000, -46.460321);
        MarkerOptions marker3 = new MarkerOptions();
        marker3.position(verde);
        marker3.title(("Parque Linear do Córrego do Rio Verde"));
        mMap.addMarker(marker3);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(verde));

        LatLng ermelino = new LatLng(-23.486662, -46.470622);
        MarkerOptions marker4 = new MarkerOptions();
        marker4.position(ermelino);
        marker4.title(("Parque Ermelino Matarazzo"));
        mMap.addMarker(marker4);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ermelino));

        LatLng itaim  = new LatLng(-23.487992, -46.406296);
        mMap.addMarker(new MarkerOptions().position(itaim).title("Núcleo Itaim Biacica"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(itaim));

        LatLng maia = new LatLng(-23.456933, -46.530364);
        MarkerOptions marker6 = new MarkerOptions();
        marker6.position(maia);
        marker6.title(("Parque Bosque Maia"));
        mMap.addMarker(marker6);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(maia));

        LatLng chico = new LatLng(-23.506808, -46.429176);
        MarkerOptions marker7 = new MarkerOptions();
        marker7.position(chico);
        marker7.title(("Parque Ecológico Chico Mendes"));
        mMap.addMarker(marker7);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chico));

        LatLng juventude = new LatLng(-23.507409, -46.620467);
        MarkerOptions marker8 = new MarkerOptions();
        marker8.position(juventude);
        marker8.title(("Parque da Juventude"));
        mMap.addMarker(marker8);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(juventude));

        LatLng dom = new LatLng(-23.546047, -46.627648);
        MarkerOptions marker9 = new MarkerOptions();
        marker9.position(dom);
        marker9.title(("Parque Dom Pedro II"));
        mMap.addMarker(marker9);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dom));

        LatLng carmo = new LatLng(-23.575434, -46.467726);
        MarkerOptions marker10 = new MarkerOptions();
        marker10.position(carmo);
        marker10.title(("Parque do Carmo – Olavo Egydio Setúbal"));
        mMap.addMarker(marker10);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(carmo));

        LatLng helena = new LatLng(-23.479103, -46.415753);
        MarkerOptions marker11 = new MarkerOptions();
        marker11.position(helena);
        marker11.title(("Núcleo Jardim Helena"));
        mMap.addMarker(marker11);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(helena));

        LatLng praca = new LatLng(-23.498986, -46.452133);
        MarkerOptions marker12 = new MarkerOptions();
        marker12.position(praca);
        marker12.title(("Praça Fortunato da Silveira"));
        mMap.addMarker(marker12);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(praca));

        LatLng ciclovia = new LatLng(-23.505411, -46.542522);
        MarkerOptions marker13 = new MarkerOptions();
        marker13.position(ciclovia);
        marker13.title(("Ciclovia Parque Ecológico do Tietê"));
        mMap.addMarker(marker13);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ciclovia));

        LatLng ibira = new LatLng(-23.588478, -46.657017);
        MarkerOptions marker14 = new MarkerOptions();
        marker14.position(ibira);
        marker14.title(("Parque Ibirapuera"));
        mMap.addMarker(marker14);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ibira));

        LatLng lobos = new LatLng(-23.544224, -46.726073);
        MarkerOptions marker15 = new MarkerOptions();
        marker15.position(lobos);
        marker15.title(("Parque Villa-Lobos"));
        mMap.addMarker(marker15);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lobos));

        LatLng sabesp = new LatLng(-23.506061, -46.516670);
        MarkerOptions marker16 = new MarkerOptions();
        marker16.position(sabesp);
        marker16.title(("Parque Sabesp Cangaíba"));
        mMap.addMarker(marker16);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sabesp));

        LatLng guanambi = new LatLng(-23.497391, -46.464713);
        MarkerOptions marker17 = new MarkerOptions();
        marker17.position(guanambi);
        marker17.title(("Praça Guanambi"));
        mMap.addMarker(marker17);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(guanambi));

        LatLng praca1 = new LatLng(-23.501715, -46.422300);
        MarkerOptions marker18 = new MarkerOptions();
        marker18.position(praca1);
        marker18.title(("Praça Do Shinquichi"));
        mMap.addMarker(marker18);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(praca1));

        LatLng pinheiros = new LatLng(-23.566510, -46.703121);
        MarkerOptions marker19 = new MarkerOptions();
        marker19.position(pinheiros);
        marker19.title(("Ciclovia da marginal pinheiros"));
        mMap.addMarker(marker19);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pinheiros));

        LatLng povo = new LatLng(-23.588260, -46.688643);
        MarkerOptions marker20 = new MarkerOptions();
        marker20.position(povo);
        marker20.title(("Parque do Povo - Mário Pimenta Camargo"));
        mMap.addMarker(marker20);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(povo));

        LatLng paulista = new LatLng(-23.563139, -46.654565);
        MarkerOptions marker21 = new MarkerOptions();
        marker21.position(paulista);
        marker21.title(("Ciclovia AV. Paulista"));
        mMap.addMarker(marker21);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(paulista));





















       /* Outro jeito de add title ao marcador do maps
       mMap.addMarker(new MarkerOptions().position(sydney).title("Parque Jacuí"));
       mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
    }


}