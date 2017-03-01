package com.example.humans.cleanwatercrowdsourcing;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
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
        String username = Register.username.getText().toString();

        HashMap<String,String> smalluserinfo = (HashMap) bigUserInfo.get(username);

        String email = Register.username.getText().toString();

        String userinfoString = "Username: " + email + "\n"
                                + "Usertype: " + smalluserinfo.get("userType") + "\n"
                                + "House Address: " + smalluserinfo.get("house address") + "\n"
                                + "Location: " + smalluserinfo.get("location"); // should be "worker"

        EditText enterusertype = (EditText) findViewById(R.id.ETusertype);
        enterusertype.setText(smalluserinfo.get("userType"), TextView.BufferType.EDITABLE);


        EditText enterhouse = (EditText) findViewById(R.id.EThouseaddress);
        enterhouse.setText(smalluserinfo.get("house address"), TextView.BufferType.EDITABLE);

        EditText enterlocation = (EditText) findViewById(R.id.ETlocation);
        enterlocation.setText(smalluserinfo.get("location"), TextView.BufferType.EDITABLE);




        userinfo.setText(userinfoString);
        //setContentView(R.layout.edit_profile);
    }

    /**
     * method for clicking back button, return to previous screen
     * @param v - current view
     */
    public void onClickBack(View v) {
        if (v.getId() == R.id.BgoBack) {

            String username = Register.username.getText().toString();
            HashMap<String,String> smalluserinfo = (HashMap) bigUserInfo.get(username);



            EditText enterusertype = (EditText) findViewById(R.id.ETusertype);
            String newusertype = enterusertype.getText().toString();
            smalluserinfo.put("userType", newusertype);

            EditText enterhouse = (EditText) findViewById(R.id.EThouseaddress);
            String newhouse = enterhouse.getText().toString();
            smalluserinfo.put("house address", newhouse);

            EditText enterlocation = (EditText) findViewById(R.id.ETlocation);
            String newlocation = enterlocation.getText().toString();
            smalluserinfo.put("location", newlocation);





            Intent back = new Intent(EditProfile.this, SuccessfulLogin.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(back);

        }

    }

}
