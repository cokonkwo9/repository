package com.example.humans.cleanwatercrowdsourcing.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.humans.cleanwatercrowdsourcing.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

/**
 * Created by omegahaileyesus on 3/28/17.
 * class for viewing graph, account must enter data desired
 */

public class ViewHistoryGraph extends AppCompatActivity {

    private Spinner graphtypespinner;

    public static String graphtype;
    public static String graphyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_history_graph);


        graphtypespinner = (Spinner) findViewById(R.id.SPgraphtype);
        @SuppressWarnings("Convert2Diamond") ArrayAdapter wcadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Arrays.asList("Virus", "Contaminant"));
        wcadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        graphtypespinner.setAdapter(wcadapter);





    }



    /**
     * method for displaying history graph
     * @param v - current view
     */
    public void onDisplayGraph(View v) {
        if (v.getId() == R.id.Bdisplaygraph) {

            graphtype = graphtypespinner.getSelectedItem().toString();
            EditText yeartext = (EditText) findViewById(R.id.ETyear);

            graphyear = yeartext.getText().toString();



            Intent display = new Intent(ViewHistoryGraph.this, DisplayGraph.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(display);

        }
    }
}
