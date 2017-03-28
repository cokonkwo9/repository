package com.example.humans.cleanwatercrowdsourcing;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by omegahaileyesus on 3/7/17.
 */

public class ViewReports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_reports);


        SharedPreferences loadReports = getSharedPreferences("MySavedReports", MODE_PRIVATE);
        String allreports = loadReports.getString("Water Reports", "");

        //System.out.println("swag = " + swag);





        TextView reports = (TextView) findViewById(R.id.TVreports);
//        String allreports = "";
//        if (CreateReport.waterReports.size() == 0) {
//            reports.setText("No reports have been submitted yet.");
//        }
//
//
//        for (int i = 0; i < CreateReport.waterReports.size(); i++){
//            allreports = allreports + "\n"
//                    + "Report ID: " + CreateReport.waterReports.get(i)[0] + "\n"
//                    + "Reporter: " + CreateReport.waterReports.get(i)[1] + "\n"
//                    + "Time: " + CreateReport.waterReports.get(i)[2] + "\n"
//                    + "Location: " +  CreateReport.waterReports.get(i)[3] + "\n"
//                    + "Water Type: " +  CreateReport.waterReports.get(i)[4] + "\n"
//                    + "Water Condition: " +  CreateReport.waterReports.get(i)[5] + "\n \n";
//        }


        //reports.setText(allreports);
        reports.setText(allreports);
        //Toast.makeText(SuccessfulLogin.this, "Login Successful",Toast.LENGTH_SHORT).show();
    }
}
