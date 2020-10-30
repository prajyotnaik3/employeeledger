package com.prajyot.rest.employeeledger.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="EMPLOYEE")
@Entity
public class Employee implements Serializable{
	
	@Id
	@Column(name="EMPLOYEECODE", updatable = false)
	private Integer employeeCode;
	
	@Column(name="NAME", updatable = true)
	private String name;
	
	@Column(name="DESIGNATION", updatable=true)
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = -6380749575516426900L;

}
