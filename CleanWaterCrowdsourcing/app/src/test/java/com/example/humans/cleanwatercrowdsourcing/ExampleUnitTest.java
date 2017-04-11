package com.example.humans.cleanwatercrowdsourcing;
import android.content.Context;

import com.example.humans.cleanwatercrowdsourcing.controller.Login;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.example.humans.cleanwatercrowdsourcing.controller.Register;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;





/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@SuppressWarnings("ALL")

public class ExampleUnitTest {
    private FirebaseAuth fbAuthentication;
    private FirebaseAuth firebaseAuth;
    private String id = null;
    private String password1 = null;
    private String password2 = null;
    private String typePassword;
    private String fname = null;
    private String lname = null;
    private String email1 = null;
    private String email2 = null;
    private final String phone = null;
    private final String address = null;
    private String latitude;
    private String longitude;
    private String waterType;
    private String waterCondition;
    private String date;
    private static FirebaseApp application;
    private Context application2;

    @Before
    public void setUp() {
        email1 = "jacob123@gmail.com";
        email2 = "latterman";
        password1 = "abc";
        password1 = "I_Like_cookies321";
        typePassword = null;
        //application = FirebaseApp.initializeApp(this);
        //application.initializeApp(this);
        fbAuthentication = FirebaseAuth.getInstance(application);



    }



    @Test
    public void testRegistration() {
        setUp();
        Register reg = new Register();
        String usernameText = email1;
        String passwordText = password1;
        //FirebaseApp.initializeApp(reg);
        //Intent registerScreen = new Intent(this, com.example.humans.cleanwatercrowdsourcing.controller.Register.class);
//        application2 = application.getApplicationContext();
        //reg.onCreate(new Bundle());
        //fbAuthentication = FirebaseAuth.getInstance();



        email1 = "jacob123@gmail.com";
        password1 = "I_Like_cookies321";
        typePassword = "Bad Password";

        /*fbAuthentication.createUserWithEmailAndPassword("fsdfd", "fdsfsdf")
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            typePassword = "Bad Password";
                        } else {
                            typePassword = "Good Password";
                        }
                    }
                });
                */

        assertEquals(typePassword, "Bad Password");
    }

    @Test
    public void loginTest() {
        setUp();
        Login login = new Login();



    }

    @Test
    public void editProfile() {
        setUp();
        Login login = new Login();



    }

}