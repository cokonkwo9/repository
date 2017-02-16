package com.example.humans.cleanwatercrowdsourcing;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SuccessfulRegistration extends AppCompatActivity implements View.OnClickListener {
    private Button goHome;
    private Button goLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Toast.makeText(SuccessfulRegistration.this, "Registration Successful",Toast.LENGTH_LONG).show();

        goHome = (Button) findViewById(R.id.goHome);
        goHome.setOnClickListener(this);
        goLogin = (Button) findViewById(R.id.goLogin);
        goLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == goHome) {
            Intent goHomeIntent = new Intent(SuccessfulRegistration.this, HomeScreen.class);
            startActivity(goHomeIntent);
        }
        if (view == goLogin) {
            Intent goLoginIntent = new Intent(SuccessfulRegistration.this, Login.class);
            startActivity(goLoginIntent);
        }

    }

}
