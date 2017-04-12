package com.example.humans.cleanwatercrowdsourcing;

import com.example.humans.cleanwatercrowdsourcing.model.WaterReport;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by omegahaileyesus on 4/11/17.
 * junit to test valid inputs to create water report
 */

@SuppressWarnings("UnusedAssignment")
public class CreateReportTest {

    private int reportID1;
    private String reporter1;
    private String waterCondition1;
    private String waterType1;

    private int reportID2;
    private String reporter2;
    private String waterCondition2;
    private String waterType2;

    private int reportID3;
    private String reporter3;
    private String waterCondition3;
    private String waterType3;

    private int reportID4;
    private String reporter4;
    private String waterCondition4;
    private String waterType4;

    private int reportID5;
    private String reporter5;
    private String waterCondition5;
    private String waterType5;

    @Before
    public void setUp() {
        reportID1 = -1;
        reporter1 = "hello@hello.com";
        waterCondition1 = "Potable";
        waterType1 = "Bottled";


        reportID2 = 1;
        reporter2 = "";
        waterCondition2 = "Potable";
        waterType2 = "Bottled";



        reportID3 = 2;
        reporter3 = "hello@hello.com";
        waterCondition3 = "Good";
        waterType3 = "Bottled";



        reportID4 = 3;
        reporter4 = "hello@hello.com";
        waterCondition4 = "Potable";
        waterType4 = "Clean";



        reportID5 = 4;
        reporter5 = "hello@hello.com";
        waterCondition5 = "Potable";
        waterType5 = "Bottled";

    }


    @Rule
    public final ExpectedException thrown = ExpectedException.none();


    @Test
    public void testIllegalReporterID() {
        setUp();

        thrown.expect(IllegalArgumentException.class);
        WaterReport report = new WaterReport(reportID1,reporter1,waterCondition1,waterType1);

    }

    @Test
    public void testIllegalReporterName() {
        setUp();

        thrown.expect(IllegalArgumentException.class);
        WaterReport report = new WaterReport(reportID2,reporter2,waterCondition2,waterType2);

    }

    @Test
    public void testIllegalWaterCondition() {
        setUp();

        thrown.expect(IllegalArgumentException.class);
        WaterReport report = new WaterReport(reportID3,reporter3,waterCondition3,waterType3);

    }

    @Test
    public void testIllegalWaterType() {
        setUp();

        thrown.expect(IllegalArgumentException.class);
        WaterReport report = new WaterReport(reportID4,reporter4,waterCondition4,waterType4);

    }

    @Test
    public void testValidInputs() {
        setUp();

        //thrown.expect(IllegalArgumentException.class);
        WaterReport report = new WaterReport(reportID5,reporter5,waterCondition5,waterType5);

    }



}

