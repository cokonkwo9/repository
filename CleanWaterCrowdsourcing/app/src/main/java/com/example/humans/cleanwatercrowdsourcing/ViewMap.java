package com.example.humans.cleanwatercrowdsourcing;

import android.content.SharedPreferences;
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



        SharedPreferences loadReports = getSharedPreferences("MySavedReports", MODE_PRIVATE);

        int numofReports = loadReports.getInt("number of reports", 0);

        String reportID = loadReports.getString("Report ID: ", "");
        String reporter = loadReports.getString("Reporter: ", "");
        String time = loadReports.getString("Time: ", "");
        String waterLocation = loadReports.getString("Location: ", "");
        String waterType = loadReports.getString("Water Type: " , "");
        String waterCondition = loadReports.getString("Water Condition: ", "");

        //break up waterLocation, waterType and waterCondition
        String[] locations = waterLocation.split("; ");
        String[] watertypes = waterType.split(", ");
        String[] waterconditions = waterCondition.split(", ");


        for (int i = 0; i < numofReports; i++){

            String rep  = //"Report ID: " + CreateReport.waterReports.get(i)[0] + ", "
                    //+ "Reporter: " + CreateReport.waterReports.get(i)[1] + ", "
                    //+ "Time: " + CreateReport.waterReports.get(i)[2] + ", "
                    //+ "Location: " +  CreateReport.waterReports.get(i)[3] + ", " +
                    "Water Type: " +  watertypes[i] + ", "
                    + "Water Condition: " +  waterconditions[i];






            List<String> coords = Arrays.asList(locations[i].toString().split(", "));
            int xcoord = Integer.parseInt(coords.get(0));
            int ycoord = Integer.parseInt(coords.get(1));


            waterSources.add(new LatLng(xcoord,ycoord));
            mGoogleMap.addMarker(new MarkerOptions().title(rep).position(new LatLng(xcoord,ycoord)));

        }

















//        for (int i = 0; i < CreateReport.waterReports.size(); i++){
//
//            String rep  = //"Report ID: " + CreateReport.waterReports.get(i)[0] + ", "
//                    //+ "Reporter: " + CreateReport.waterReports.get(i)[1] + ", "
//                    //+ "Time: " + CreateReport.waterReports.get(i)[2] + ", "
//                    //+ "Location: " +  CreateReport.waterReports.get(i)[3] + ", " +
//                    "Water Type: " +  CreateReport.waterReports.get(i)[4] + ", "
//                    + "Water Condition: " +  CreateReport.waterReports.get(i)[5];
//
//            List<String> coords = Arrays.asList(CreateReport.waterReports.get(i)[3].toString().split(", "));
//            int xcoord = Integer.parseInt(coords.get(0));
//
//
//            int ycoord = Integer.parseInt(coords.get(1));
//
//
//            waterSources.add(new LatLng(xcoord,ycoord));
//            mGoogleMap.addMarker(new MarkerOptions().title(rep).position(new LatLng(xcoord,ycoord)));
//
//        }

        //mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(waterSources.get(waterSources.size() - 1), 6));
//        for (int i = 0; i < waterSources.size(); i++) {
//            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(waterSources.get(i), 15));
//        }



    }
}
