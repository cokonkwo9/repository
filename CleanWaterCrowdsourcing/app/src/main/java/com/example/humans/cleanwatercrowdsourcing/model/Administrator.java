package com.example.humans.cleanwatercrowdsourcing.model;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.humans.cleanwatercrowdsourcing.R;

@SuppressWarnings("unused")
public class Administrator extends AppCompatActivity {
    /**
     * method for getting username
     */
    public String getUsername() {
        return username;
    }
    /**
     * method for setting username
     * @param username - username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    private String username;
    /**
     * method for getting password
     */
    public String getPassword() {
        return password;
    }
    /**
     * method for setting password
     * @param password - password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    /**
     * method for getting usertype
     */
    public String getUsertype() {
        return usertype;
    }
    /**
     * method for setting usertype
     * @param usertype - usertype
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    /**
     * method for getting houseAddress
     */
    public String getHouseAddress() {
        return houseAddress;
    }
    /**
     * method for setting houseAddress
     * @param houseAddress - houseAddress
     */
    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    private String usertype;
    private String houseAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);
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
    }

}
