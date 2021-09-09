package com.smash.test.model;

/**
 * Class to store the monthly details by CellPhone
 * The idea here is to map a month with the specific data.
 */
public class MonthlyUsage {

    private int year;
    private int month;
    private int monthMinutes;
    private double monthData;

    /**
     * Default constructor
     */
    public MonthlyUsage(){
        this.setYear(0);
        this.setMonth(0);
        this.setMonthMinutes(0);
        this.setMonthData(0.0);
    }

    /*
    Getters and setters
     */
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonthMinutes() {
        return monthMinutes;
    }

    public void setMonthMinutes(int monthMinutes) {
        this.monthMinutes = monthMinutes;
    }

    public double getMonthData() {
        return monthData;
    }

    public void setMonthData(double monthData) {
        this.monthData = monthData;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
