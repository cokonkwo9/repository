package com.example.humans.cleanwatercrowdsourcing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Register extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth fbAuthentication;
    private EditText username;
    private EditText password;
    private Button register_button;
    private ProgressDialog progressDialog;
    private Spinner spinner;
    private FirebaseAnalytics mFirebaseAnalytics;
    public static HashMap<String, Map<String, String>> bigUserInfo;


    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        bigUserInfo = new HashMap<>();



       //mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        setContentView(R.layout.activity_register);
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

        progressDialog = new ProgressDialog(this);
        fbAuthentication = FirebaseAuth.getInstance();
        register_button = (Button) findViewById(R.id.registerButton);
        username =  ((EditText)findViewById(R.id.username));
        password = ((EditText)findViewById(R.id.password));
        register_button.setOnClickListener(this);
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Arrays.asList("User", "Worker", "Manager", "Admin"));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }



    public void register () {
        final String usernameText = username.getText().toString().trim();
        String passwordText = password.getText().toString().trim();

        // username is empty
        if (TextUtils.isEmpty(usernameText)) {
            Toast.makeText(this, "Enter a username please", Toast.LENGTH_SHORT).show();
        }
        // password is empty
        if (TextUtils.isEmpty(passwordText)) {
            Toast.makeText(this, "Enter a password please", Toast.LENGTH_SHORT).show();
        }
        //if both fields have content
        progressDialog.setMessage("Registering . . .");
        progressDialog.show();


        fbAuthentication.createUserWithEmailAndPassword(usernameText,passwordText)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            String user_type = "UserType: " + spinner.getSelectedItem().toString();
                            String house_address = "House Address: ";
                            String location = "Location: ";

                            HashMap<String,String> smallUserInfo = new HashMap<String, String>();
                            smallUserInfo.put("userType", user_type);
                            smallUserInfo.put("house address", house_address);
                            smallUserInfo.put("location", location);

                            bigUserInfo.put(usernameText,smallUserInfo);
                            //System.out.println(bigUserInfo.get(usernameText).get("userType"));

                            Toast.makeText(Register.this, "Registration Successful",Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                            Intent registerSuccess = new Intent(Register.this, SuccessfulRegistration.class);
                            startActivity(registerSuccess);
                        } else {
                            Toast.makeText(Register.this, "Registration Failed. Please try again.",Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                        }
                    }
                });


    }

    @Override
    public void onClick(View view) {
        if (view == register_button) {
            register();
        }

    }
}
