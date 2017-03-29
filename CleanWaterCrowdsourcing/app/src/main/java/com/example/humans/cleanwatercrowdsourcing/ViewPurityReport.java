package com.example.humans.cleanwatercrowdsourcing;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Created by omegahaileyesus on 3/28/17.
 */

public class ViewPurityReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_purity_report);

        SharedPreferences loadReports = getSharedPreferences("MySavedPurityReports", MODE_PRIVATE);
        //loadReports.edit().clear().commit();


        String allreports = loadReports.getString("all reports", "");


        TextView reports = (TextView) findViewById(R.id.TVpreports);
        reports.setMovementMethod(new ScrollingMovementMethod());

        reports.setText(allreports);





    }
}
