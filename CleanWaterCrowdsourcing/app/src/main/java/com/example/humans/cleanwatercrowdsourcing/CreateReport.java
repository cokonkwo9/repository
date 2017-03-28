package com.example.humans.cleanwatercrowdsourcing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by omegahaileyesus on 3/6/17.
 */




public class CreateReport extends AppCompatActivity {


    public static ArrayList<Object[]> waterReports = new ArrayList<Object[]>();
    private Spinner waterconditionspinner;
    private Spinner watertypespinner;
    public static final String SAVENAME = "MySavedReports";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_report);


        waterconditionspinner = (Spinner) findViewById(R.id.SPwatercondition);
        ArrayAdapter wcadapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Arrays.asList("Waste", "Treatable-Clear", "Treatable-Muddy", "Potable"));
        wcadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        waterconditionspinner.setAdapter(wcadapter);


        watertypespinner = (Spinner) findViewById(R.id.SPwatertype);
        ArrayAdapter wtadapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Arrays.asList("Bottled", "Well", "Stream", "Lake", "Spring", "Other"));
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
            EditText location = (EditText) findViewById(R.id.ETwaterloc);

            Object[] newreport = new Object[6];
            newreport[0] = waterReports.size();
            newreport[1] = Login.mEmailView.getText().toString();
            newreport[2] = DateFormat.getDateTimeInstance().format(new Date());
            newreport[3] = location.getText();
            newreport[4] = watertypespinner.getSelectedItem().toString();
            newreport[5] = waterconditionspinner.getSelectedItem().toString();
            waterReports.add(newreport);

            //SharedPreferences loadReports = getSharedPreferences("MySavedReports", MODE_PRIVATE);
            //String allreports = loadReports.getString("Water Reports", "");

            String allreports = "";
            for (int i = 0; i < CreateReport.waterReports.size(); i++){
                allreports += "\n"
                        + "Report ID: " + CreateReport.waterReports.get(i)[0] + "\n"
                        + "Reporter: " + CreateReport.waterReports.get(i)[1] + "\n"
                        + "Time: " + CreateReport.waterReports.get(i)[2] + "\n"
                        + "Location: " +  CreateReport.waterReports.get(i)[3] + "\n"
                        + "Water Type: " +  CreateReport.waterReports.get(i)[4] + "\n"
                        + "Water Condition: " +  CreateReport.waterReports.get(i)[5] + "\n \n";
            }



            SharedPreferences saveReports = getSharedPreferences(SAVENAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = saveReports.edit();

            editor.putString("Water Reports", allreports);
            editor.apply();






            Intent createReport = new Intent(CreateReport.this, SuccessfulLogin.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(createReport);

        }

    }



}
