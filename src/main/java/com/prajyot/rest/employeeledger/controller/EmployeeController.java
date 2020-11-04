package com.prajyot.rest.employeeledger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prajyot.rest.employeeledger.domain.Employee;
import com.prajyot.rest.employeeledger.exception.ResourceNotFoundException;
import com.prajyot.rest.employeeledger.repository.EmployeeRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//Create an Employee
	@PostMapping(value = "/addEmployee")
	//@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		//Employee n = new Employee(employeeCode, name, designation);
	    employeeRepository.save(employee);
	    return ResponseEntity.ok().build();
	 }
	//curl -X POST -d employeeCode=104 -d name="John White" -d designation="Web Developer" http://localhost:8080/addEmployee/
	
	//Read all the employees
	@GetMapping(value = "/getEmployees")
	public Iterable<Employee> getAllEmployees(){ 
		return employeeRepository.findAll();
	}
	//curl -X GET http://localhost:8080/getEmployees/

	@GetMapping(value = "/getEmployees/{employeeCode}")
	   public Employee findByEmployeeCode(@PathVariable Integer employeeCode){ 
	         return employeeRepository.findById(employeeCode).orElseThrow(() -> new ResourceNotFoundException("Employee [employeeCode="+employeeCode+"] can't be found"));
	   }
	//curl -X GET http://localhost:8080/getEmployees/101
	
	//Delete an employee
	@DeleteMapping(value = "/deleteEmployees/{employeeCode}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeCode){
		return employeeRepository.findById(employeeCode).map(employee -> {
		employeeRepository.delete(employee);
		return ResponseEntity.ok().build();
		}
        ).orElseThrow(() -> new ResourceNotFoundException("Employee [employeeCode="+employeeCode+"] can't be found"));
	}
	//curl -s -i -H "Content-Type: application/json;accept: application/json" -X DELETE http://localhost:8080/deleteEmployees/104
	
	//Update an employee
	@PutMapping(value = "/updateEmployees/{employeeCode}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer employeeCode, @RequestBody Employee newEmployee){
		return employeeRepository.findById(employeeCode).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setDesignation(newEmployee.getDesignation());
			employeeRepository.save(employee);
			return ResponseEntity.ok(employee);
		}).orElseThrow(() -> new ResourceNotFoundException("Employee [employeeCode="+employeeCode+"] can't be found"));	
	}
	//curl -s -H "Content-Type: application/json;accept: application/json" -X PUT -d "{\"employeeCode\":103,\"name\":\"Adam Hold\",\"designation\":\".Net Developer\"}" http://localhost:8080/updateEmployees/103
}
