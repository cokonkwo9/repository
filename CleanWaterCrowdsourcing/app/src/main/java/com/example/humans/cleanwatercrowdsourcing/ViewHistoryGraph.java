package com.example.humans.cleanwatercrowdsourcing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

/**
 * Created by omegahaileyesus on 3/28/17.
 */

public class ViewHistoryGraph extends AppCompatActivity {

    private Spinner graphtypespinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_history_graph);


        graphtypespinner = (Spinner) findViewById(R.id.SPgraphtype);
        ArrayAdapter wcadapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Arrays.asList("Virus", "Contaminant"));
        wcadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        graphtypespinner.setAdapter(wcadapter);





    }



    /**
     * method for displaying history graph
     * @param v - current view
     */
    public void onDisplayGraph(View v) {
        if (v.getId() == R.id.Bdisplaygraph) {

            Intent display = new Intent(ViewHistoryGraph.this, DisplayGraph.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(display);

        }
    }
}
