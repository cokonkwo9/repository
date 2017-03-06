package com.example.humans.cleanwatercrowdsourcing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

import static com.example.humans.cleanwatercrowdsourcing.R.id.spinner;

/**
 * Created by omegahaileyesus on 3/6/17.
 */

public class CreateReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_report);


        Spinner waterconditionspinner = (Spinner) findViewById(R.id.SPwatercondition);
        ArrayAdapter wcadapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Arrays.asList("Waste", "Treatable-Clear", "Treatable-Muddy", "Potable"));
        wcadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        waterconditionspinner.setAdapter(wcadapter);


        Spinner watertypespinner = (Spinner) findViewById(R.id.SPwatertype);
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

            Intent createReport = new Intent(CreateReport.this, SuccessfulLogin.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(createReport);

        }

    }



}
