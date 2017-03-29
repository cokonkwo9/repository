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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.successful_login);

        //Toast.makeText(SuccessfulLogin.this, "Login Successful",Toast.LENGTH_SHORT).show();
    }

    /**
     * method for logging out
     * @param v - current view
     */
    public void onLogout(View v) {

        if (v.getId() == R.id.Blogout) {

            Intent login = new Intent(SuccessfulLogin.this, HomeScreen.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(login);

        }

    }

    /**
     * method for switching to edit profile pag
     * @param v - current view
     */
    public void onEditProfile(View v) {

        if (v.getId() == R.id.Beditprofile) {

            Intent edit = new Intent(SuccessfulLogin.this, EditProfile.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(edit);

        }

    }

    /**
     * method for creating a water report
     * @param v - current view
     */

    public void onCreateReport(View v) {

        if (v.getId() == R.id.Bcreatereport) {

            Intent createReport = new Intent(SuccessfulLogin.this, CreateReport.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(createReport);

        }

    }

    /**
     * method for viewing all water reports
     * @param v - current view
     */

    public void onViewReports(View v) {

        if (v.getId() == R.id.Bviewreports) {

            Intent createReport = new Intent(SuccessfulLogin.this, ViewReports.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(createReport);

        }

    }




    /**
     * method for viewing map
     * @param v - current view
     */
    public void onViewMap(View v) {

        if (v.getId() == R.id.Bviewmap) {

            Intent viewmap = new Intent(SuccessfulLogin.this, ViewMap.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(viewmap);

        }

    }


    /**
     * method for viewing history graph
     * @param v - current view
     */
    public void onViewHistory(View v) {

        if (v.getId() == R.id.Bhistory) {

            if (Login.usertype.equals("Manager") || Login.usertype.equals("Admin")) {

                Intent viewhistory = new Intent(SuccessfulLogin.this, ViewHistoryGraph.class);
                FirebaseAuth.getInstance().signOut();
                startActivity(viewhistory);
            } else{
                Toast.makeText(SuccessfulLogin.this, "No Access",Toast.LENGTH_SHORT).show();
            }

        }

    }



    /**
     * method for creating purity report
     * @param v - current view
     */
    public void onCreatePurity(View v) {

        if (v.getId() == R.id.Bsubmitpurity) {

            if (!(Login.usertype.equals("User"))) {
                Intent createp = new Intent(SuccessfulLogin.this, CreatePurityReport.class);
                FirebaseAuth.getInstance().signOut();
                startActivity(createp);
            } else{
                Toast.makeText(SuccessfulLogin.this, "No Access",Toast.LENGTH_SHORT).show();
            }


        }

    }


    /**
     * method for viewing purity reports
     * @param v - current view
     */
    public void onViewPurity(View v) {

        if (v.getId() == R.id.Bviewpurity) {

            if (!(Login.usertype.equals("User"))) {
                Intent viewp = new Intent(SuccessfulLogin.this, ViewPurityReport.class);
                FirebaseAuth.getInstance().signOut();
                startActivity(viewp);
            } else{
                Toast.makeText(SuccessfulLogin.this, "No Access",Toast.LENGTH_SHORT).show();
            }


        }

    }

}

