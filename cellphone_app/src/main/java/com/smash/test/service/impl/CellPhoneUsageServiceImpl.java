package com.smash.test.service.impl;

import com.smash.test.entities.CellPhone;
import com.smash.test.entities.CellPhoneUsage;
import com.smash.test.model.MonthlyUsage;
import com.smash.test.model.ReportDetail;
import com.smash.test.model.ReportHeader;
import com.smash.test.repository.ICellPhoneUsageRepository;
import com.smash.test.service.ICellPhoneUsageServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service implementation class for CellPhoneUsage service contract.
 * This class will define the logic for the contract methods.
 */
@Service
public class CellPhoneUsageServiceImpl implements ICellPhoneUsageServiceContract {

    /**
     * Here we inject the required repository.
     * We should code to interfaces, so we use the interface as the type and not the implementation.
     */
    @Autowired
    private ICellPhoneUsageRepository repository;

    public ReportHeader getReportHeader(LocalDate from, LocalDate to){
        // get all usage between the required dates
        List<CellPhoneUsage> usageList = repository.findAllByDateBetweenOrderByDateAsc(from, to);

        // create instance of report header
        ReportHeader reportHeader = new ReportHeader();

        //by using streams, we can easily populate data like sums
        reportHeader.setTotalData(usageList.stream()
                .map(usage -> usage.getTotalData())
                .reduce(0.0, Double::sum));
        reportHeader.setTotalMinutes(usageList.stream()
                .map(usage -> usage.getTotalMinutes())
                .reduce(0L, Long::sum).intValue());

        // get the distinct count of CellPhone entities found
        // we use stream to make it easier and faster
        List<CellPhone> distinctCellPhone = usageList.stream().map(usage -> usage.getCellPhone()).distinct().collect(Collectors.toList());

        reportHeader.setNumberOfPhones(distinctCellPhone.size());

        // once we have the totals and the distinct numbers, we can calculate a more accurate average
        reportHeader.setAvgData(reportHeader.getTotalData() / reportHeader.getNumberOfPhones());
        reportHeader.setAvgMinutes((1.0* reportHeader.getTotalMinutes()) / reportHeader.getNumberOfPhones());

        // we set the date as of today
        reportHeader.setRunDate(LocalDate.now());

        // we can stream the distinct list to create a new list using each CellPhone entity
        // we call the ReportDetail overloaded constructor to initialize CellPhone details
        List<ReportDetail> reportDetails = distinctCellPhone.stream()
                .map(detail -> new ReportDetail(detail))
                .collect(Collectors.toList());

        // we set the details to the report header
        reportHeader.setDetails(reportDetails);

        // we iterate quickly on each detail
        // we can also use streams to accomplish this, however it will be really complex to read,
        // therefore, I went with the normal iteration here to keep the code simpler
        for (ReportDetail detail : reportHeader.getDetails()) {

            // get the list first by year and then by month
            // this is needed to properly display the information like 2021-02, 2021-03, etc.
            Map<Object, Map<Object, List<CellPhoneUsage>>> list = usageList.stream()
                    .filter(usage -> usage.getCellPhone().equals(detail.getCellPhone()))
                    .collect(Collectors.groupingBy(usage -> usage.getDate().getYear(), Collectors.groupingBy(usage -> usage.getDate().getMonthValue())));

            // iterate over the years
            for (Object year : list.keySet()){
                // iterate over the months
                for(Object month : list.get(year).keySet()) {
                    // create the monthly data
                    MonthlyUsage monthlyData = new MonthlyUsage();
                    // set year and month
                    monthlyData.setYear((Integer)year);
                    monthlyData.setMonth((Integer) month);

                    // set consumed data for this year and month
                    monthlyData.setMonthData(list.get(year).get(month).stream()
                            .map(usage -> usage.getTotalData())
                            .reduce(0.0, Double::sum));
                    monthlyData.setMonthMinutes(list.get(year).get(month).stream()
                            .map(usage -> usage.getTotalMinutes())
                            .reduce(0L, Long::sum).intValue());

                    // add the monthly details to the report details section
                    detail.getMonthlyUsageList().add(monthlyData);
                }
            }
        }

        // return the report header object
        return reportHeader;
    }
}