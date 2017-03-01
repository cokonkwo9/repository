package com.example.humans.cleanwatercrowdsourcing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;

import static com.example.humans.cleanwatercrowdsourcing.Register.bigUserInfo;

/**
 * Created by omegahaileyesus on 2/28/17.
 */

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);


        TextView userinfo = (TextView) findViewById(R.id.TVuserinfo);
        String username = "a@b.com"; //FirebaseAuth.getInstance().getCurrentUser().getEmail();

        HashMap<String,String> smalluserinfo = (HashMap) bigUserInfo.get(username);
        String userinfoString = smalluserinfo.get("userType") + "\n"
                        + smalluserinfo.get("house address") + "\n"
                        + smalluserinfo.get("location"); // should be "worker"



        userinfo.setText(userinfoString);
        //setContentView(R.layout.edit_profile);
    }

    /**
     * method for clicking back button, return to previous screen
     * @param v - current view
     */
    public void onClickBack(View v) {
        if (v.getId() == R.id.BgoBack) {
            Intent back = new Intent(EditProfile.this, SuccessfulLogin.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(back);

        }

    }

}
