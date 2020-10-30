package com.prajyot.rest.employeeledger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.prajyot.rest.employeeledger.domain.Employee;
import com.prajyot.rest.employeeledger.repository.EmployeeRepository;

public class DBInit implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		   Employee paul = new Employee(101, "Paul White", "JS Developer");
		   
		   paul = employeeRepository.save(paul);
		   
		   Employee sean = new Employee(102, "Sean Phillips", "HR Recruiter");
		   sean = employeeRepository.save(sean);
		   
		   Employee adam = new Employee(103, "Adam Dirt", ".Net Developer");
		   adam = employeeRepository.save(adam);

	}

}
