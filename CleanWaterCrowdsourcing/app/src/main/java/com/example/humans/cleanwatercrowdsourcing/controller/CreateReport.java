package com.example.humans.cleanwatercrowdsourcing.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.humans.cleanwatercrowdsourcing.R;
import com.google.firebase.auth.FirebaseAuth;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by omegahaileyesus on 3/6/17.
 * class for creating water report
 */




public class CreateReport extends AppCompatActivity {


    // --Commented out by Inspection (4/4/17, 7:42 PM):public static ArrayList<Object[]> waterReports = new ArrayList<Object[]>();
    @SuppressLint("StaticFieldLeak")
    private static Spinner waterconditionspinner;
    @SuppressLint("StaticFieldLeak")
    private static Spinner watertypespinner;
    private static final String SAVENAME = "MySavedReports";
    @SuppressLint("StaticFieldLeak")
    private static EditText location;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_report);


        waterconditionspinner = (Spinner) findViewById(R.id.SPwatercondition);
        @SuppressWarnings("Convert2Diamond") ArrayAdapter wcadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Arrays.asList("Waste", "Treatable-Clear", "Treatable-Muddy", "Potable"));
        wcadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        waterconditionspinner.setAdapter(wcadapter);


        watertypespinner = (Spinner) findViewById(R.id.SPwatertype);
        @SuppressWarnings("Convert2Diamond") ArrayAdapter wtadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Arrays.asList("Bottled", "Well", "Stream", "Lake", "Spring", "Other"));
        wtadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        watertypespinner.setAdapter(wtadapter);



        //Toast.makeText(SuccessfulLogin.this, "Login Successful",Toast.LENGTH_SHORT).show();
    }

    /**
     * method for creating water report
     * @param v - current view
     */
    public void onSubmitReport(View v) {
        if (v.getId() == R.id.Bsubmitreport) {
            location = (EditText) findViewById(R.id.ETwaterloc);

            onShareReport();

            Intent createReport = new Intent(CreateReport.this, SuccessfulLogin.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(createReport);

        }

    }



    /**
     * method for sharing water report to sharedpref
     */
    private void onShareReport(){


//            Object[] newreport = new Object[6];
//            newreport[0] = waterReports.size();
//            newreport[1] = Login.mEmailView.getText().toString();
//            newreport[2] = DateFormat.getDateTimeInstance().format(new Date());
//            newreport[3] = location.getText();
//            newreport[4] = watertypespinner.getSelectedItem().toString();
//            newreport[5] = waterconditionspinner.getSelectedItem().toString();
//            waterReports.add(newreport);

        SharedPreferences loadReports = getSharedPreferences("MySavedReports", MODE_PRIVATE);


        int numofReports = loadReports.getInt("number of reports", 0);
        String allreports = loadReports.getString("Water Reports", "");
        String reportID = loadReports.getString("Report ID: ", "");
        String reporter = loadReports.getString("Reporter: ", "");
        String time = loadReports.getString("Time: ", "");
        String waterLocation = loadReports.getString("Location: ", "");
        String waterType = loadReports.getString("Water Type: " , "");
        String waterCondition = loadReports.getString("Water Condition: ", "");

        numofReports++;
        reportID += numofReports + ", ";
        reporter += Login.mEmailView.getText().toString() + ", ";
        time += DateFormat.getDateTimeInstance().format(new Date()) + "; ";
        waterLocation += location.getText() + "; ";
        waterType += watertypespinner.getSelectedItem().toString() + ", ";
        waterCondition += waterconditionspinner.getSelectedItem().toString() + ", ";


        String[] reportIds = reportID.split(", ");
        String[] reporters = reporter.split(", ");
        String[] times = time.split("; ");
        String[] locations = waterLocation.split("; ");
        String[] watertypes = waterType.split(", ");
        String[] waterconditions = waterCondition.split(", ");


        for (int i = 0; i < reportIds.length; i++){


            allreports += "\n"
                    + "Report ID: " + reportIds[i] + "\n"
                    + "Reporter: " + reporters[i] + "\n"
                    + "Time: " + times[i] + "\n"
                    + "Location: " +  locations[i] + "\n"
                    + "Water Type: " +  watertypes[i] + "\n"
                    + "Water Condition: " +  waterconditions[i] + "\n \n";

//                reportID += CreateReport.waterReports.get(i)[0] + ", ";
//                reporter += CreateReport.waterReports.get(i)[1] + ", ";
//                time += CreateReport.waterReports.get(i)[2] + ", ";
//                waterLocation += CreateReport.waterReports.get(i)[3] + "; ";
//                waterType +=CreateReport.waterReports.get(i)[4] + ", ";
//                waterCondition += CreateReport.waterReports.get(i)[5] + ", ";
        }



        SharedPreferences saveReports = getSharedPreferences(SAVENAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = saveReports.edit();

        editor.putString("all reports", allreports);


        editor.putInt("number of reports", numofReports);

        editor.putString("Report ID: ", reportID);
        editor.putString("Reporter: ", reporter);
        editor.putString("Time: ", time);
        editor.putString("Location: ", waterLocation);
        editor.putString("Water Type: " , waterType);
        editor.putString("Water Condition: ", waterCondition);

        editor.apply();
    }






}
