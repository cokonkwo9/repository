package com.example.humans.cleanwatercrowdsourcing;
import com.example.humans.cleanwatercrowdsourcing.controller.Register;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Yotam on 4/9/17.
 */

public class CreateUsernameTest {

    String email1;
    String email2;
    String email3;
    String email4;
    String email5;

    @Before
    public void setUp() {
        email1 = "jacob123@gmail.com";
        email2 = "latterman";
        email3 = "vdnfefono@d.com";
        email4 = null;
        email5 = "jake@gmail.com";


    }


    @Test
    public void testCreateUsername() {
        setUp();
        Register register = new Register();
        String username1 = register.createUsernameFromEmail(email1);
        String username3 = register.createUsernameFromEmail(email3);

        Assert.assertEquals(username1, "jacob1230");
        Assert.assertEquals(username3, "vdnfefono1");

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testNullPointerException() {
        setUp();

        thrown.expect(NullPointerException.class);
        Register register = new Register();
        String username4 = register.createUsernameFromEmail(email4);
    }




    @Test
    public void testIllegalArgumentException() {
        setUp();

        thrown.expect(IllegalArgumentException.class);
        Register register = new Register();

        String username2 = register.createUsernameFromEmail(email2);
        String username5 = register.createUsernameFromEmail(email5);

    }



}
