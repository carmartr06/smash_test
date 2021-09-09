package com.smash.test.model;

import com.smash.test.entities.CellPhone;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to store the Report Detail information.
 * We can reuse CellPhone entity to store the details to be displayed
 */
public class ReportDetail {
    private CellPhone cellPhone;
    /**
     * Here we are storing the details per year/month to be displayed as columns
     */
    private List<MonthlyUsage> monthlyUsageList;

    /**
     * Default consturctor to initialize variables
     */
    public ReportDetail(){
        this.setMonthlyUsageList(new ArrayList<>());
    }

    /**
     * Overloaded Constructor to initialize the CellPhone entity
     * @param cellPhone CellPhone entity to use
     */
    public ReportDetail(CellPhone cellPhone){
        this();
        this.setCellPhone(cellPhone);
    }

    /**
     * Overloaded Constructor to initialize the CellPhone entity and the MonthlyUsage details
     * @param cellPhone The CellPhone entity
     * @param monthlyUsageList The list of year/month to use
     */
    public ReportDetail(CellPhone cellPhone, List<MonthlyUsage> monthlyUsageList){
        this.setCellPhone(cellPhone);
        this.setMonthlyUsageList(monthlyUsageList);
    }

    /*
    Getters and setters
     */
    public CellPhone getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(CellPhone cellPhone) {
        this.cellPhone = cellPhone;
    }

    public List<MonthlyUsage> getMonthlyUsageList() {
        return monthlyUsageList;
    }

    public void setMonthlyUsageList(List<MonthlyUsage> monthlyUsageList) {
        this.monthlyUsageList = monthlyUsageList;
    }
}
