package com.prajyot.rest.employeeledger.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee{
	
	@Id
	private Integer employeeCode;

	private String name;

	private String designation;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer employeeCode, String name, String designation) {
		super();
		this.employeeCode = employeeCode;
		this.name = name;
		this.designation = designation;
	}
	
	public Integer getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Integer employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
