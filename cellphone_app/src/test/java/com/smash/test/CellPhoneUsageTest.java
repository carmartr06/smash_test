package com.smash.test;

import com.smash.test.entities.CellPhoneUsage;
import com.smash.test.model.ReportHeader;
import com.smash.test.repository.ICellPhoneUsageRepository;
import com.smash.test.service.ICellPhoneUsageServiceContract;
import com.smash.test.service.util.MessageUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CellPhoneUsageTest {

    @Autowired
    private ICellPhoneUsageRepository repository;

    @Autowired
    private ICellPhoneUsageServiceContract service;

    @Autowired
    private MessageUtil messageUtil;

    /**
     * Test method for repository function. Here we do a basic test to check if the repository is reading the data as expected
     */
    @Test
    void testCellPhoneUsageRepository(){
        List<CellPhoneUsage> list = repository.findAllByDateBetweenOrderByDateAsc(LocalDate.of(2018,02,01),
                LocalDate.of(2018,02,27));
        assertTrue(list.size() > 0);
    }

    /**
     * Test method for service function. Here we do a test to get the required object
     */
    @Test
    void testGetReportHeader(){
        ReportHeader header = service.getReportHeader(LocalDate.of(2018,02,01),
                LocalDate.of(2018,04,27));

        assertTrue(header != null);
    }
}
