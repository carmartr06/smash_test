package com.smash.test.repository;

import com.smash.test.entities.CellPhone;
import org.springframework.data.repository.CrudRepository;

/**
 * CellPhone repository interface.
 * We extend from Crud Repository only since we only need basic operations.
 * If needed in the future this can be changed to other repository.
 */
public interface ICellPhoneRepository extends CrudRepository<CellPhone, Long> {
}
