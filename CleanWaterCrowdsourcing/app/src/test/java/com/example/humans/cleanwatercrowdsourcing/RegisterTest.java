package com.example.humans.cleanwatercrowdsourcing;

import com.example.humans.cleanwatercrowdsourcing.controller.Register;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

/**
 * Created by chikaokonkwo on 4/12/17.
 */

public class RegisterTest {

    private String password1;

    private String password2;

    private String password3;

    private String password4;


    public void setUp() {
        password1 = "t22";
        password2 =  NULL;
        password3 =  "takemetothecandyshopletmelick";
        password4 = "thisblows";

    }

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCreateUsername() {
        setUp();
        Register register = new Register();
        String p4 = register.generatePassword(password4);

        Assert.assertEquals(p4, "thisblows");

    }

    @Test
    public void testNullPointerException() {
        setUp();

        //thrown.expect(NullPointerException.class);
        thrown.expect(IllegalArgumentException.class);

        Register register = new Register();
        String p1 = register.generatePassword(password2);
    }

    @Test
    public void testIllegalArgumentException() {
        setUp();

        Register register = new Register();

        String p2 = register.generatePassword(password1);
        String p3 = register.generatePassword(password3);

    }

}
