package com.smash.test.service.util;

import com.smash.test.model.MonthlyUsage;
import com.smash.test.model.ReportDetail;
import com.smash.test.model.ReportHeader;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * This class handles the report printing feature
 * As of now it is only printing to console, this can be enhanced to call a report utility like Jasper or JReport
 */
@Component
public class PrinterUtil {

    /**
     * Method used to print the report to console
     * @param header The report to be printed
     */
    public void printReport(ReportHeader header, LocalDate from, LocalDate to){
        System.out.println("Printing Report.....");
        System.out.println(String.format("From: %s - To: %s", from, to));
        System.out.println("Header Section");
        System.out.println("\n");
        System.out.println(String.format("Run Date:\t %s", header.getRunDate().toString()));
        System.out.println(String.format("Number of Phones:\t %s", header.getNumberOfPhones()));
        System.out.println(String.format("Total Minutes:\t %s", header.getTotalMinutes()));
        System.out.println(String.format("Total Data:\t %s", header.getTotalData()));
        System.out.println(String.format("Average Minutes:\t %s", header.getAvgMinutes()));
        System.out.println(String.format("Average Data:\t %s", header.getAvgData()));

        System.out.println("\n");
        System.out.println("Details Section");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\n");

        for(ReportDetail detail: header.getDetails()){
            System.out.println(String.format("Employee Id:\t %s", detail.getCellPhone().getEmployeeId()));
            System.out.println(String.format("Employee Name:\t %s", detail.getCellPhone().getEmployeeName()));
            System.out.println(String.format("Model:\t %s", detail.getCellPhone().getModel()));
            System.out.println(String.format("Purchase Date:\t %s", detail.getCellPhone().getPurchaseDate()));
            System.out.println("Minutes Usage");
            for(MonthlyUsage usage : detail.getMonthlyUsageList())
            {
                System.out.print(String.format("Month: %s-%s Minutes: %s Data: %s \t\t |", usage.getYear(),
                        usage.getMonth(), usage.getMonthMinutes(), usage.getMonthData()));
            }
            System.out.println();
            System.out.println("*********************");
        }
    }
}
