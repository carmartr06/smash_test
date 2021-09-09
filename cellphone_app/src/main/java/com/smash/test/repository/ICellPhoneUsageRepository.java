package com.smash.test.repository;

import com.smash.test.entities.CellPhoneUsage;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * CellPhoneUsage repository interface.
 * We extend from Crud Repository only since we only need basic operations.
 * If needed in the future this can be changed to other repository.
 */
public interface ICellPhoneUsageRepository extends CrudRepository<CellPhoneUsage, Long> {

    /**
     * Method used to search for CellPhoneUsage entities using the 2 dates as the filter.
     * The results are sorted to save time in higher layers
     * @param from The date to start the search
     * @param to The date to use as the limit
     * @return All CellPhoneUsage entities that matched the condition
     */
    List<CellPhoneUsage> findAllByDateBetweenOrderByDateAsc(LocalDate from, LocalDate to);
}
