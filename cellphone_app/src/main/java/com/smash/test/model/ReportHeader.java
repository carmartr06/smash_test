package com.smash.test.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to store ReportHeader information.
 * Here we point to the ReportDetail objects inside a list
 */
public class ReportHeader {

    private LocalDate runDate;
    private int numberOfPhones;
    private int totalMinutes;
    private double totalData;
    private double avgMinutes;
    private double avgData;
    private List<ReportDetail> details;

    /**
     * Default constructor used to initialize variables
     */
    public ReportHeader(){
        this.setDetails(new ArrayList<>());
    }

    /*
    Getters and setters
     */

    public LocalDate getRunDate() {
        return runDate;
    }

    public void setRunDate(LocalDate runDate) {
        this.runDate = runDate;
    }

    public int getNumberOfPhones() {
        return numberOfPhones;
    }

    public void setNumberOfPhones(int numberOfPhones) {
        this.numberOfPhones = numberOfPhones;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(int totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public double getTotalData() {
        return totalData;
    }

    public void setTotalData(double totalData) {
        this.totalData = totalData;
    }

    public double getAvgMinutes() {
        return avgMinutes;
    }

    public void setAvgMinutes(double avgMinutes) {
        this.avgMinutes = avgMinutes;
    }

    public double getAvgData() {
        return avgData;
    }

    public void setAvgData(double avgData) {
        this.avgData = avgData;
    }

    public List<ReportDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ReportDetail> details) {
        this.details = details;
    }
}
