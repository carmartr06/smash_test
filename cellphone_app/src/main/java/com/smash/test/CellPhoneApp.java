package com.smash.test;

import com.smash.test.model.ReportHeader;
import com.smash.test.service.ICellPhoneUsageServiceContract;
import com.smash.test.service.util.MessageUtil;
import com.smash.test.service.util.PrinterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

/**
 * Class used to start the spring boot app
 */
@SpringBootApplication
public class CellPhoneApp implements CommandLineRunner {

    // logger attribute
    private static final Logger log = LoggerFactory.getLogger(CellPhoneApp.class);

    /**
     * Reference to the service implementation
     */
    @Autowired
    private ICellPhoneUsageServiceContract service;

    /**
     * Reference to the message utility
     */
    @Autowired
    private MessageUtil messageUtil;

    /**
     * Refercne to the printer utility
     */
    @Autowired
    private PrinterUtil printerUtil;

    /**
     * Default main method to run the spring boot app
     * @param args
     */
    public static void main (String[] args){
        SpringApplication.run(CellPhoneApp.class, args);
    }

    /**
     * Default method for command line application
     * @param args
     * @throws Exception
     */
    @Override
    public void run (String... args) throws Exception{
        log.info("Running Smash Report Generation Tool");

        String from = this.messageUtil.get("report.from.date");
        String to = this.messageUtil.get("report.to.date");
        try {


            // convert to dates
            LocalDate fromDate = LocalDate.parse(from, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate toDate = LocalDate.parse(to, DateTimeFormatter.ISO_LOCAL_DATE);

            if(fromDate.isAfter(toDate)){
                log.info("From date should be greater than To date.");
                throw new Exception("From date should be greater than To date.");
            }

            // get report header
            ReportHeader reportHeader = service.getReportHeader(fromDate, toDate);

            // print the report
            printerUtil.printReport(reportHeader, fromDate, toDate);
        }catch (DateTimeParseException ex)
        {
            log.info(String.format(this.messageUtil.get("app.error.date.parse"), from, to));
        }
    }
}
