package com.example.ajinkya.stayhealthysg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import static com.example.ajinkya.stayhealthysg.R.id.dengueMapActivity;

/**
 * Created by rach on 25-Mar-17.
 */

public class Malaria extends AppCompatActivity implements OnMapReadyCallback {
    MapFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.malaria);
        TabHost host=(TabHost) findViewById(R.id.malariaTabHost);
        host.setup();

        //Symptoms
        TabHost.TabSpec spec = host.newTabSpec("Symptoms");
        spec.setContent(R.id.malariaSymptoms);
        spec.setIndicator("Symptoms");
        host.addTab(spec);

        //Prevention
        spec = host.newTabSpec("Prevention");
        spec.setContent(R.id.malariaPrevention);
        spec.setIndicator("Prevention");
        host.addTab(spec);

        //Clusters
        spec = host.newTabSpec("Clusters");
        spec.setContent(R.id.malariaClusters);
        spec.setIndicator("Clusters");
        host.addTab(spec);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.malariaMapActivity);
        mapFragment.getMapAsync(this);




    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(1.3521, 103.8198 ), 11.0f));

    }
}
