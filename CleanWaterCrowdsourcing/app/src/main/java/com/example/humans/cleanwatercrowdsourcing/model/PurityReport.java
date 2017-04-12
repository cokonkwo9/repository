package com.example.humans.cleanwatercrowdsourcing.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

/**
 * Created by omegahaileyesus on 4/11/17.
 * class for purity report instance data
 */

@SuppressWarnings("unused")
public class PurityReport {

    @SuppressWarnings("unused")
    public enum waterCondition {
        SAFE, TREATABLE, UNSAFE
    }


    private Date time;
    private int reportID;
    private String reporter;
    private String waterCondition;
    private String waterType;
    private LatLng location;
    private int virusPPM;
    private int contaminantPPM;



    /**
     * method for getting virusPPM
     */
    public int getVirusPPM() {
        return virusPPM;
    }
    /**
     * method for setting virusPPM
     * @param virusPPM - virusPPM
     */
    public void setVirusPPM(int virusPPM) {
        this.virusPPM = virusPPM;
    }

    /**
     * method for getting contaminantPPM
     */
    public int getContaminantPPM() {
        return contaminantPPM;
    }
    /**
     * method for setting contaminantPPM
     * @param contaminantPPM - contaminantPPM
     */
    public void setContaminantPPM(int contaminantPPM) {
        this.contaminantPPM = contaminantPPM;
    }
    /**
     * method for getting location
     */
    public LatLng getWaterLocation() {
        return location;
    }
    /**
     * method for setting location
     * @param location - location
     */
    public void setWaterLocation(LatLng location) {
        this.location = location;
    }
    /**
     * method for getting waterType
     */
    public String getWaterType() {
        return waterType;
    }
    /**
     * method for setting waterType
     * @param waterType - waterType
     */
    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    /**
     * method for getting waterCondition
     */
    public String getWaterCondition() {
        return waterCondition;
    }
    /**
     * method for setting waterCondition
     * @param waterCondition - waterCondition
     */
    public void setWaterCondition(String waterCondition) {
        this.waterCondition = waterCondition;
    }

    /**
     * method for getting reportID
     */
    public int getReportID() {
        return reportID;
    }
    /**
     * method for setting reportID
     * @param reportID - reportID
     */
    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    /**
     * method for getting reporter
     */
    public String getReporter() {
        return reporter;
    }
    /**
     * method for setting reporter
     * @param reporter - reporter
     */
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
}
