package com.example.humans.cleanwatercrowdsourcing;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by omegahaileyesus on 3/29/17.
 */

public class DisplayGraph extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_graph);

        SharedPreferences loadReports = getSharedPreferences("MySavedPurityReports", MODE_PRIVATE);


        double y,x;

        x = 0.0;

        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();

        for (int i = 0; i < 500; i++){
            x += 0.1;
            y = 2* x;
            series.appendData(new DataPoint(x,y), true, 500);
        }

        graph.addSeries(series);


    }

}
