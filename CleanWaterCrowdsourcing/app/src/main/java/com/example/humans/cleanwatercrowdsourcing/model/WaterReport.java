package com.example.humans.cleanwatercrowdsourcing.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

/**
 * Created by omegahaileyesus on 4/11/17.
 */

public class WaterReport {
    public enum waterType{
        BOTTLED, WELL, STREAM, LAKE, SPRING, OTHER
    }

    public enum waterCondition{
        POTABLE, TREATABLE_CLEAR, TREATABLE_MUDDY, WASTE
    }


    private Date time;
    private int reportID;
    private String reporter;
    private String waterCondition;
    private String waterType;
    private LatLng location;



    public LatLng getwaterLocation() {
        return location;
    }

    public void setwaterLocation(LatLng location) {
        this.location = location;
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }


    public String getWaterCondition() {
        return waterCondition;
    }

    public void setWaterCondition(String waterCondition) {
        this.waterCondition = waterCondition;
    }


    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }


    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }




}
