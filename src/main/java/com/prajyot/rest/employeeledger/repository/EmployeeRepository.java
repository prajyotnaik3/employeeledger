package com.prajyot.rest.employeeledger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prajyot.rest.employeeledger.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
