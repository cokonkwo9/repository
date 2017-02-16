package com.example.humans.cleanwatercrowdsourcing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by omegahaileyesus on 2/14/17.
 */

public class SuccessfulLogin extends AppCompatActivity {
    FirebaseAuth fbAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.successful_login);

        Toast.makeText(SuccessfulLogin.this, "Login Successful",Toast.LENGTH_SHORT).show();
    }


    public void onLogout(View v) {

        if (v.getId() == R.id.Blogout) {

            Intent login = new Intent(SuccessfulLogin.this, HomeScreen.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(login);

        }

    }
}

