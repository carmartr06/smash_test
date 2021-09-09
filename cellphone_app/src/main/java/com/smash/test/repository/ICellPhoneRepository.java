package com.smash.test.repository;

import com.smash.test.entities.CellPhone;
import org.springframework.data.repository.CrudRepository;

public interface ICellPhoneRepository extends CrudRepository<CellPhone, Long> {
}
