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
    private String graphtype = ViewHistoryGraph.graphtype;
    private String graphyear = ViewHistoryGraph.graphyear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_graph);

        double[] virusdata = new double[12];
        double[] contamdata = new double[12];



        SharedPreferences loadReports = getSharedPreferences("MySavedPurityReports", MODE_PRIVATE);

        int numofReports = loadReports.getInt("number of reports", 0);
        String reportID = loadReports.getString("Report ID: ", "");
        String reporter = loadReports.getString("Reporter: ", "");
        String time = loadReports.getString("Time: ", "");
        String waterLocation = loadReports.getString("Location: ", "");
        String virusPPM = loadReports.getString("Virus PPM: " , "");


        System.out.println("virusPPM = " + virusPPM);

        String contamPPM = loadReports.getString("Contaminant PPM: ", "");


        String[] reportIds = reportID.split(", ");
        String[] reporters = reporter.split(", ");
        String[] times = time.split("; ");
        String[] locations = waterLocation.split("; ");
        String[] virusppms = virusPPM.split(", ");
        String[] contamppms = contamPPM.split(", ");


        int total = 0;
        for (int i = 0; i < reportIds.length; i++){

            if (times[i].contains(graphyear)){
                total++;

                if (times[i].contains("Jan")) {
                    virusdata[0] += Integer.parseInt(virusppms[i]);
                    contamdata[0] += Integer.parseInt(contamppms[i]);
                } else if (times[i].contains("Feb")) {
                    virusdata[1] += Integer.parseInt(virusppms[i]);
                    contamdata[1] += Integer.parseInt(contamppms[i]);
                } else if (times[i].contains("Mar")) {
                    virusdata[2] += Integer.parseInt(virusppms[i]);
                    contamdata[2] += Integer.parseInt(contamppms[i]);
                } else if (times[i].contains("Apr")) {
                    virusdata[3] += Integer.parseInt(virusppms[i]);
                    contamdata[3] += Integer.parseInt(contamppms[i]);
                } else if (times[i].contains("May")) {
                    virusdata[4] += Integer.parseInt(virusppms[i]);
                    contamdata[4] += Integer.parseInt(contamppms[i]);
                } else if (times[i].contains("Jun")) {
                    virusdata[5] += Integer.parseInt(virusppms[i]);
                    contamdata[5] += Integer.parseInt(contamppms[i]);
                } else if (times[i].contains("Jul")) {
                    virusdata[6] += Integer.parseInt(virusppms[i]);
                    contamdata[6] += Integer.parseInt(contamppms[i]);
                } else if (times[i].contains("Aug")) {
                    virusdata[7] += Integer.parseInt(virusppms[i]);
                    contamdata[7] += Integer.parseInt(contamppms[i]);
                } else if (times[i].contains("Sep")) {
                    virusdata[8] += Integer.parseInt(virusppms[i]);
                    contamdata[8] += Integer.parseInt(contamppms[i]);
                } else if (times[i].contains("Oct")) {
                    virusdata[9] += Integer.parseInt(virusppms[i]);
                    contamdata[9] += Integer.parseInt(contamppms[i]);
                } else if (times[i].contains("Nov")) {
                    virusdata[10] += Integer.parseInt(virusppms[i]);
                    contamdata[10] += Integer.parseInt(contamppms[i]);
                } else if (times[i].contains("Dec")) {
                    virusdata[11] += Integer.parseInt(virusppms[i]);
                    contamdata[11] += Integer.parseInt(contamppms[i]);
                }

            }

        }


        for (int i = 0; i < 12; i++) {
            virusdata[i] = virusdata[i]/total;
            System.out.println("virusdata = " + virusdata[i]);

            contamdata[i] = contamdata[i]/total;
            System.out.println("contamdata = " + contamdata[i]);

        }

        double[] data;

        if (graphtype.equals("Virus")) {
            data = virusdata;
        } else {
            data = contamdata;
        }


        double y,x;

        x = 0.0;

        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();

        for (int i = 0; i < data.length; i++){
            x += 1;
            y = data[i];
            series.appendData(new DataPoint(x,y), true, data.length);
        }

        graph.addSeries(series);







    }

}
