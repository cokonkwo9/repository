package com.example.humans.cleanwatercrowdsourcing.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by omegahaileyesus on 4/11/17.
 * class for water report instance data
 */

@SuppressWarnings("unused")
public class WaterReport {
    @SuppressWarnings("unused")
    public enum waterType{
        BOTTLED, WELL, STREAM, LAKE, SPRING, OTHER
    }

    @SuppressWarnings("unused")
    public enum waterConditions{
        POTABLE, TREATABLE_CLEAR, TREATABLE_MUDDY, WASTE
    }


    private Date time;
    private int reportID;
    private String reporter;
    private String waterCondition;
    private String waterType;
    private LatLng location;
    private final String[] waterCons = {"Potable", "Treatable-Clear", "Treatable-Muddy", "Waste"};
    private final String[] waterTypes = {"Bottled", "Well", "Stream", "Lake", "Spring", "Other"};


    public WaterReport(int reportID, String reporter, String waterCondition, String waterType) {
        setReportID(reportID);
        setReporter(reporter);
        setWaterCondition(waterCondition);
        setWaterType(waterType);
    }

    public LatLng getWaterLocation() {
        return location;
    }

    public void setWaterLocation(LatLng location) {
        this.location = location;
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        if (!Arrays.asList(waterTypes).contains(waterType)){
            throw new IllegalArgumentException("Not a valid water type.");
        }
        this.waterType = waterType;
    }


    public String getWaterCondition() {
        return waterCondition;
    }

    public void setWaterCondition(String waterCondition) {
        if (!Arrays.asList(waterCons).contains(waterCondition)){
            throw new IllegalArgumentException("Not a valid water condition.");

        }
        this.waterCondition = waterCondition;
    }


    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        if(reportID < 0){
            throw new IllegalArgumentException("Not a valid ID.");
        }
        this.reportID = reportID;
    }


    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        if (reporter.length() <= 0){
            throw new IllegalArgumentException("Not a valid name.");
        }
        this.reporter = reporter;
    }




}
