package com.example.ferro.listsine.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.ferro.listsine.R;
import com.example.ferro.listsine.asyncTask.ListAsy;
import com.example.ferro.listsine.asyncTask.ListAsyDet;
import com.example.ferro.listsine.entity.Sine;
import com.example.ferro.listsine.entity.SineDet;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        try {
            mMap = googleMap;
            double latitude, longitude;
            LatLng CampinaG = new LatLng(-7.2250861, -35.8811222);
            ListAsyDet listSine = new ListAsyDet();
            List<SineDet> sines =  listSine.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/latitude/-7.242662/longitude/-35.9716057/raio/100").get();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CampinaG, 7));
            for(int i = 0; i < sines.size(); i ++){
                latitude = Double.parseDouble(sines.get(i).getLat());
                longitude = Double.parseDouble(sines.get(i).getLon());
                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(latitude, longitude))
                        .title(sines.get(i).getNome())); // Exibe o nome do posto como titulo do marcador

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }
}
