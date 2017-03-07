package com.example.humans.cleanwatercrowdsourcing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static com.example.humans.cleanwatercrowdsourcing.R.id.spinner;

/**
 * Created by omegahaileyesus on 3/6/17.
 */




public class CreateReport extends AppCompatActivity {


    public static ArrayList<Object[]> waterReports = new ArrayList<Object[]>();
    private Spinner waterconditionspinner;
    private Spinner watertypespinner;



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




            Intent createReport = new Intent(CreateReport.this, SuccessfulLogin.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(createReport);

        }

    }



}
