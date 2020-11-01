package com.prajyot.rest.employeeledger.repository;

import org.springframework.data.repository.CrudRepository;
import com.prajyot.rest.employeeledger.domain.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
