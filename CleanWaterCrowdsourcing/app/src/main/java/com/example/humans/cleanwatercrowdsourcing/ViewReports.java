package com.example.humans.cleanwatercrowdsourcing;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
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
        //loadReports.edit().clear().commit();


        String allreports = loadReports.getString("all reports", "");

        int numofReports = loadReports.getInt("number of reports", 0);

        String reportID = loadReports.getString("Report ID: ", "");
        String reporter = loadReports.getString("Reporter: ", "");
        String time = loadReports.getString("Time: ", "");
        String waterLocation = loadReports.getString("Location: ", "");
        String waterType = loadReports.getString("Water Type: " , "");
        String waterCondition = loadReports.getString("Water Condition: ", "");





        TextView reports = (TextView) findViewById(R.id.TVreports);
        reports.setMovementMethod(new ScrollingMovementMethod());

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
