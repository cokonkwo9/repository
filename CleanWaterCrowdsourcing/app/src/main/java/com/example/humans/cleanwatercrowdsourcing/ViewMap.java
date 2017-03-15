package com.example.humans.cleanwatercrowdsourcing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by omegahaileyesus on 3/14/17.
 */

public class ViewMap extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_map);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment2);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        mGoogleMap = googleMap;
        ArrayList<LatLng> waterSources = new ArrayList<>();

        for (int i = 0; i < CreateReport.waterReports.size(); i++){
            //waterSources.add(new LatLng(33,-84));//]);

            String rep  = "Report ID: " + CreateReport.waterReports.get(i)[0] + "\n"
                    + "Reporter: " + CreateReport.waterReports.get(i)[1] + "\n"
                    + "Time: " + CreateReport.waterReports.get(i)[2] + "\n"
                    + "Location: " +  CreateReport.waterReports.get(i)[3] + "\n"
                    + "Water Type: " +  CreateReport.waterReports.get(i)[4] + "\n"
                    + "Water Condition: " +  CreateReport.waterReports.get(i)[5] + "\n \n";

            List<String> coords = Arrays.asList(CreateReport.waterReports.get(i)[3].toString().split(", "));
            int xcoord = Integer.parseInt(coords.get(0));


            int ycoord = Integer.parseInt(coords.get(1));


            waterSources.add(new LatLng(xcoord,ycoord));
            mGoogleMap.addMarker(new MarkerOptions().title(rep).position(new LatLng(xcoord,ycoord)));

        }


//        for (int i = 0; i < waterSources.size(); i++) {
//            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(waterSources.get(i), 15));
//        }



    }
}
