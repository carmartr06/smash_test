package com.smash.test.service;

import com.smash.test.entities.CellPhoneUsage;
import com.smash.test.model.ReportHeader;
import java.time.LocalDate;
import java.util.List;

/**
 * CellPhoneUsage entity Service Contract interface.
 * This interface exposes all methods that must be implemented as part of the CellPhoneUsage service
 */
public interface ICellPhoneUsageServiceContract {
    /**
     * This method searches for all CellPhoneUsage entities between the date ranges.
     * After that, it will created the required objects to be able to render a report in the console
     * @param from The date to use as the start
     * @param to The date to use as the end
     * @return The ReportHeader object that can be used to generate a report
     */
    public ReportHeader getReportHeader(LocalDate from, LocalDate to);
}
