package com.example.humans.cleanwatercrowdsourcing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by omegahaileyesus on 2/14/17.
 */

public class SuccessfulLogin extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.successful_login);
    }


    public void onLogout(View v) {

        if (v.getId() == R.id.Blogout) {

            Intent login = new Intent(SuccessfulLogin.this, HomeScreen.class);
            startActivity(login);

        }

    }
}

