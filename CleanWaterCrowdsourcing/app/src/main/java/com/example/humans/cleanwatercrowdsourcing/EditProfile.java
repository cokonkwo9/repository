package com.example.humans.cleanwatercrowdsourcing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by omegahaileyesus on 2/28/17.
 */

public class EditProfile extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
    }

    public void onClickBack(View v) {
        if (v.getId() == R.id.BgoBack) {
            Intent back = new Intent(EditProfile.this, SuccessfulLogin.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(back);

        }

    }

}
