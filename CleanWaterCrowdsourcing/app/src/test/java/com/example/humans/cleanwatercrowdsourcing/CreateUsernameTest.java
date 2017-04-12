package com.example.humans.cleanwatercrowdsourcing;
import com.example.humans.cleanwatercrowdsourcing.controller.Register;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Yotam on 4/9/17.
 * junit to test valid username entries
 */

@SuppressWarnings("UnusedAssignment")
public class CreateUsernameTest {

    private String email1;
    private String email2;
    private String email3;
    private String email4;
    private String email5;
    private String email6;
    private String email7;

    @Before
    public void setUp() {
        email1 = "jacob123@gmail.com";
        email2 = "latterman";
        email3 = "vdnfefono@d.com";
        email4 = null;
        email5 = "jake@gmail.com";
        email6 = "terryjohnsmithcarrybobbylibrarycandycornneckboyfishlip@yahoo.com";
        email7 = "jnk413!!&*fd()@msn.com";


    }

    @Test
    public void testSuperLongUsername() {
        setUp();
        Register register = new Register();
        String username6 = register.createUsernameFromEmail(email6);

        Assert.assertEquals(username6, "terryjohnsmithcarrybobbylibrarycandycornneckboyfishlip0");

    }


    @Test
    public void testCreateUsername() {
        setUp();
        Register register = new Register();
        String username1 = register.createUsernameFromEmail(email1);
        String username3 = register.createUsernameFromEmail(email3);

        Assert.assertEquals(username1, "jacob1231");
        Assert.assertEquals(username3, "vdnfefono2");

    }




    @Test
    public void testUsernameWithVariousKeys() {
        setUp();
        Register register = new Register();
        String username7 = register.createUsernameFromEmail(email7);

        Assert.assertEquals(username7, "jnk413!!&*fd()3");

    }

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

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
